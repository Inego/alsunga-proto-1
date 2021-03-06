package org.inego.alsunga.proto1.semantics.knowledge.builders

import org.inego.alsunga.proto1.semantics.knowledge.RelationSlotImpl

class SlotBuilder(
        private val relationBuilder: RelationBuilder,
        slotId: String
) {
    private val slot = RelationSlotImpl(slotId, relationBuilder.relation)

    fun build() = slot

    fun required(attributeId: String) {
        slot.attributes.add(relationBuilder.ontologyBuilder.findAttributeById(attributeId))
    }

}
