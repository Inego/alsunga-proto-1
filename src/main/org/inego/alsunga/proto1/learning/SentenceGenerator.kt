package org.inego.alsunga.proto1.learning

import org.inego.alsunga.proto1.languages.Language

interface SentenceGenerator {

    fun generateSentence(learningBase: LearningBase, sourceLanguage: Language, generationStrategy: GenerationStrategy): GenerationProcess

}