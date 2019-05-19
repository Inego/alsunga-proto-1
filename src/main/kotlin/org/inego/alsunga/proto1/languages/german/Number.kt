package org.inego.alsunga.proto1.languages.german

enum class Number (val short: String) {
    SINGULAR("SG"),
    PLURAL("PL");

    override fun toString() = short
}