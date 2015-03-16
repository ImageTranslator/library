package com.library

class Library {

String location

String openingHours

Book book

Student student

Libarian libarian

String toString(){

"$location,$openingHours,$Libarian"

}


    static constraints = {

location()

openingHours()  

book()

student()

libarian()  

}
}
