package com.pado.infra.mongo

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories(basePackages = arrayOf("com.pado.domain.repository.mongo"))
class MongoConfiguration
