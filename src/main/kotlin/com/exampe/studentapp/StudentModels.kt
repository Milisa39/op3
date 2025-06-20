package com.exampe.studentapp

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

@JacksonXmlRootElement(localName = "students")
data class Students(
    @field:JacksonXmlElementWrapper(useWrapping = false)
    @field:JacksonXmlProperty(localName = "student")
    val student: List<Student> = listOf()
)

data class Student(
    @field:JacksonXmlProperty(localName = "first_name")
    val firstName: String = "",

    @field:JacksonXmlProperty(localName = "second_name")
    val secondName: String = "",

    val skills: Skills = Skills()
)

data class Skills(
    @field:JacksonXmlElementWrapper(useWrapping = false)
    @field:JacksonXmlProperty(localName = "skill")
    val skill: List<Skill> = listOf()
)

data class Skill(
    @field:JacksonXmlProperty(isAttribute = true)
    val hard: Boolean? = null,

    @field:JacksonXmlProperty(isAttribute = true)
    val soft: Boolean? = null,

    @field:JacksonXmlText
    var name: String = ""
)
