package org.inego.alsunga.proto1.semantics.knowledge

interface RelationSlot {

    val id: String

    val relation: Relation

    val attributes: Collection<Attribute>
}