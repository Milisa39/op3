package com.exampe.studentapp

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.io.File

@Service
class StudentService(private val jdbcTemplate: JdbcTemplate) {

    fun importFromXml(xmlFile: File) {
        val mapper = XmlMapper()
        val students = mapper.readValue(xmlFile, Students::class.java)

        students.student.forEach { student ->
            val studentId = insertStudent(student.firstName, student.secondName)
            student.skills.skill.forEach { skill ->
                insertSkill(studentId, skill)
            }
        }
    }

    private fun insertStudent(firstName: String, secondName: String): Long {
        jdbcTemplate.update(
            "INSERT INTO students (first_name, second_name) VALUES (?, ?)",
            firstName, secondName
        )
        return jdbcTemplate.queryForObject("SELECT LASTVAL()", Long::class.java) ?: 0L
    }

    private fun insertSkill(studentId: Long, skill: Skill) {
        jdbcTemplate.update(
            "INSERT INTO skills (student_id, name, hard, soft) VALUES (?, ?, ?, ?)",
            studentId, skill.name, skill.hard ?: false, skill.soft ?: false
        )
    }
}