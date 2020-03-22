package com.tamimattafi.backend.demo.services

import com.tamimattafi.backend.demo.database.entities.global.EntityConverter
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import org.springframework.data.repository.reactive.RxJava2CrudRepository

abstract class RxSimpleService<T, E>(protected open val repository: RxJava2CrudRepository<E, Long>)  {

    protected abstract val converter: EntityConverter<T, E>

    open fun insert(model: T): Single<T>
        = repository.save(converter.fromModel(model))
            .map(converter::toModel)

    open fun get(id: Long): Maybe<T>
        = repository.findById(id)
            .map(converter::toModel)

    open fun getAll(): Single<ArrayList<T>>
        = repository.findAll()
            .toList()
            .map(converter::toModels)

    open fun delete(model: T): Completable
        = repository.delete(converter.fromModel(model))

}