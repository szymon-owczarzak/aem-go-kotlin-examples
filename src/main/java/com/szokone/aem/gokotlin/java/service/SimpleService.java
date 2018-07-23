package com.szokone.aem.gokotlin.java.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

/**
 * Simple OSGi Component and Service
 */
@Component(
        service = SimpleService.class
)
public class SimpleService {

    private static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .serializeNulls()
            .setPrettyPrinting()
            .create();


    public String toJson(Map<String, String> data) {
        return GSON.toJson(data);
    }
}
