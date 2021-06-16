plugins {
    kotlin("jvm")
    id("com.neva.fork")
    id("com.cognifide.aem.instance.local")
    id("com.cognifide.aem.bundle")
    id("com.cognifide.aem.package")
    id("com.cognifide.aem.package.sync")
    id("io.gitlab.arturbosch.detekt") version "1.17.1"
}

apply(from = "gradle/fork/props.gradle.kts")

defaultTasks(":instanceProvision", ":packageDeploy")
description = "AEM Go Kotlin"
group = "com.szokone.aem"

repositories {
    jcenter()
    maven("https://repo.adobe.com/nexus/content/groups/public")
    maven("https://dl.bintray.com/acs/releases")
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.17.1")

    compileOnly("org.osgi:osgi.cmpn:6.0.0")
    compileOnly("org.osgi:org.osgi.core:6.0.0")
    compileOnly("javax.servlet:servlet-api:2.5")
    compileOnly("javax.servlet:jsp-api:2.0")
    compileOnly("javax.jcr:jcr:2.0")
    compileOnly("org.slf4j:slf4j-api:1.7.25")
    compileOnly("org.apache.geronimo.specs:geronimo-atinject_1.0_spec:1.0")
    compileOnly("org.apache.sling:org.apache.sling.api:2.22.0")
    compileOnly("org.apache.sling:org.apache.sling.jcr.api:2.4.0")
    compileOnly("org.apache.sling:org.apache.sling.models.api:1.3.6")
    compileOnly("org.apache.sling:org.apache.sling.settings:1.3.8")
    compileOnly("com.google.guava:guava:15.0")
    compileOnly("com.google.code.gson:gson:2.8.5")
    compileOnly("joda-time:joda-time:2.9.1")

    compileOnly("com.adobe.aem:uber-jar:6.5.0:apis")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")
    testImplementation("io.wcm:io.wcm.testing.aem-mock.junit5:2.3.2")
}

aem {
    `package` {
        validator {
            base("org.apache.sling:org.apache.sling.api:2.22.0") // check if we are on AEM 6.5.8
        }
    }
    instance {
        provisioner {
            enableCrxDe()
            deployPackage("../../.aem/6.5/aem-service-pkg-6.5.8.zip")
            deployPackage("org.jetbrains.kotlin:kotlin-osgi-bundle:1.5.0")
        }
    }
}

detekt {
    input = files("src/main/kotlin")
    config.from(file("detekt.yml"))
    parallel = true
    autoCorrect = true
}

tasks {
    test {
        failFast = true
        useJUnitPlatform()
        testLogging.showStandardStreams = true
    }
}
