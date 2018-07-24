package com.szokone.aem.gokotlin.java.service.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "1 Component Decorator Config Java",
        description = "Optional configuration description here"
)
public @interface ConfigurableServiceDefinition {

    @AttributeDefinition(
            name = "Enable",
            description = "If selected tag decorator will be turned on"
    )
    boolean enabled() default false;

    @AttributeDefinition(
            name = "HTML tags to be decorated",
            description = "Optional field description here"
    )
    String[] decorableHtmlTags() default {"div", "image"};

    @AttributeDefinition(
            name = "HTML tags to be decorated",
            description = "Optional field description here"
    )
    String additionalClasses() default "java-decorator";

}
