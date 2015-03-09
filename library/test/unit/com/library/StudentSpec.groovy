package com.library

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Student)
class StudentSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
	when:"A Student has Name, email, studentId, Course"

	def student=new Student(name:'John Howat',
				
				email:'b3003391@my.shu.ac.uk',
				
				studentId:'b3003391',

				course:'Web Systems Design')

then:"the to String method will merge them."

student.toString()=='John Howat, b3003391@my.shu.ac.uk, b3003391, Web Systems Design'
    }
}
