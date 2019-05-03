package org.inego.alsunga.proto1.semantics.knowledge

class RelationImpl(
        override val id: String
) : Relation {
    override val kinds: MutableSet<RelationKind> = mutableSetOf()

    override val slots: MutableList<RelationSlot> = mutableListOf()

    fun addSlot(slot: RelationSlot) {
        slots += slot
    }

}
