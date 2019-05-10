package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Relation
import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot
import java.lang.AssertionError
import java.lang.RuntimeException
import java.util.NoSuchElementException

class SceneRelationImpl(override val relation: Relation) : SceneRelation {
    override val slots = mutableMapOf<RelationSlot, SceneNode>()

    override fun get(slot: RelationSlot): SceneNode {
        return slots[slot] ?: throw AssertionError("Slot '${slot.id}' not found")
    }

    fun fillSlot(slotId: String, node: SceneNode) {
        val relationSlot = try {
            relation.slots.first { it.id == slotId }
        } catch (e: NoSuchElementException) {
            throw RuntimeException("Relation '${relation.id}': cannot find slot '$slotId'}")
        }
        slots[relationSlot] = node
    }

    fun fillSlot(slot: RelationSlot, node: SceneNode) {
        slots[slot] = node
    }

    fun fillSlot(idx: Int, node: SceneNode) {
        fillSlot(relation.slots.elementAt(idx), node)
    }

}
