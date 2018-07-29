package com.szokone.aem.gokotlin.java.filter;

import com.szokone.aem.gokotlin.java.service.ConfigurableService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.*;
import java.io.IOException;

/**
 * Sling Filter for decorating components with additional classes
 */
@Component(
        service = Filter.class,
        property = {
                "sling.filter.scope=COMPONENT",
                Constants.SERVICE_RANKING + ":Integer=" + (Integer.MAX_VALUE - 1)
        }
)
/*
  When using `org.apache.felix.scr.annotations` you can use Felix SCR equivalent:

  @SlingFilter(
        scope = SlingFilterScope.COMPONENT,
        order = Integer.MAX_VALUE - 1
  )
*/
public class ComponentDecoratorFilter implements Filter {

    @Reference
    private ConfigurableService service;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SlingHttpServletRequest req = (SlingHttpServletRequest) request;
        SlingHttpServletResponse res = (SlingHttpServletResponse) response;

        // NOTE: in real-life project make sure that your decorator touches only places that it should
        // be aware of the performance drop when badly implemented use resource type as a filter
        if (service.isEnabled() && StringUtils.startsWith(req.getResource().getPath(), "/content/experience-fragments/go-kotlin")) {
            new ComponentDecoratorProcessor(req, res, chain, service).process();
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        // nothing to init
    }

    @Override
    public void destroy() {
        // Searching, Seek and destroy
    }
}
