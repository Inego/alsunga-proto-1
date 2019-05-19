package org.inego.alsunga.proto1.languages.german

open class SimpleEntityWithDecliner(
        override val stem: String,
        override val decliner: Decliner
) : EntityWithDecliner()
