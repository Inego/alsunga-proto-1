package org.inego.alsunga.proto1.semantics.knowledge

open class RelationImpl(
        override val id: String
) : Relation {

    override val slots: MutableList<RelationSlot> = mutableListOf()

    fun addSlot(slot: RelationSlot) {
        slots += slot
    }

}
