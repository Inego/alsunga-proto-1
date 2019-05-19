package org.inego.alsunga.proto1.texts

interface GrammaticalNode {
    val children: Sequence<GrammaticalNode>
}


abstract class AbstractGrammaticalNode : GrammaticalNode {

    private val internalChildren = mutableListOf<GrammaticalNode>()

    override val children: Sequence<GrammaticalNode>
        get() = internalChildren.asSequence()
}