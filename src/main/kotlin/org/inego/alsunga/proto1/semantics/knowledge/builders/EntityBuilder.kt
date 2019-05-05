package org.inego.alsunga.proto1.semantics.knowledge.builders

import org.inego.alsunga.proto1.semantics.knowledge.Entity
import org.inego.alsunga.proto1.semantics.knowledge.EntityImpl


class EntityBuilder(val ontologyBuilder: OntologyBuilder, id: String) {
    private val entity = EntityImpl(id)

    fun build(): Entity = entity

    fun attr(id: String) {
        entity.attributes.add(ontologyBuilder.findAttributeById(id))
    }
}
