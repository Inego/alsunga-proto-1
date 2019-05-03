package org.inego.alsunga.proto1.semantics.knowledge

class EntityImpl(
        override val id: String
) : Entity {

    val attributes = mutableSetOf<Attribute>()

}