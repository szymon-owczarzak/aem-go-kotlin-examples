# AEM Go Kotlin Examples

![logo](./src/resources/logo.png)

This project will help you learn Kotlin programming language. 
You will find examples of common AEM developer tasks all written in both Java and Kotlin.

### Deploy on AEM 6.4 

If you like to run it just type `./gradlew` from root folder or use provided `Build and Deploy` build for IntelliJ IDE

### Content

1. `SimpleService` 
[Java](/src/main/java/com/szokone/aem/gokotlin/java/service/SimpleService.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/service/SimpleService.kt)  
OSGi `@Component` and `Service` (all in one class) with (`static final field` in Java / `companion object` - in Kotlin).

2. `SimpleServlet`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/servlet/SimpleServlet.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/servlet/SimpleServlet.kt)  
OSGi `@Component` and `Sling Servlet` with `dependency injection` to another service.  
You can test both servlets on:  
`http://localhost:4502/bin/java/hello`  
`http://localhost:4502/bin/kotlin/hello`

3. `ConfigurableService`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/service/ConfigurableService.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/service/ConfigurableService.kt)  
Service `interface` definition.

4. `ConfigurableServiceImpl`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/service/impl/ConfigurableServiceImpl.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/service/impl/ConfigurableServiceImpl.kt)  
OSGi component that can be configured in `Adobe Experience Manager Web Console Configuration`.  
Use of `@ObjectClassDefinition`, `@AttributeDefinition` and service implementation.  
Compare how to transform `Array` to `Map` with `Stream API` in Java and `Closures` in Kotlin.

5. `ComponentDecoratorFilter`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/filter/ComponentDecoratorFilter.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/filter/ComponentDecoratorFilter.kt)  
OSGi component and basic implementation of `javax.servlet.Filter`

6. `ComponentDecoratorProcessor`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/filter/ComponentDecoratorProcessor.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/filter/ComponentDecoratorProcessor.kt)  
Class used by ComponentDecoratorFilter to replace markup text with some other text. 
Compare how `final fields` are defined, `casting`.  
Meet `elvis operator` and `fields definition directly in constructor` when writing in Kotlin.

7. `SampleModel`
[Java](/src/main/java/com/szokone/aem/gokotlin/java/model/SampleModel.java) 
|
[Kotlin](/src/main/kotlin/com/szokone/aem/gokotlin/kotlin/model/SampleModel.kt)  
Simple `Sling Model` with property and service `injection`. Learn how to inject primitive types in Kotlin.

8. `Sample Component`
[path](src/main/content/jcr_root/apps/aem-go-kotlin-examples/components/sample)  
Sample Component with Touch UI config dialog. 
Add selector `java` or `kotlin` and switch from `JSP` to `HTL` with different model implementations.

##### Developed and tested on `AEM 6.4`

##### Project structure generated from [gradle-aem-single](https://github.com/Cognifide/gradle-aem-single) with help from [gradle-fork-plugin](https://github.com/neva-dev/gradle-fork-plugin)