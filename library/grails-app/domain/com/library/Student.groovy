package com.library

class Student {

String name

String email

String studentId

Course course

String toString(){

"$name,$email,$studentId"

}

    static constraints = {

name()

email()

studentId()

course()
    }
}
