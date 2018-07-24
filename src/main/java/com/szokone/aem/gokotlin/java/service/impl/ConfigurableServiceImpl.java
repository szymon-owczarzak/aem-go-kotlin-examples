package com.szokone.aem.gokotlin.java.service.impl;

import com.szokone.aem.gokotlin.java.service.ConfigurableService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private Map<String, String> replacements;

    @Activate
    @Modified
    protected void activate(final ConfigurableServiceDefinition config) {
        this.enabled = config.enabled();
        this.replacements = Stream.of(config.replacements())
                .map(it -> it.split(":"))
                .filter(it -> it.length == 2)
                .collect(Collectors.toMap(it -> it[0], it -> it[1]));
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Map<String, String> getReplacements() {
        return replacements;
    }

}
