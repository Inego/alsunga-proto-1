package org.inego.alsunga.proto1.semantics.knowledge

interface Attribute {

    val id: String

    val edges: Collection<AttributeEdge>

}