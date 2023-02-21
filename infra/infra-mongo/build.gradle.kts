val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true

allOpen{
  annotation("org.springframework.data.mongodb.core.mapping.Document")
}

dependencies {
  api("org.springframework.boot:spring-boot-starter-data-mongodb")
  implementation("org.mongodb:mongodb-driver-sync:4.8.2")
  implementation("org.mongodb:mongodb-driver-core:4.8.2")
  implementation("org.mongodb:bson:4.8.2")
}
