package org.inego.alsunga.proto1.semantics.knowledge

interface Ontology {

    fun findRelationById(id: String): Relation

    fun findAttributeById(id: String): Attribute

    fun findEntityById(id: String): Entity

}

