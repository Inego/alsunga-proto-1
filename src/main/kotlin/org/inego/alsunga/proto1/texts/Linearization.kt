package org.inego.alsunga.proto1.texts

import org.inego.alsunga.proto1.languages.Language
import org.inego.alsunga.proto1.semantics.scene.Scene

interface Linearization {

    val language: Language

    val scene: Scene

    val text: String

    val grammaticalGraph: GrammaticalGraph

    val ranges: Collection<TextRange>

}