package org.inego.alsunga.proto1.texts

abstract class Token(val content: String) {
    open val stickyLeft = false
    open val stickyRight = false
}


open class ClassicPunctuation(content: String) : Token(content) {
    override val stickyLeft = true
}

object Period : ClassicPunctuation(".")