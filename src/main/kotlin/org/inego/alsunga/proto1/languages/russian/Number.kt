package org.inego.alsunga.proto1.languages.russian

enum class Number(val short: String) {
    SINGULAR("SG"),
    PLURAL("PL");

    override fun toString() = short
}