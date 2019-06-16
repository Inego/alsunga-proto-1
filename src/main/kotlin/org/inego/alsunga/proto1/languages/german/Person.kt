package org.inego.alsunga.proto1.languages.german

import org.inego.alsunga.proto1.texts.EnumFeatureValue
import org.inego.alsunga.proto1.texts.GrammaticalFeature

enum class Person : EnumFeatureValue {
    FIRST,
    SECOND,
    THIRD;

    object Feature : GrammaticalFeature<Person>
    override val feature = Feature
}