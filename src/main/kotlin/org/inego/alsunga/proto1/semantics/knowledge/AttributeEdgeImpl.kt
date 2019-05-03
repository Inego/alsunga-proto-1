package org.inego.alsunga.proto1.semantics.knowledge

data class AttributeEdgeImpl(
        override val attribute: Attribute,
        override val likelihood: AttributeLikelihood
) : AttributeEdge