## Requirements
    Spring 2.4.1
    MongoDB
## Fields
        id;
        FirstName;
        LastName;
        Tel;
        SchoolName;
        Email;
        DateOfBirth;
        ExpectedGraduatedYear;
## Instructions
    #Using local host as an example, data will return as Json format.
        Get All Students:
            http://localhost:8080/api/students/getStudents
        Add student
            http://localhost:8080/api/students/addStudent
            Then include adding Json in the body.
        Delete student
            http://localhost:8080/api/students/delStudent?studentId=
            Append the Id in the url to delete the designated student.
        Edit a student
            http://localhost:8080/api/students/editStudent/?studentId=
            Append the Id in the url.
            Add the changing field from (firstName,lastName,email) as Params.