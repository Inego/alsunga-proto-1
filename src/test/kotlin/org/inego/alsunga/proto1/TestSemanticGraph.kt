package org.inego.alsunga.proto1

import org.inego.alsunga.proto1.semantics.scene.SceneBuilder
import org.inego.alsunga.proto1.semantics.knowledge.OntologyFactory


fun main() {

    val ontology = OntologyFactory.sampleOntology

    val scene = SceneBuilder(ontology).build {

        rel("siblings") {
            slot("sibling", entity("speaker"))
            slot("sibling", entity("female"))
        }

        rel("see") {
            slot("actor", nodeWithAttr("female"))
            slot("object", entity("book", "big"))
        }

    }

    print(scene)
}