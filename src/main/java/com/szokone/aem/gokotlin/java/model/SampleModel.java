package com.szokone.aem.gokotlin.java.model;

import com.szokone.aem.gokotlin.java.service.ConfigurableService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SampleModel {

    @Inject
    private String textfield;

    @Inject
    private Long numberfield;

    @Inject
    private boolean checkbox;

    private String calculatedValue;

    @Inject
    private ConfigurableService service;

    @PostConstruct
    public void init() {
        calculatedValue = service.getReplacements().toString() + " | " + textfield + " | " + numberfield + " | " + checkbox;
    }

    public String getTextfield() {
        return textfield;
    }

    public Long getNumberfield() {
        return numberfield;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public String getCalculatedValue() {
        return calculatedValue;
    }
}
