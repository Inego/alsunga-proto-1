package org.inego.alsunga.proto1

import org.inego.alsunga.proto1.languages.german.*
import org.inego.alsunga.proto1.languages.german.Number
import org.inego.alsunga.proto1.texts.GrammaticalNode

fun main() {

    VerbGroup(Zuhoeren).builder {
        add(Subject())
    }

//    declineNoun()

}

private fun declineNoun() {
    for (number in Number.values()) {
        for (gender in Gender.values()) {
            for (case in Case.values()) {

                println("$number, $gender, $case: ${PossessiveDeterminerMein.decline(case, gender, number)}")

            }
        }
    }
}