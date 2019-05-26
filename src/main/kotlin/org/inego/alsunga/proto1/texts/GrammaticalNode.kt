package org.inego.alsunga.proto1.texts

interface GrammaticalNode {
    val children: List<GrammaticalNode>

    val toText: List<Token>
}


abstract class AbstractGrammaticalNode : GrammaticalNode {
    private val internalChildren = mutableListOf<GrammaticalNode>()

    override val children = internalChildren
}