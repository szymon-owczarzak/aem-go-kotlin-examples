# AEM Go Kotlin Examples

![logo](./src/resources/kotlin_logo.png)

In this example project you can compare different implementations of common interfaces that are used when developing AEM based projects.

### If you like to run it just type

`./gradlew` from root folder

or use provided `Build and Deploy` build for IntelliJ IDE

### Content

1. `SimpleService` 
[Java](/src/main/java/com/szokone/aem/gokotlin/java/service/SimpleService.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/service/SimpleService.kt)
OSGi component and service with static final field (companion object).
2. `SimpleServlet`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/servlet/SimpleSerlet.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/servlet/SimpleServlet.kt)
OSGi component and sling Servlet with dependency injection to another service.