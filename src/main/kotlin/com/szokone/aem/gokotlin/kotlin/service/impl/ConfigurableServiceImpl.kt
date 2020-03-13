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
                    name = "Text to be replaced",
                    description = "Example: boo:far all boo will be replaced with far"
            ) val replacements: Array<String> = ["boo:far"]
    )

    private lateinit var config: Config

    @Activate
    @Modified
    fun activate(config: Config) {
        this.config = config
    }

    override fun isEnabled() = config.enabled

    override fun getReplacements(): Map<String, String> {
        return config.replacements.toList()
                .map { it.split(":") }
                .filter { it.size == 2 }
                .associateBy({ it[0] }, { it[1] })
    }

}
