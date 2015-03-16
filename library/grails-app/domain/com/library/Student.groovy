package com.library

class Student {

String name

String email

String studentId

Course course

Book book

String toString(){

"$name,$email,$studentId"

}

    static constraints = {

name()

email()

studentId()

course()

book()
    }
}
