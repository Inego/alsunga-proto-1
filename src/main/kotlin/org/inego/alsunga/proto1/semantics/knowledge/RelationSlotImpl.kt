package org.inego.alsunga.proto1.semantics.knowledge

class RelationSlotImpl(override val id: String, override val relation: Relation) : RelationSlot {

    override val attributes: MutableList<SlotAttribute> = mutableListOf()

    fun which(attributeId: String) {

    }

}
