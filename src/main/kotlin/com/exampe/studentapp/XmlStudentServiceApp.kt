package com.exampe.studentapp

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.io.File

@SpringBootApplication
class XmlStudentServiceApp

fun main(args: Array<String>) {
    runApplication<XmlStudentServiceApp>(*args)
}

@Component
class XmlImporter(private val studentService: StudentService) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val xmlFile = File("students.xml") // ensure the file is in project root or adjust the path
        studentService.importFromXml(xmlFile)
        println("Import complete.")
    }
}
