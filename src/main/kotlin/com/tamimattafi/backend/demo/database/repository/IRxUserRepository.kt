package com.tamimattafi.backend.demo.database.repository

import com.tamimattafi.backend.demo.database.entities.UserEntity
import io.reactivex.Single
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.RxJava2CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IRxUserRepository : RxJava2CrudRepository<UserEntity, Long> {

    @Query("SELECT CASE WHEN EXISTS ( SELECT * FROM ${UserEntity.TABLE_NAME} WHERE username = :username) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END")
    fun existsByUsername(username: String): Single<Boolean>

}