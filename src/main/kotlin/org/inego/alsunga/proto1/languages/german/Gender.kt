package org.inego.alsunga.proto1.languages.german

enum class Gender (val short: String) {
    MASCULINE("M"),
    FEMININE("F"),
    NEUTER("N");

    override fun toString() = short

}
