package org.inego.alsunga.proto1.semantics.knowledge

class OntologyImpl : Ontology {
    private val relationIdx: MutableMap<String, Relation> = mutableMapOf()

    fun relation(relationId: String, block: RelationImpl.() -> Unit) = RelationImpl(relationId).apply {
        relationIdx[relationId] = this
        this.block()
    }

    fun action(relationId: String, block: RelationImpl.() -> Unit) = relation(relationId, block).apply {
        kinds.add(RelationKind.ACTION)
    }

    override fun findRelationById(id: String): Relation = relationIdx[id]
            ?: error("Relation id '$id' not found")

}