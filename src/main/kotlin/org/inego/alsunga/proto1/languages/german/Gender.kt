package org.inego.alsunga.proto1.languages.german

import org.inego.alsunga.proto1.texts.EnumFeatureValue
import org.inego.alsunga.proto1.texts.GrammaticalFeature

enum class Gender (val short: String) : EnumFeatureValue {
    MASCULINE("M"),
    FEMININE("F"),
    NEUTER("N");

    override fun toString() = short

    object Feature : GrammaticalFeature<Gender>

    override val feature = Feature
}
