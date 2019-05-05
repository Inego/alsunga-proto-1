package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Attribute
import org.inego.alsunga.proto1.semantics.knowledge.Entity

class SceneEntityNodeImpl(
        override val entity: Entity
) : SceneEntityNode {
    override val attributes = mutableSetOf<Attribute>()
}