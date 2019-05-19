package org.inego.alsunga.proto1.semantics.knowledge


// TODO refactor to inherit from AbstractRelationImpl (create)
class AttributeImpl(override val id: String) : Attribute {

    override val slots: Collection<RelationSlot>
        get() = listOf(slot)

    override val slot: RelationSlot = RelationSlotImpl("entity", this)

    override val edges = mutableListOf<AttributeEdge>()
}