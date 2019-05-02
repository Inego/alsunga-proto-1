package org.inego.alsunga.proto1.semantics.knowledge

class RelationImpl(
        override val id: String
) : Relation {
    fun slot(slotId: String, block: RelationSlot.() -> Unit) = RelationSlotImpl(slotId, this).apply {

    }

    override val kinds: MutableSet<RelationKind> = mutableSetOf()

    override val slots: MutableList<RelationSlot> = mutableListOf()

}
