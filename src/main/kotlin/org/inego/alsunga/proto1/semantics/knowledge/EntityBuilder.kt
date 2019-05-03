package org.inego.alsunga.proto1.semantics.knowledge


class EntityBuilder(val ontologyBuilder: OntologyBuilder, id: String) {
    private val entity = EntityImpl(id)

    fun build(): Entity = entity

    fun attr(attributeId: String) {
        entity.attributes.add(ontologyBuilder.findAttributeById(attributeId))
    }
}
