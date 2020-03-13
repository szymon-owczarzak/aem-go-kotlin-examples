import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.70"
    id("com.cognifide.aem.instance.local")
    id("com.cognifide.aem.bundle")
    id("com.cognifide.aem.package")
}

defaultTasks(":instanceSatisfy", ":packageDeploy")
description = "AEM Go Kotlin Examples"
group = "com.szokone.aem"

repositories {
    jcenter()
    maven("https://repo.adobe.com/nexus/content/groups/public")
    maven("https://dl.bintray.com/acs/releases")
}

dependencies {
    "testCompile"("junit:junit:4.12")

    "compileOnly"("org.osgi:osgi.cmpn:6.0.0")
    "compileOnly"("org.osgi:org.osgi.core:4.2.0")
    "compileOnly"("org.apache.commons:commons-lang3:3.5")
    "compileOnly"("javax.servlet:servlet-api:2.5")
    "compileOnly"("javax.jcr:jcr:2.0")
    "compileOnly"("org.slf4j:slf4j-api:1.7.21")
    "compileOnly"("org.apache.geronimo.specs:geronimo-atinject_1.0_spec:1.0")
    "compileOnly"("com.adobe.aem:uber-jar:6.3.0:apis")
    "compileOnly"("org.apache.sling:org.apache.sling.api:2.16.2")
    "compileOnly"("org.apache.sling:org.apache.sling.jcr.api:2.4.0")
    "compileOnly"("org.apache.sling:org.apache.sling.models.api:1.3.2")
    "compileOnly"("com.google.code.gson:gson:2.3")

    implementation(kotlin("stdlib-jdk8"))
}

aem {
    instance {
        satisfier {
            packages {
                "my-bundle"("org.jetbrains.kotlin:kotlin-osgi-bundle:1.3.70")
            }
        }
    }

    tasks.bundleCompose {
        exportPackage("com.szokone.aem.gokotlin.java.service", "com.szokone.aem.gokotlin.kotlin.service")
        category = "szokone"
        vendor = "szokone"
        bnd("-plugin org.apache.sling.caconfig.bndplugin.ConfigurationClassScannerPlugin")
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}