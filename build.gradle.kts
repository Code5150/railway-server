val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val postgresql_version: String by project
val hikari_version: String by project
val kodein_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.0"
}

group = "com.code5150"
version = "0.0.1"

application {
    mainClass.set("com.code5150.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.0")

    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-locations:$ktor_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-apache:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposed_version")

    implementation("org.postgresql:postgresql:$postgresql_version")

    implementation("com.zaxxer:HikariCP:$hikari_version")

    implementation("org.kodein.di:kodein-di-framework-ktor-server-jvm:$kodein_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}

/*tasks {
    val java = "15"
    compileKotlin{
        kotlinOptions { jvmTarget = java }
        sourceCompatibility = java
    }
}*/

tasks.create("stage") {
    dependsOn("installDist")
}
