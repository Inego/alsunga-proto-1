package org.inego.alsunga.proto1.languages.german

open class SeparableParticle(val particle: String)

object SeparableParticleZu : SeparableParticle("zu")

enum class Tense {
    PRAESENS,
    PRAETERITUM,
    FUTUR_I,
    PERFEKT,
    PLUSQUAMPERFEKT,
    FUTUR_II,
}

interface Conjugated {
    val infinitiv: String
    val partizipPraesens: String
    val partizipPerfekt: String

    // TODO support Modus
    fun conjugate(person: Person, number: Number, tense: Tense): String
}

abstract class FullVerb(
        open val separableParticle: SeparableParticle?,
        open val baseVerb: Conjugated
)


class RegularVerb(val stem: String) : Conjugated {
    override val infinitiv = stem + "en"
    override val partizipPraesens = stem + "end"
    override val partizipPerfekt = "ge" + stem + "t"

    override fun conjugate(person: Person, number: Number, tense: Tense): String {
        val ending = when (tense) {
            Tense.PRAESENS -> when (number) {
                Number.SINGULAR -> when (person) {
                    Person.FIRST -> "e"
                    Person.SECOND -> "st"
                    Person.THIRD -> "t"
                }
                Number.PLURAL -> when (person) {
                    Person.FIRST -> "en"
                    Person.SECOND -> "t"
                    Person.THIRD -> "en"
                }
            }
            else -> TODO("not implemented")
        }
        return stem + ending
    }

}

object Zuhoeren : FullVerb(
        SeparableParticleZu,
        RegularVerb("hör")
)
