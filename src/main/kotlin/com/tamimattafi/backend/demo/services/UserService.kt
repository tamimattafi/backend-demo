package com.tamimattafi.backend.demo.services

import com.tamimattafi.backend.demo.database.entities.UserEntity
import com.tamimattafi.backend.demo.database.entities.global.EntityConverter
import com.tamimattafi.backend.demo.database.repository.IRxUserRepository
import com.tamimattafi.backend.demo.model.User
import io.reactivex.Single
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class UserService @Autowired constructor(override val repository: IRxUserRepository) : RxSimpleService<User, UserEntity>(repository) {

    override val converter: EntityConverter<User, UserEntity> = UserEntity.Converter

    fun usernameExists(username: String): Single<Boolean>
        = repository.findByUsername(username).onErrorReturn { UserEntity() }.map { it.id != null }

    fun emailExists(username: String): Single<Boolean>
        = repository.findByEmail(username).onErrorReturn { UserEntity() }.map { it.id != null }



}