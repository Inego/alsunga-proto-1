package org.inego.alsunga.proto1.texts

open class Token(val content: String) {
    open val stickyLeft = false
    open val stickyRight = false
}


val String.asToken
    get() = Token(this)

val String?.asText: List<Token>
    get() = if (this == null) emptyList() else listOf(this.asToken)

open class ClassicPunctuation(content: String) : Token(content) {
    override val stickyLeft = true
}

object Period : ClassicPunctuation(".")

object Comma : ClassicPunctuation(",")
