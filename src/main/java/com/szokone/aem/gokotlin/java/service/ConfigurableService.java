package com.szokone.aem.gokotlin.java.service;

/**
 * Service Interface
 */
public interface ConfigurableService {

    /**
     * @return true if enabled
     */
    boolean isEnabled();

    /**
     * @return list of HTML tags that should be decorated with additional classes
     */
    String[] getDecorableHtmlTags();

    /**
     * @return additional classes that will be added to 'decorableHtmlTags'
     */
    String getAdditionalClasses();
}
