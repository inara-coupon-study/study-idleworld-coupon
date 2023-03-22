val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true

allOpen{
  annotation("org.springframework.data.mongodb.core.mapping.Document")
}
// 참고) redisson을 사용한 이유
// https://devroach.tistory.com/83
// https://velog.io/@ohzzi/Redis%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%98%EC%97%AC-%EB%8F%99%EC%8B%9C%EC%84%B1-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0%ED%95%98%EA%B8%B0
dependencies {
  api("org.redisson:redisson-spring-boot-starter:3.17.3")  // boot-starter-data-redis를 포함
}
