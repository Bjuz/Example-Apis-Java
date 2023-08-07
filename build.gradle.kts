plugins {
	java
	id("org.springframework.boot") version "2.5.3"
	id("io.spring.dependency-management") version "1.1.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven {
		name = "Spring Repositories"
		url = uri("https://repo.spring.io/libs-release/")
	}
	gradlePluginPortal()
	maven {
		name = "Gradle Plugins Maven Repository"
		url = uri("https://plugins.gradle.org/m2/")
	}
	maven { url = uri( "https://jitpack.io") } // Add this line for JitPack repository
}


dependencies {
	implementation("javax.servlet:javax.servlet-api:4.0.1")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.12")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("io.springfox:springfox-swagger2:2.9.2")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")
	implementation(kotlin("stdlib-jdk8", "1.5.30"))

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

