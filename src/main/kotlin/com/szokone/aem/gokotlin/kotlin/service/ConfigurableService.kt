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
     * @return list of HTML tags that should be decorated with additional classes
     */
    fun getDecorableHtmlTags(): Array<String>

    /**
     * @return additional classes that will be added to 'decorableHtmlTags'
     */
    fun getAdditionalClasses(): String
}