package org.inego.alsunga.proto1.semantics.knowledge.builders

import org.inego.alsunga.proto1.semantics.knowledge.AttributeEdgeImpl
import org.inego.alsunga.proto1.semantics.knowledge.AttributeImpl
import org.inego.alsunga.proto1.semantics.knowledge.AttributeLikelihood

class AttributeBuilder(
        private val ontologyBuilder: OntologyBuilder,
        attributeId: String
) {

    private val attribute = AttributeImpl(attributeId)

    fun build() = attribute

    fun isAttr(attributeId: String) {
        attr(attributeId, AttributeLikelihood.IS)
    }

    fun commonAttr(attributeId: String) {
        attr(attributeId, AttributeLikelihood.COMMON)
    }

    fun attr(attributeId: String, likelihood: AttributeLikelihood) {
        attribute.edges += AttributeEdgeImpl(ontologyBuilder.findAttributeById(attributeId, true), likelihood)
    }

}