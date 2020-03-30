package com.tamimattafi.backend.demo.database.entities

import com.tamimattafi.backend.demo.database.entities.UserEntity.Companion.TABLE_NAME
import com.tamimattafi.backend.demo.database.entities.global.EntityConverter
import com.tamimattafi.backend.demo.model.User
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(TABLE_NAME)
data class UserEntity(
        @Id
        val id: Long?,
        val username: String,
        val email: String,
        val password: String

)  {

        constructor(): this(null, "", "", "")

        companion object {
            const val TABLE_NAME = "user_entity"
        }

        object Converter : EntityConverter<User, UserEntity> {

            override fun fromModel(model: User): UserEntity
                   = with(model) { UserEntity(id, username, email, password) }

            override fun toModel(entity: UserEntity): User
                   = with(entity) { User(id, username, email, password) }

        }
}