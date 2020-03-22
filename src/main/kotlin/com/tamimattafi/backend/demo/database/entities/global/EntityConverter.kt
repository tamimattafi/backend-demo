package com.tamimattafi.backend.demo.database.entities.global

interface EntityConverter<T, E> {

    fun fromModel(model: T): E

    fun toModel(entity: E): T

    fun toModels(entities: Collection<E>): ArrayList<T>
        = ArrayList(entities.map(this::toModel))

    fun fromModels(models: Collection<T>): ArrayList<E>
        = ArrayList(models.map(this::fromModel))
}