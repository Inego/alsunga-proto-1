package org.inego.alsunga.proto1.languages.german

interface Declined {
    fun decline(case: Case, gender: Gender, number: Number): String
}