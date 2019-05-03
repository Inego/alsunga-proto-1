package org.inego.alsunga.proto1.semantics.knowledge

class OntologyBuilder {
    private val ontology = OntologyImpl()

    fun build() = ontology

    fun slotAttribute(attributeId: String) = ontology.slotAttribute(attributeId)

    fun relation(relationId: String, block: RelationBuilder.() -> Unit) =
            RelationBuilder(this, relationId)
                    .apply(block)
                    .also{
                        ontology.addRelation(it.build())
                    }

    fun findSlotAttributeById(attributeId: String): SlotAttribute = ontology.slotAttributeIdx[attributeId]
            ?: error("Unknown slot attribute '$attributeId'")

    companion object {
        fun new(block: OntologyBuilder.() -> Unit) = OntologyBuilder().apply(block)
    }

}