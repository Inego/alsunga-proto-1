package org.inego.alsunga.proto1.semantics

interface Scene {

    val nodes: Collection<SceneNode>

    val relations: Collection<SceneNodeRelation>

}