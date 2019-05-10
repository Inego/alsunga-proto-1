package org.inego.alsunga.proto1.semantics.knowledge


// TODO refactor to inherit from AbstractRelationImpl (create)
class AttributeImpl(override val id: String) : RelationImpl(id),  Attribute {

    init {
        slots += RelationSlotImpl("entity", this)
    }

    override val slot: RelationSlot
        get() = slots[0]

    override val edges = mutableListOf<AttributeEdge>()
}