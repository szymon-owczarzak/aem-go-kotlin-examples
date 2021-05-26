package com.szokone.aem.gokotlin.java.servlet;

import com.google.common.collect.ImmutableMap;
import com.google.common.net.MediaType;
import com.szokone.aem.gokotlin.java.service.SimpleService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import java.io.IOException;

/**
 * OSGi component registered as Sling Servlet
 *
 * @link http://[host]:[port]/bin/java/hello
 * <p>
 * Other Sling Servlet properties:
 * <p>
 * sling.servlet.extensions=
 * sling.servlet.selectors=
 * sling.servlet.resourceTypes=
 * sling.servlet.methods=
 * sling.servlet.prefix=
 * <p>
 * More: https://sling.apache.org/documentation/the-sling-engine/servlets.html
 */
@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.paths=/bin/java/hello"
        }
)
/*
  When using `org.apache.felix.scr.annotations` Felix SCR equivalent:

  @SlingServlet( paths = "/bin/java/hello" )
 */
public class SimpleServlet extends SlingAllMethodsServlet {

    @Reference
    private SimpleService simpleService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

        response.setContentType(MediaType.JSON_UTF_8.toString());
        response.getWriter().write(simpleService.toJson(ImmutableMap.of("message", "Hello from Java World!")));
    }

}
