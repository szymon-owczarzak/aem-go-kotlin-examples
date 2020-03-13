repositories {
    mavenLocal()
    jcenter()
    gradlePluginPortal()
    maven("http://dl.bintray.com/cognifide/maven-public")
    maven("https://dl.bintray.com/neva-dev/maven-public")
}

dependencies {
    implementation("com.cognifide.gradle:aem-plugin:11.0.10")
    implementation("org.apache.sling:org.apache.sling.caconfig.bnd-plugin:1.0.2")
}
