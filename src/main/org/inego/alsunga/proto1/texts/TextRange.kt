package org.inego.alsunga.proto1.texts

interface TextRange {

    val places: Collection<IntRange>

    val correspondingRange: TextRange

    val grammaticalNode: GrammaticalNode

}