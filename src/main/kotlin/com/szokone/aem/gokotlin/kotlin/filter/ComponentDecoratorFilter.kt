package com.szokone.aem.gokotlin.kotlin.filter

import com.szokone.aem.gokotlin.kotlin.service.ConfigurableService
import org.apache.commons.lang3.StringUtils
import org.apache.sling.api.SlingHttpServletRequest
import org.apache.sling.api.SlingHttpServletResponse
import org.osgi.framework.Constants
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Reference
import javax.servlet.*

/**
 * Sling Filter for decorating components with additional classes
 */
@Component(
        service = arrayOf(Filter::class),
        property = arrayOf(
                "sling.filter.scope=COMPONENT",
                "${Constants.SERVICE_RANKING}:Integer=${Integer.MAX_VALUE - 2}"
        )
)
class ComponentDecoratorFilter : Filter {

    @Reference
    lateinit var service: ConfigurableService

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req = request as SlingHttpServletRequest
        val res = response as SlingHttpServletResponse

        if (service.isEnabled() && StringUtils.startsWith(req.resource.path, "/content/experience-fragments/go-kotlin")) {
            ComponentDecoratorProcessor(req, res, chain, service).process()
        } else {
            chain?.doFilter(request, response)
        }
    }

    override fun init(filterConfig: FilterConfig?) {
        // nothing to init
    }

    override fun destroy() {
        // nothing to destroy
    }

}