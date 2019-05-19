package org.inego.alsunga.proto1.semantics.scene

import org.inego.alsunga.proto1.semantics.knowledge.Attribute

interface SceneAttributeNode : SceneRelationNode {
    override val relation: Attribute

    val target: SceneNode

}