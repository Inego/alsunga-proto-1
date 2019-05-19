package org.inego.alsunga.proto1

import org.inego.alsunga.proto1.languages.german.Case
import org.inego.alsunga.proto1.languages.german.Gender
import org.inego.alsunga.proto1.languages.german.Number
import org.inego.alsunga.proto1.languages.german.PossessiveDeterminerMein

fun main() {

    for (number in Number.values()) {
        for (gender in Gender.values()) {
            for (case in Case.values()) {

                println("$number, $gender, $case: ${PossessiveDeterminerMein.decline(case, gender, number)}")

            }
        }
    }

}