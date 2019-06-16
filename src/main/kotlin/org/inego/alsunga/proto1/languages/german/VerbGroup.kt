package org.inego.alsunga.proto1.languages.german

import org.inego.alsunga.proto1.texts.*

open class SeparableParticle(val particle: String)

object SeparableParticleZu : SeparableParticle("zu")

enum class Tense : EnumFeatureValue {
    PRAESENS,
    PRAETERITUM,
    FUTUR_I,
    PERFEKT,
    PLUSQUAMPERFEKT,
    FUTUR_II;

    object Feature : GrammaticalFeature<Tense>
    override val feature = Feature
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


class RegularVerb(private val stem: String) : Conjugated {
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

class VerbGroup (
        val fullVerb: FullVerb
) : AbstractGrammaticalNode() {

    init {
        setDynamic(Person.FIRST, Number.SINGULAR, Tense.PRAESENS)
    }

    val person = getDynamic(Person.Feature)
    val number = getDynamic(Number.Feature)
    val tense = getDynamic(Tense.Feature)

    override val toText: List<Token>
        get() {
            return fullVerb.baseVerb.conjugate(person, number, tense).asText +
                    internalChildren.flatMap { it.toText } +
                    fullVerb.separableParticle?.particle.asText
        }
}