package org.inego.alsunga.proto1.texts

import org.inego.alsunga.proto1.semantics.knowledge.Ontology
import org.inego.alsunga.proto1.semantics.scene.Scene

interface Linearizer {

    fun produceLinearizations(ontology: Ontology, scene: Scene): Sequence<Linearization>

}