package org.inego.alsunga.proto1.semantics.knowledge

interface Ontology {

    fun findRelationById(id: String): Relation

    fun findAttributeById(id: String, create: Boolean): Attribute

}

