package org.inego.alsunga.proto1.semantics.knowledge

import org.inego.alsunga.proto1.semantics.knowledge.builders.OntologyBuilder

object OntologyFactory {

    val sampleOntology by lazy {

        OntologyBuilder.new {
            attr("visible")

            attr("speaker")

            attr("listener")

            attr("countable_entity") {
                isAttr("visible")
            }

            attr("thing") {
                isAttr("countable_entity")
                commonAttr("big")
                commonAttr("small")

            }

            attr("book") {
                isAttr("thing")
            }

            attr("can_see")

            attr("living") {
                isAttr("countable_entity")
            }
            attr("animal") {
                isAttr("living")
                isAttr("can_see")
            }
            attr("human") {
                isAttr("animal")
            }

            attr("female") {
                isAttr("animal")
            }

            attr("male") {
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

            attr("speaker") {
                attr("human")
            }

            relation("merry") {
                slot("person") {
                    required("human")
                }
            }

            relation("siblings") {
                slot("sibling") {
                    required("human")
                }
            }

        }.build()

    }

    @JvmStatic
    fun main(args: Array<String>) {
        sampleOntology
    }

}