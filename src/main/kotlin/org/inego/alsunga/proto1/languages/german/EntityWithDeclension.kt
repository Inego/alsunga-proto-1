package org.inego.alsunga.proto1.languages.german

interface EntityWithDeclension {
    fun decline(case: Case, gender: Gender, number: Number): String
}