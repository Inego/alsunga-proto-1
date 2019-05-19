package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Attribute
import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot

class SceneAttributeNodeImpl(
        override val relation: Attribute,
        override val target: SceneNode
) : SceneAttributeNode {

    override val slots: Map<RelationSlot, SceneNode>
        get() = mapOf(relation.slot to target)

    override fun get(slot: RelationSlot): SceneNode =
            if (slot == relation.slot)
                target
            else throw AssertionError("Slot '${slot.id}' not found")
}