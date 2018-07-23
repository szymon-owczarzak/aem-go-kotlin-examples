package com.szokone.aem.gokotlin.kotlin.servlet

import com.google.common.collect.ImmutableMap
import com.google.common.net.MediaType
import com.szokone.aem.gokotlin.kotlin.service.SimpleService
import org.apache.sling.api.SlingHttpServletRequest
import org.apache.sling.api.SlingHttpServletResponse
import org.apache.sling.api.servlets.SlingAllMethodsServlet
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Reference
import javax.servlet.Servlet

/**
 * @link http://host:port/bin/kotlin/hello
 *
 * Other Sling Servlet properties:
 *
 *   sling.servlet.extensions=
 *   sling.servlet.selectors=
 *   sling.servlet.resourceTypes=
 *   sling.servlet.methods=
 *   sling.servlet.prefix=
 *
 *   More: https://sling.apache.org/documentation/the-sling-engine/servlets.html
 */
@Component(
  service = arrayOf(Servlet::class),
  property = arrayOf("sling.servlet.paths=/bin/kotlin/hello")
)
class SimpleServlet : SlingAllMethodsServlet() {

  @Reference
  lateinit var simpleService: SimpleService

  override fun doGet(request: SlingHttpServletRequest, response: SlingHttpServletResponse) {

    response.contentType = MediaType.JSON_UTF_8.toString()
    response.writer.write(simpleService.toJson(ImmutableMap.of("message", "Hello from Kotlin World!")))
  }
}
