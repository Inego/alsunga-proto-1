package org.inego.alsunga.proto1.languages.german

abstract class EntityWithDecliner : EntityWithDeclension {
    abstract val stem: String

    abstract val decliner: Decliner

    override fun decline(case: Case, gender: Gender, number: Number) =
            decliner.decline(stem, case, gender, number)
}