package org.inego.alsunga.proto1.semantics.knowledge

class OntologyBuilder {
    private val ontology = OntologyImpl()

    fun build() = ontology

    fun attr(id: String, block: AttributeBuilder.() -> Unit) = AttributeBuilder(this, id)
            .apply(block).also {
                ontology.addAttribute(it.build())
            }

    fun attr(id: String) = attr(id) { }

    fun relation(id: String, block: RelationBuilder.() -> Unit) =
            RelationBuilder(this, id)
                    .apply(block)
                    .also{
                        ontology.addRelation(it.build())
                    }

    fun findAttributeById(attributeId: String): Attribute = ontology.attributeIdx[attributeId]
            ?: error("Unknown attribute '$attributeId'")

    fun entity(id: String, block: EntityBuilder.() -> Unit) = EntityBuilder(this, id)
            .apply(block)
            .also {
                ontology.addEntity(it.build())
            }

    companion object {
        fun new(block: OntologyBuilder.() -> Unit) = OntologyBuilder().apply(block)
    }

}