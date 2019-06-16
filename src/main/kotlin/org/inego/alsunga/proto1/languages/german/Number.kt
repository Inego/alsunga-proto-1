package org.inego.alsunga.proto1.languages.german

import org.inego.alsunga.proto1.texts.EnumFeatureValue
import org.inego.alsunga.proto1.texts.GrammaticalFeature

enum class Number (val short: String) : EnumFeatureValue {
    SINGULAR("SG"),
    PLURAL("PL");

    override fun toString() = short

    object Feature : GrammaticalFeature<Number>
    override val feature = Feature
}