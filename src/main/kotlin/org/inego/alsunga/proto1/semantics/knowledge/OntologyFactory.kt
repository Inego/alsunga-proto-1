package org.inego.alsunga.proto1.semantics.knowledge

import org.inego.alsunga.proto1.semantics.knowledge.builders.OntologyBuilder

object OntologyFactory {

    val sampleOntology by lazy {

        OntologyBuilder.new {
            attr("visible")

            attr("countable_entity") {
                isAttr("visible")
            }

            attr("can_see")

            attr("merry")

            attr("living") {
                isAttr("countable_entity")
            }
            attr("animal") {
                isAttr("living")
                isAttr("can_see")
            }
            attr("human") {
                isAttr("animal")
                commonAttr("merry")
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

    @JvmStatic
    fun main(args: Array<String>) {
        sampleOntology
    }

}