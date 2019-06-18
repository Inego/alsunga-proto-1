package org.inego.alsunga.proto1.languages.german

import org.inego.alsunga.proto1.texts.AbstractGrammaticalNode
import org.inego.alsunga.proto1.texts.GrammaticalFeature
import org.inego.alsunga.proto1.texts.Token

abstract class Noun(
        stem: String,
        decliner: Decliner,
        val gender: Gender
)
    : SimpleEntityWithDecliner(stem, decliner) {

}

object NounSchwester : Noun("Schwester", SchwesterDecliner, Gender.FEMININE)

object SchwesterDecliner : SimpleDecliner() {
    override fun getEnding(case: Case, gender: Gender, number: Number) = if (number == Number.PLURAL) "n" else ""
}

class NounGroup(private val noun: Noun) : AbstractGrammaticalNode() {

    @Suppress("UNCHECKED_CAST")
    override fun <T> getIntrinsic(feature: GrammaticalFeature<T>): T? {
        return when (feature) {
            Gender.Feature -> noun.gender as T
            else -> super.getIntrinsic(feature)
        }
    }

    override val toText: List<Token>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

}