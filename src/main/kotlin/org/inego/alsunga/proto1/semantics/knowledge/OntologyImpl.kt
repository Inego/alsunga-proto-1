package org.inego.alsunga.proto1.semantics.knowledge

class OntologyImpl : Ontology {

    private val relationIdx: MutableMap<String, Relation> = mutableMapOf()

    fun relation(relationId: String, block: RelationImpl.() -> Unit) = RelationImpl(relationId).apply {
        relationIdx[relationId] = this
        this.block()
    }

    override fun findRelationById(id: String): Relation = relationIdx[id]
            ?: error("Relation id '$id' not found")

    override fun findAttributeById(id: String, create: Boolean): Attribute {
        val foundRelation = relationIdx[id]
        return (foundRelation
                ?: if (create) AttributeImpl(id).also { addRelation(it) }
                else error("Attribute id '$id' not found")) as Attribute
    }

    fun addRelation(relation: Relation) {
        relationIdx[relation.id] = relation
    }

}