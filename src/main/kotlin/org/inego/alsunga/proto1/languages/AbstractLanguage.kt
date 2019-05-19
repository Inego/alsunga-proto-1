package org.inego.alsunga.proto1.languages

import org.inego.alsunga.proto1.semantics.scene.Scene
import org.inego.alsunga.proto1.texts.Linearization
import org.inego.alsunga.proto1.texts.TransformationRule

abstract class AbstractLanguage : Language {

    val rules = mutableListOf<TransformationRule>()

    override fun linearize(scene: Scene): Linearization {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}