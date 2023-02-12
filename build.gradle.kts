import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("kapt") version "1.7.21"
}

group = "com.pado"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
	repositories {
		maven("https://plugins.gradle.org/m2/")
		mavenCentral()
	}
}

subprojects{
	apply {
		plugin("kotlin")
		plugin("io.spring.dependency-management")
		plugin("kotlin-spring") // instead of "kotlin-allopen"
		plugin("org.springframework.boot")
		plugin("kotlin-kapt")
		plugin("idea")
		plugin("java")
	}

	dependencies {
		implementation(kotlin("stdlib"))

		implementation("org.springframework.boot:spring-boot-starter-data-jpa")

		// 잭슨은 기본적으로 json을 역질렬화 시킬때 기본 생성자를 필요로 한다.
		// 직렬화시 리플렉션을 사용하는데, 리플렉션에셔 기본생성자가 필요하기 때문에 역직렬화시에도 필요.
		// 코틀린에서는 매개변수가 없는 생성자를 만들려면, 생성자의 모든 기본값을 채워야한다.
		// 이에, 잭슨 코틀린 모듈을 지원하여 매개변수가 없는 생성자가 없더라도 직렬화, 역직렬화를 지원한다.
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

		implementation("com.h2database:h2")
		implementation("au.com.console:kassava:2.0.0")

		implementation("com.datadoghq:dd-trace-api:1.3.0")
		implementation("io.opentracing:opentracing-api:0.33.0")
		implementation("io.opentracing:opentracing-util:0.33.0")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("com.h2database:h2")

		testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
		testImplementation("io.kotest:kotest-assertions-core:5.5.4")
		testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
		testImplementation("io.mockk:mockk:1.12.0")

	}

	repositories {
		maven("https://plugins.gradle.org/m2/") // gradle plugin 저장소의 주소
		// mavenCentral()
		maven("https://jitpack.io") // jitpack에 배포된 라이브러리를 쓸때 jitpack 저장소 사용
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

}

// sub task의 gradle task를 수행하기 위한 설정
tasks.jar {
	enabled = true
}

tasks.bootJar {
	enabled = false
}