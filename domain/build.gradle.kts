import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

dependencies {
	api(project(":infra:infra-mongo"))
	api(project(":infra:infra-rds"))
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.apache.commons:commons-lang3:3.12.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}


val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true
