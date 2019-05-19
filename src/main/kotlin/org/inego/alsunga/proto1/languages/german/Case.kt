package org.inego.alsunga.proto1.languages.german

enum class Case (val short: String) {
    NOMINATIVE("Nom"),
    ACCUSATIVE("Acc"),
    DATIVE("Dat"),
    GENITIVE("Gen");

    override fun toString() = short
}