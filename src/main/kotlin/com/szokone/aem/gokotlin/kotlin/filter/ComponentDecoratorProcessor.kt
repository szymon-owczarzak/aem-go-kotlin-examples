package com.szokone.aem.gokotlin.kotlin.filter

import com.szokone.aem.gokotlin.kotlin.service.ConfigurableService
import org.apache.commons.lang3.StringUtils
import org.apache.sling.api.SlingHttpServletRequest
import org.apache.sling.api.SlingHttpServletResponse
import org.apache.sling.api.wrappers.SlingHttpServletResponseWrapper
import java.io.IOException
import java.io.PrintWriter
import java.io.StringWriter
import javax.servlet.FilterChain

class ComponentDecoratorProcessor(private val request: SlingHttpServletRequest,
                                  private val response: SlingHttpServletResponse,
                                  private val chain: FilterChain?,
                                  private val service: ConfigurableService) : SlingHttpServletResponseWrapper(response) {

    private var sw: StringWriter? = null

    fun process() {
        chain?.doFilter(request, this)
        var html = if (sw != null) sw.toString() else StringUtils.EMPTY

        service.getReplacements().forEach {
            if (html.contains(it.component1())) html = StringUtils.replaceAll(html, it.component1(), it.component2())
        }
        response.writer.write(html)
    }


    @Throws(IOException::class)
    override fun getWriter(): PrintWriter {
        sw = sw ?: StringWriter()
        return PrintWriter(sw)
    }
}