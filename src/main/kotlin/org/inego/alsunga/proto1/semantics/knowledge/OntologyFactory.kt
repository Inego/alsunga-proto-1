package org.inego.alsunga.proto1.semantics.knowledge

object OntologyFactory {

    val sampleOntology by lazy {

        OntologyBuilder.new {
            attr("can_see")
            attr("visible")
            attr("living") {
                isAttr("countable_entity")
            }
            attr("animal") {
                isAttr("living")
            }
            attr("human") {
                isAttr("animal")
            }

            relation("see") {

                slot("actor") {
                    required("can_see")
                }

                slot("object") {
                    required("visible")
                }
            }

            entity("speaker") {
                attr("human")
            }

            entity("human") {
                attr("human")
            }

        }.build()

    }

}