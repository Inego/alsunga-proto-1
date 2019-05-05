package org.inego.alsunga.proto1

import org.inego.alsunga.proto1.semantics.scene.SceneBuilder
import org.inego.alsunga.proto1.semantics.knowledge.OntologyFactory


fun main() {

    val ontology = OntologyFactory.sampleOntology

    val scene = SceneBuilder(ontology).build {
        rel("see") {
            slot("actor", entity("speaker"))
            slot("object", entity("human").underRelation("merry") {})
        }
    }

    print(scene)

}