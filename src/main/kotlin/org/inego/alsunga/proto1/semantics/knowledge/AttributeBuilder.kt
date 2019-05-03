package org.inego.alsunga.proto1.semantics.knowledge

class AttributeBuilder(
        private val ontologyBuilder: OntologyBuilder,
        attributeId: String
) {

    private val attribute = AttributeImpl(attributeId)

    fun build() = attribute

    fun isAttr(attributeId: String) {
        attr(attributeId, AttributeLikelihood.IS)
    }

    fun attr(attributeId: String, likelihood: AttributeLikelihood) {
        attribute.edges += AttributeEdgeImpl(ontologyBuilder.findAttributeById(attributeId), likelihood)
    }

}