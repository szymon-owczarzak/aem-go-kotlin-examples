package com.szokone.aem.gokotlin.kotlin.service

/**
 * Service Interface
 */
interface ConfigurableService {

    /**
     * @return true if enabled
     */
    fun isEnabled(): Boolean

    /**
     * @return map of text in component to replace
     */
    fun getReplacements(): Map<String, String>

}