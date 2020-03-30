package com.tamimattafi.backend.demo.database.repository

import com.tamimattafi.backend.demo.database.entities.UserEntity
import io.reactivex.Single
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.RxJava2CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IRxUserRepository : RxJava2CrudRepository<UserEntity, Long> {

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME} WHERE username = :username LIMIT 1")
    fun findByUsername(username: String): Single<UserEntity>

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME} WHERE email = :email LIMIT 1")
    fun findByEmail(email: String): Single<UserEntity>

}