package org.inego.alsunga.proto1.languages

import org.inego.alsunga.proto1.semantics.scene.Scene
import org.inego.alsunga.proto1.texts.Linearization

interface Language {

    fun linearize(scene: Scene): Linearization

}