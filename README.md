# AEM Go Kotlin Examples

![logo](./src/resources/logo.png)

This project will help you learn Kotlin programming language. 
You will find examples of common AEM developer tasks all written in both Java and Kotlin.

---

## Prerequisites

#### For existing AEM instance
Local **AEM author 6.5.8** instance running on `http://localhost:4502`  
(*) Can be changed in `instance.local-author.httpUrl` prop in `gradle.user.properties`

#### For new AEM instance
Put `cq-quickstart-6.5.0.jar`, `license.properties`, `aem-service-pkg-6.5.8.zip` 
inside `<project_root>/instance/` folder and run `gradlew instanceUp`.  
G.A.P. will create and start AEM author instance for you (this will take a few minutes).

#### Adding Publish instance (Optional)
Set `true` on `instance.local-publish.enabled` prop in `gradle.user.properties`

---

## Deploy on AEM 6.5.8 

If you like to run it just type `gradlew` from root folder or use provided `package deploy` build for IntelliJ IDE
(*) Build is checking if `org.apache.sling.api ver. 2.22.0` is available on the instance to ensure deployment on AEM 6.5.8 
this can be disabled in `build.gradle.kts`

---

## Content

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

8. `Sample Component` [path](src/main/content/jcr_root/apps/gokotlin/components/sample)  
Sample Component with Touch UI config dialog. 
Add selector `java` or `kotlin` and switch from `JSP` to `HTL` with different model implementations. Links: 
[Java](http://localhost:4502/content/experience-fragments/go-kotlin/master.java.html)
   |
[Kotlin](http://localhost:4502/content/experience-fragments/go-kotlin/master.kotlin.html)
   
---

### Developed and tested on `AEM 6.5.8`

### Versions
* [6.5.8](https://github.com/szymon-owczarzak/aem-go-kotlin-examples/blob/6.5.8/README.md) - Project recreated for the newer GAP | migrated to AEM 6.5.8
* [1.0.1](https://github.com/szymon-owczarzak/aem-go-kotlin-examples/blob/1.0.1/README.md) - GAP and Gradle updated | build scripts migrated to Kotlin DSL | AEM 6.3
* [1.0.0](https://github.com/szymon-owczarzak/aem-go-kotlin-examples/blob/1.0.0/README.md) - Initial version from 2018 | build scripts in Groovy DSL | AEM 6.3

##### Project structure generated from [gradle-aem-single](https://github.com/wttech/gradle-aem-single) with help from [gradle-fork-plugin](https://github.com/neva-dev/gradle-fork-plugin)