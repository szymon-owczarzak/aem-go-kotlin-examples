package com.szokone.aem.gokotlin.java.filter;

import com.szokone.aem.gokotlin.java.service.ConfigurableService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.wrappers.SlingHttpServletResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

class ComponentDecoratorProcessor extends SlingHttpServletResponseWrapper {

    private final SlingHttpServletRequest request;

    private final SlingHttpServletResponse response;

    private final FilterChain chain;

    private final ConfigurableService service;

    private StringWriter sw;

    void process() throws IOException, ServletException {
        chain.doFilter(request, this);
        String html = sw != null ? sw.toString() : StringUtils.EMPTY;

        for (String search : service.getReplacements().keySet()) {
            if (html.contains(search)) {
                html = StringUtils.replaceAll(html, search, service.getReplacements().get(search));
            }
        }
        response.getWriter().write(html);
    }

    ComponentDecoratorProcessor(SlingHttpServletRequest request, SlingHttpServletResponse response, FilterChain chain, ConfigurableService service) {
        super(response);
        this.request = request;
        this.response = response;
        this.chain = chain;
        this.service = service;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (sw == null) {
            sw = new StringWriter();
        }
        return new PrintWriter(sw);
    }
}
