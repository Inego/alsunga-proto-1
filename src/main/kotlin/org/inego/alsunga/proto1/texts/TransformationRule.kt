package org.inego.alsunga.proto1.texts

import org.inego.alsunga.proto1.semantics.scene.Scene

interface TransformationRule {

    val semanticTemplate: Scene
    val grammaticTemplate: GrammaticalGraph

//    fun apply(G)

}