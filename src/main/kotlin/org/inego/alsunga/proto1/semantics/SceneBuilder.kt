package org.inego.alsunga.proto1.semantics

import org.inego.alsunga.proto1.semantics.knowledge.Ontology
import org.inego.alsunga.proto1.semantics.knowledge.Relation

class SceneBuilder(private val ontology: Ontology) {

    fun relation(id: String): SceneRelationBuilder {
        val relation = ontology.findRelationById(id)
        return SceneRelationBuilder(relation)
    }

}

class SceneRelationBuilder(val relation: Relation)
