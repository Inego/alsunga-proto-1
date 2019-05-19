package org.inego.alsunga.proto1.languages.german

abstract class Noun(
        stem: String,
        decliner: Decliner,
        gender: Gender
)
    : SimpleEntityWithDecliner(stem, decliner)

object NounSchwester : Noun("Schwester", SchwesterDecliner, Gender.FEMININE)

object SchwesterDecliner : SimpleDecliner() {
    override fun getEnding(case: Case, gender: Gender, number: Number) = if (number == Number.PLURAL) "n" else ""
}
