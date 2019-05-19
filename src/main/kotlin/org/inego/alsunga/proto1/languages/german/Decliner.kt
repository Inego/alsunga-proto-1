package org.inego.alsunga.proto1.languages.german

interface Decliner {
    fun decline(stem: String, case: Case, gender: Gender, number: Number): String
}

abstract class SimpleDecliner : Decliner {
    abstract fun getEnding(case: Case, gender: Gender, number: Number): String

    override fun decline(stem: String, case: Case, gender: Gender, number: Number) =
            stem + getEnding(case, gender, number)
}

object MeinDecliner : SimpleDecliner() {
    override fun getEnding(case: Case, gender: Gender, number: Number) = if (number == Number.PLURAL) {
        when (case) {
            Case.NOMINATIVE, Case.ACCUSATIVE -> "e"
            Case.DATIVE -> "en"
            Case.GENITIVE -> "er"
        }
    } else when (gender) {
        Gender.MASCULINE -> when (case) {
            Case.NOMINATIVE -> ""
            Case.ACCUSATIVE -> "en"
            Case.DATIVE -> "em"
            Case.GENITIVE -> "es"
        }
        Gender.FEMININE -> when (case) {
            Case.NOMINATIVE -> "e"
            Case.ACCUSATIVE -> "e"
            Case.DATIVE -> "er"
            Case.GENITIVE -> "er"
        }
        Gender.NEUTER -> when (case) {
            Case.NOMINATIVE -> ""
            Case.ACCUSATIVE -> ""
            Case.DATIVE -> "em"
            Case.GENITIVE -> "es"
        }
    }

}