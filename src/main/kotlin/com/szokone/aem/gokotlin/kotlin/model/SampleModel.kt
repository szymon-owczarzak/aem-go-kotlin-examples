package com.szokone.aem.gokotlin.kotlin.model

import com.szokone.aem.gokotlin.kotlin.service.ConfigurableService
import org.apache.sling.api.resource.Resource
import org.apache.sling.models.annotations.DefaultInjectionStrategy
import org.apache.sling.models.annotations.Model
import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.inject.Named

@Model(adaptables = arrayOf(Resource::class), defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
class SampleModel {

    @Inject lateinit var textfield: String

    @JvmField
    @field:[Inject Named("numberfield")]
    var numberfield: Long = 0

    @JvmField
    @field:[Inject Named("checkbox")]
    var checkbox: Boolean = false

    lateinit var calculatedValue: String

    @Inject lateinit var service: ConfigurableService

    @PostConstruct
    fun init(): Unit {
        calculatedValue = "${service.getReplacements()} | ${textfield} | ${numberfield} | ${checkbox}"
    }
}