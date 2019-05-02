package org.inego.alsunga.proto1.semantics

import org.inego.alsunga.proto1.semantics.knowledge.RelationSlot

interface SceneNodeRelationSlot {
    val relationSlot: RelationSlot
    val targetNode: SceneNode
}