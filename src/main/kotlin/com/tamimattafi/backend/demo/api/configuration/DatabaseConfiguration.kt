package com.tamimattafi.backend.demo.api.configuration

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories


@Configuration
@EnableR2dbcRepositories
class DatabaseConfiguration : AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory
         = ConnectionFactories.get(
                builder().option(DRIVER, "mysql")
                    .option(HOST, "localhost")
                    .option(USER, "root")
                    .option(PASSWORD, "root")
                    .option(DATABASE, "demodb")
                    .build()
        )


}