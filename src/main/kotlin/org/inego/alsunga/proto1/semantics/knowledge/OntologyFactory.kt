package org.inego.alsunga.proto1.semantics.knowledge

object OntologyFactory {

    val sampleOntology by lazy {

        OntologyBuilder.new {
            slotAttribute("can_see")
            slotAttribute("visible")

            relation("see") {

                slot("actor") {
                    which("can_see")
                }

                slot("object") {
                    which("visible")
                }
            }
        }.build()

    }

}