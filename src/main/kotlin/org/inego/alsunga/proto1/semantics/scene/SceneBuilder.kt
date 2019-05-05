package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Ontology

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

    fun entity(entityId: String, vararg attrIds: String): SceneEntityNodeImpl {
        val result = SceneEntityNodeImpl(ontology.findEntityById(entityId))
        scene.nodes += result
        attrIds.mapTo(result.attributes, ontology::findAttributeById)
        return result
    }

}

class SceneRelationBuilder(val sceneRelation: SceneRelationImpl, val sceneBuilder: SceneBuilder) {

    fun slot(slotId: String, node: SceneNode) {
        sceneRelation.fillSlot(slotId, node)
    }

}
