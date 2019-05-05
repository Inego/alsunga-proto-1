package org.inego.alsunga.proto1.semantics.knowledge

class OntologyImpl : Ontology {


    private val entityIdx: MutableMap<String, Entity> = mutableMapOf()

    private val relationIdx: MutableMap<String, Relation> = mutableMapOf()

    private val attributeIdx: MutableMap<String, Attribute> = mutableMapOf()

    fun relation(relationId: String, block: RelationImpl.() -> Unit) = RelationImpl(relationId).apply {
        relationIdx[relationId] = this
        this.block()
    }

    fun action(relationId: String, block: RelationImpl.() -> Unit) = relation(relationId, block).apply {
        kinds.add(RelationKind.ACTION)
    }

    override fun findRelationById(id: String): Relation = relationIdx[id]
            ?: error("Relation id '$id' not found")

    override fun findAttributeById(id: String): Attribute = attributeIdx[id]
            ?: error("Attribute id '$id' not found")

    override fun findEntityById(id: String): Entity = entityIdx[id]
            ?: error("Entity id '$id' not found")

    fun addRelation(relation: Relation) {
        relationIdx[relation.id] = relation
    }

    fun addEntity(entity: Entity) {
        entityIdx[entity.id] = entity
    }

    fun addAttribute(attribute: Attribute) {
        attributeIdx[attribute.id] = attribute
    }

}