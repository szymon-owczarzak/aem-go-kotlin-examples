package com.szokone.aem.gokotlin.java.service;

import java.util.Map;

/**
 * Service Interface
 */
public interface ConfigurableService {

    /**
     * @return true if enabled
     */
    boolean isEnabled();

    /**
     * @return map of text in component to replace
     */
    Map<String, String> getReplacements();

}
