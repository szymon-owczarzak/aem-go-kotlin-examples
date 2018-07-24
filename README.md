# AEM Go Kotlin Examples

![logo](./src/resources/logo.png)

In this example project you can compare Java and Kotlin implementations of common interfaces that are used when developing AEM based projects.

### If you like to run it just type

`./gradlew` from root folder

or use provided `Build and Deploy` build for IntelliJ IDE

### Content

1. `SimpleService` 
[Java](/src/main/java/com/szokone/aem/gokotlin/java/service/SimpleService.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/service/SimpleService.kt)
OSGi component and service (all in one class) with (static final field in Java / companion object - in Kotlin).
2. `SimpleServlet`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/servlet/SimpleServlet.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/servlet/SimpleServlet.kt)
OSGi component and sling Servlet with dependency injection to another service.
3. `ConfigurableService`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/service/ConfigurableService.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/service/ConfigurableService.kt)
OSGi service interface definition.
4. `ConfigurableServiceImpl`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/service/impl/ConfigurableServiceImpl.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/service/impl/ConfigurableServiceImpl.kt)
OSGi component that can be configured in `Adobe Experience Manager Web Console Configuration`.
Use of `@ObjectClassDefinition`, `@AttributeDefinition` and service implementation.