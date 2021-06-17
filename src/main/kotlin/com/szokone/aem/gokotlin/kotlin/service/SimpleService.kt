package com.szokone.aem.gokotlin.kotlin.service

import com.google.gson.GsonBuilder
import org.osgi.service.component.annotations.Component

/**
 * Simple OSGi Component registered as Service
 */
@Component(
    service = [SimpleService::class]
)
class SimpleService {

    companion object {
        val GSON = GsonBuilder()
            .disableHtmlEscaping()
            .serializeNulls()
            .setPrettyPrinting()
            .create()
    }

    fun toJson(data: Map<String, String>): String = GSON.toJson(data)
}
