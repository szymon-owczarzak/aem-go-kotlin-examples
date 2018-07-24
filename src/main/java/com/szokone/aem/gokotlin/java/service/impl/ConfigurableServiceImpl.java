package com.szokone.aem.gokotlin.java.service.impl;

import com.szokone.aem.gokotlin.java.service.ConfigurableService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

/**
 * OSGi Component implementing some Service interface with configuration that can be changed in:
 * http://localhost:4502/system/console/configMgr
 */
@Component(
        immediate = true,
        service = ConfigurableService.class
)
@Designate(
        ocd = ConfigurableServiceDefinition.class
)
public class ConfigurableServiceImpl implements ConfigurableService {

    private boolean enabled;

    private String[] decorableHtmlTags;

    private String additionalClasses;

    @Activate
    @Modified
    protected void activate(final ConfigurableServiceDefinition config) {
        this.decorableHtmlTags = config.decorableHtmlTags();
        this.enabled = config.enabled();
        this.additionalClasses = config.additionalClasses();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String[] getDecorableHtmlTags() {
        return decorableHtmlTags;
    }

    public String getAdditionalClasses() {
        return additionalClasses;
    }
}
