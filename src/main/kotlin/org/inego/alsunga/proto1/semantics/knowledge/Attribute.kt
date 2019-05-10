package org.inego.alsunga.proto1.semantics.knowledge

/**
 * Special kind of relation with one slot and support of hierarchies / classification
 */
interface Attribute : Relation {

    val edges: Collection<AttributeEdge>

    val slot: RelationSlot

}