package org.inego.alsunga.proto1.languages.grammar

import org.inego.alsunga.proto1.texts.EnumFeatureValue
import org.inego.alsunga.proto1.texts.GrammaticalFeature

enum class SentenceRole : EnumFeatureValue {
    SUBJECT,
    OBJECT;

    object Feature : GrammaticalFeature<SentenceRole>

    override val feature = Feature
}