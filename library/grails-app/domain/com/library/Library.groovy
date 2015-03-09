package com.library

class Library {

String location

String openingHours

Book Book

Student Student

Libarian Libarian

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
