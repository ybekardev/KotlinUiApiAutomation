package org.kotlin.uiapi.kotlinuiapi.config

import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.stereotype.Component

//https://www.baeldung.com/properties-with-spring
//https://blog.jetbrains.com/idea/2018/10/spring-kotlin-references-in-value-annotation/

//@Configuration
//@Component
@PropertySource("classpath:environment/dev.properties")
@PropertySources(value = [PropertySource("classpath:application.properties"), PropertySource("classpath:environment/\${profile.active}.properties", ignoreResourceNotFound = true)])
@Import(org.kotlin.uiapi.kotlinuiapi.config.KotlinConfig::class)
class KotlinConfig {
}
