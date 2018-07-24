package com.szokone.aem.gokotlin.kotlin.service.impl

import com.szokone.aem.gokotlin.kotlin.service.ConfigurableService
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Modified
import org.osgi.service.metatype.annotations.AttributeDefinition
import org.osgi.service.metatype.annotations.Designate
import org.osgi.service.metatype.annotations.ObjectClassDefinition

/**
 * OSGi Component implementing some Service interface with configuration that can be changed in:
 * http://localhost:4502/system/console/configMgr
 */
@Component(
        immediate = true,
        service = arrayOf(ConfigurableService::class)
)
@Designate(
        ocd = ConfigurableServiceImpl.Config::class
)
class ConfigurableServiceImpl : ConfigurableService {

    @ObjectClassDefinition(
            name = "2 Component Decorator Config Kotlin",
            description = "Optional configuration description here"
    )
    annotation class Config(
            @get:AttributeDefinition(
                    name = "Enable",
                    description = "If selected tag decorator will be turned on"
            ) val enabled: Boolean = false,

            @get:AttributeDefinition(
                    name = "HTML tags to be decorated",
                    description = "Optional field description here"
            ) val decorableHtmlTags: Array<String> = arrayOf("div", "image"),

            @get:AttributeDefinition(
                    name = "HTML tags to be decorated",
                    description = "Optional field description here"
            ) val additionalClasses: String = "kotlin-decorator"
    )

    private lateinit var config: Config

    @Activate
    @Modified
    fun activate(config: Config) {
        this.config = config
    }

    override fun isEnabled() = config.enabled

    override fun getDecorableHtmlTags() = config.decorableHtmlTags

    override fun getAdditionalClasses() = config.additionalClasses
}