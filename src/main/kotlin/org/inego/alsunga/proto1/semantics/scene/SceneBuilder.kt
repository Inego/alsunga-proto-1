package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Attribute
import org.inego.alsunga.proto1.semantics.knowledge.Ontology
import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot

class SceneBuilder(val ontology: Ontology) {

    val scene = SceneImpl()

    fun rel(id: String, block: SceneRelationBuilder.() -> Unit) {

        val relation = ontology.findRelationById(id)
        val sceneRelation = SceneRelationImpl(relation)

        scene.relations += sceneRelation

        val sceneRelationBuilder = SceneRelationBuilder(sceneRelation, this)

        sceneRelationBuilder.apply(block)

    }

    fun build(block: SceneBuilder.() -> Unit): SceneImpl {
        block()
        return scene
    }

}

class SceneRelationBuilder(val sceneRelation: SceneRelationImpl, val sceneBuilder: SceneBuilder) {

    fun slot(slotId: String, nodeBuilder: SceneEntityNodeBuilder) {
        sceneRelation.fillSlot(slotId, nodeBuilder.build())
    }

    fun slot(slotId: String, node: SceneNode) {
        sceneRelation.fillSlot(slotId, node)
    }

    fun slot(slot: RelationSlot, node: SceneEntityNode) {
        sceneRelation.fillSlot(slot, node)
    }

    fun slot(idx: Int, node: SceneEntityNodeImpl) {
        sceneRelation.fillSlot(idx, node)
    }

    fun entity(vararg attrIds: String): SceneEntityNode {
        val entityNode = SceneEntityNodeImpl()
        sceneBuilder.scene.nodes += entityNode
        attrIds.forEach {
            sceneBuilder.rel(it) {
                slot(0, entityNode)
            }
        }
        return entityNode
    }

    fun nodeWithAttr(attrId: String): SceneNode {
        for (sceneRelation in sceneBuilder.scene.relations) {
            if (sceneRelation.relation is Attribute) {
                return sceneRelation[sceneRelation.relation.slot]
            }
        }
        throw AssertionError("Node with attribute '$attrId' not found")
    }

}

class SceneEntityNodeBuilder(val node: SceneEntityNodeImpl, val sceneBuilder: SceneBuilder) {
    fun build() = node

    fun underRelation(attributeId: String, block: SceneRelationBuilder.() -> Unit): SceneEntityNodeBuilder {

        sceneBuilder.rel(attributeId) {
            // Get first slot of this relation
            val firstSlot = sceneRelation.relation.slots.first()
            slot(firstSlot, node)
            block()
        }

        return this
    }
}

