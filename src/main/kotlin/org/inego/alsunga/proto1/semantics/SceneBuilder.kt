package org.inego.alsunga.proto1.semantics

import org.inego.alsunga.proto1.languages.Language
import org.inego.alsunga.proto1.semantics.knowledge.Ontology
import org.inego.alsunga.proto1.semantics.knowledge.Relation

class SceneBuilder(private val ontology: Ontology) {

    fun relation(id: String): RelationBuilder {
        val relation = ontology.findRelationById(id)
        return RelationBuilder(relation)
    }

}

class RelationBuilder(val relation: Relation) {

}
