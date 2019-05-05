package org.inego.alsunga.proto1.semantics.knowledge.builders

import org.inego.alsunga.proto1.semantics.knowledge.RelationImpl

class RelationBuilder(val ontologyBuilder: OntologyBuilder, relationId: String) {

    val relation = RelationImpl(relationId)

    fun build() = relation

    fun slot(slotId: String, block: SlotBuilder.() -> Unit) = SlotBuilder(this, slotId)
            .apply(block)
            .also {
                relation.addSlot(it.build())
            }
}