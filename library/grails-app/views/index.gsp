<!DOCTYPE html>
<html>
 <head>
 <meta name="layout" content="main"/>
 <title>The University Library System</title>
 </head>

<body>
 <div id="welcome">
 <br />
 <h3>Welcome to The University Library System</h3>
 <p>This is a system to allow you to be able to view and add details to different Library Systems.</p>
 </div>

<div class="homeCell">
 <h3>View Library</h3>
 <p>Click here to View &amp; Create Librarys</p>
 <span class="buttons" >
 <g:link controller="library" action="index"> See the Library</g:link>
 </span>
 </div>

<div class="homeCell">
 <h3>Add a Student</h3>
 <p>Click here to View &amp; Create Students</p>
 <span class="buttons" >
 <g:link controller="student" action="create">Add Student</g:link>
 </span>
 </div>

<div class="homeCell">
 <h3>Add Course</h3>
 <p>Click here to View &amp; Create Lecturers</p>
 <span class="buttons" >
 <g:link controller="course" action="create"> Add Course</g:link>
 </span>
 </div>

 <div class="homeCell">
 <h3>About the Librarian</h3> 
 <p>Click here to View &amp; Create Librarians. Librarians are the people who log into a system. Please make sure an already registered Librarian adds new Librarians.</p>
 <span class="buttons" >
 <g:link controller="libarian" action="create">Add Librarian</g:link>
 </span>
 </div>

<div class="homeCell">
 <h3>Add Book</h3>
 <p>Click here to View &amp; Create Books</p>
 <span class="buttons" >
 <g:link controller="book" action="create"> Add Book</g:link>
 </span>
 </div>

<div class="homeCell">
 <h3>Add Lecturers</h3>
 <p>Click here to View &amp; Create Lecturers</p>
 <span class="buttons" >
 <g:link controller="lecturer" action="create"> Add Lecturer</g:link>
 </span>
 </div>


 </body>
</html>

