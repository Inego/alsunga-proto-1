package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Ontology
import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot

class SceneBuilder(private val ontology: Ontology) {

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

    fun entity(entityId: String, vararg attrIds: String): SceneEntityNodeBuilder {
        val result = SceneEntityNodeImpl(ontology.findEntityById(entityId))
        scene.nodes += result
        attrIds.mapTo(result.attributes, ontology::findAttributeById)
        return SceneEntityNodeBuilder(result, this)
    }

}

class SceneRelationBuilder(val sceneRelation: SceneRelationImpl, val sceneBuilder: SceneBuilder) {

    fun slot(slotId: String, nodeBuilder: SceneEntityNodeBuilder) {
        sceneRelation.fillSlot(slotId, nodeBuilder.build())
    }

    fun slot(slotId: String, node: SceneEntityNode) {
        sceneRelation.fillSlot(slotId, node)
    }

    fun slot(slot: RelationSlot, node: SceneEntityNode) {
        sceneRelation.fillSlot(slot, node)
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

