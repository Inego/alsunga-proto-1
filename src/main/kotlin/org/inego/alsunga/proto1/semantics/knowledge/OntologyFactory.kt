package org.inego.alsunga.proto1.semantics.knowledge

object OntologyFactory {

    val sampleOntology by lazy {
        OntologyImpl().apply {
            relation("see") {
                slot("actor") {

                }
            }
        }
    }

}