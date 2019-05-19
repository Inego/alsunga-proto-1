package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Attribute
import org.inego.alsunga.proto1.semantics.knowledge.Ontology
import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot

class SceneBuilder(val ontology: Ontology) {

    val scene = SceneImpl()

    fun rel(id: String, block: SceneRelationBuilder.() -> Unit) {

        val relation = ontology.findRelationById(id)
        val sceneRelation = SceneRelationNodeImpl(relation)

        scene.nodes += sceneRelation

        val sceneRelationBuilder = SceneRelationBuilder(sceneRelation, this)

        sceneRelationBuilder.apply(block)
    }

    fun build(block: SceneBuilder.() -> Unit): SceneImpl {
        block()
        return scene
    }

    fun attr(attributeId: String, node: SceneEntityNodeImpl) {
        val attribute = ontology.findAttributeById(attributeId, false)
        scene.nodes += SceneAttributeNodeImpl(attribute, node)
    }
}

class SceneRelationBuilder(val sceneRelation: SceneRelationNodeImpl, val sceneBuilder: SceneBuilder) {

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

        val nodeBuilder = SceneEntityNodeBuilder(entityNode, sceneBuilder)

        attrIds.forEach {
            nodeBuilder.attr(it)
        }

        return entityNode
    }

    fun nodeWithAttr(attrId: String): SceneNode {

        for (node in sceneBuilder.scene.nodes) {
            if (node is SceneAttributeNode && node.relation.id == attrId) {
                return node.target
            }
        }
        throw AssertionError("Node with attribute '$attrId' not found")
    }

}

class SceneEntityNodeBuilder(val node: SceneEntityNodeImpl, val sceneBuilder: SceneBuilder) {
    fun build() = node

    fun attr(attributeId: String): SceneEntityNodeBuilder {
        sceneBuilder.attr(attributeId, node)
        return this
    }
}

