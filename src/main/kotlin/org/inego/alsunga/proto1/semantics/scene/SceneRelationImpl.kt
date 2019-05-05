package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Relation
import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot
import java.lang.RuntimeException
import java.util.NoSuchElementException

class SceneRelationImpl(override val relation: Relation) : SceneRelation {

    override val slots = mutableMapOf<RelationSlot, SceneNode>()

    fun fillSlot(slotId: String, node: SceneNode) {
        val relationSlot = try {
            relation.slots.first { it.id == slotId }
        } catch (e: NoSuchElementException) {
            throw RuntimeException("Relation '${relation.id}': cannot find slot '$slotId'}")
        }
        slots[relationSlot] = node
    }

}
