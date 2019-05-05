package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Attribute
import org.inego.alsunga.proto1.semantics.knowledge.Entity

interface SceneEntityNode : SceneNode {

    val entity: Entity

    val attributes: Collection<Attribute>

}