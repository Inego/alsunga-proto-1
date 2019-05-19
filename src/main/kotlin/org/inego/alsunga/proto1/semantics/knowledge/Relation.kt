package org.inego.alsunga.proto1.semantics.knowledge

interface Relation {

    val id: String

    val slots: Collection<RelationSlot>

//    val kinds: Set<RelationKind>

}