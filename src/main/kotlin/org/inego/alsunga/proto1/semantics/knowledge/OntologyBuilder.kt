package org.inego.alsunga.proto1.semantics.knowledge

class OntologyBuilder {
    private val ontology = OntologyImpl()

    fun build() = ontology

    fun attr(attributeId: String, block: AttributeBuilder.() -> Unit) = AttributeBuilder(this, attributeId)
            .apply(block).also {
                ontology.addAttribute(it.build())
            }

    fun attr(attributeId: String) = attr(attributeId) { }

    fun relation(relationId: String, block: RelationBuilder.() -> Unit) =
            RelationBuilder(this, relationId)
                    .apply(block)
                    .also{
                        ontology.addRelation(it.build())
                    }

    fun findAttributeById(attributeId: String): Attribute = ontology.attributeIdx[attributeId]
            ?: error("Unknown attribute '$attributeId'")

    fun entity(entityId: String, block: EntityBuilder.() -> Unit) = EntityBuilder(this, entityId)
            .apply(block)
            .also {
                ontology.addEntity(it.build())
            }

    companion object {
        fun new(block: OntologyBuilder.() -> Unit) = OntologyBuilder().apply(block)
    }

}