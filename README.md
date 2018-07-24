# AEM Go Kotlin Examples

![logo](./src/resources/logo.png)

This project will help you learn Kotlin programming language. 
You will find examples of common AEM developer tasks all written in both Java and Kotlin.

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

##### Project structure generated from [gradle-aem-single](https://github.com/Cognifide/gradle-aem-single) with help from [gradle-fork-plugin](https://github.com/neva-dev/gradle-fork-plugin)