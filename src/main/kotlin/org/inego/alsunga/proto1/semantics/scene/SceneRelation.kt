package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Relation
import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot

interface SceneRelation {
    val relation: Relation

    val slots: Map<RelationSlot, SceneNode>

    operator fun get(slot: RelationSlot): SceneNode
}