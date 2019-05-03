package org.inego.alsunga.proto1.semantics.knowledge

class AttributeImpl(override val id: String) : Attribute {

    override val edges = mutableListOf<AttributeEdge>()

}