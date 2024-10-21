# Student Management System

This is a **Student Management System** built using **Spring Boot** and **Java**. The system allows users to manage student records in a school, providing essential CRUD operations for each student. The project follows a **RESTful API** architecture and utilizes **JPA** for database operations with an H2 in-memory database.

## Features

- **Student Management:**
  - Create, update, and delete student records.
  - Retrieve information about individual students by their ID.
  - View a list of all students enrolled in the school.
  
- **Bulk Student Management:**
  - Create multiple student records in a single API call for efficient data entry.
  
## Technologies Used

- **Spring Boot**: Provides the backbone for the RESTful APIs.
- **Spring Data JPA**: For database interactions.
- **H2 Database**: Lightweight in-memory database for development and testing.
- **Java Persistence API (JPA)**: For object-relational mapping (ORM).
- **JSON**: Data format for communication between frontend and backend.

## Project Structure

- **Controllers**: Handle HTTP requests and map them to appropriate service methods for managing student data.
- **Services**: Contain business logic for handling student operations.
- **Repositories**: Interfaces for database operations using JPA.
- **Models**: Entity representing the `Student`.

## How to Run

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/student-management-system.git
    ```

2. Navigate into the project directory:

    ```bash
    cd student-management-system
    ```

3. Run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

## API Endpoints

### Students
- `GET /students`: Fetch all students.
- `POST /students`: Create a new student.
- `GET /students/{studentId}`: Fetch student details by ID.
- `PUT /students/{studentId}`: Update student details.
- `DELETE /students/{studentId}`: Delete a student by ID.
- `POST /students/bulk`: Create multiple students in one request.

## Future Enhancements

- Add user authentication and authorization.
- Integrate search functionality for students.
- Implement pagination for large datasets.
- Add unit tests to improve coverage.


/*Given five files,

- `StudentController.java`
- `StudentRepository.java`
- `StudentH2Service.java`
- `StudentRowMapper.java`
- `Student.java`

And also given a database file `school` which contains a `student` table. The `student` table initially contains details of 20 students. 

#### Student Table

|   Columns   |  Type   |
| :---------: | :-----: |
|  studentId  | INTEGER |
| studentName |  TEXT   |
|   gender    |  TEXT   |
|  standard   | INTEGER |

<SingleLineNote>

Use only STUDENT as a table name in your code while writing queries.
</SingleLineNote>

### Completion Instructions

- `Student.java`: `Student` class should contain the following attributes.

    |  Attribute  |  Type  |
    | :---------: | :----: |
    |  studentId  |  int   |
    | studentName | String |
    |   gender    | String |
    |  standard   |  int   |

- `StudentRepository.java`: Create an `interface` containing required methods.
- `StudentH2Service.java`: Update the service class with logic for managing student data.
- `StudentController.java`: Create the controller class to handle HTTP requests.
- `StudentRowMapper.java`: Create a class which implements the `Rowmapper Interface`.

Implement the following APIs.

### API 1

#### Path: `/students`

#### Method: `GET`

#### Description:

Returns a list of all students in the school.

#### Response

```
[
    {
        "studentId": 1,
        "studentName": "John",
        "gender": "Male",
        "standard": 1
    },
   ...
]
```

### API 2

#### Path: `/students`

#### Method: `POST`

#### Description:

Creates a new student in the `student` table. The `studentId` is auto-incremented. Also, returns the student details added. 

#### Request

```
{
  "studentName": "Prince",
  "gender": "Male",
  "standard": 4
}
```

#### Response

```
{
    "studentId": 21,
    "studentName": "Prince",
    "gender": "Male",
    "standard": 4
}
```

### API 3

#### Path: `/students/bulk`

#### Method: `POST`

#### Description:

Creates multiple students in the `student` table and returns a text containing the numbers of students added.  

#### Request

For example, the below request object contains details of 4 students.

```
[
    {
        "studentName": "Jack",
        "gender": "Male",
        "standard": 8
    },
    ...
]
```

#### Response

```

Successfully added 4 students
```

<MultiLineQuickTip>

The controller method that handles this API 3 consists of the parameter of type `ArrayList<Student>`.
</MultiLineQuickTip>

### API 4

#### Path: `/students/{studentId}`

#### Method: `GET`

#### Description:

Returns a student based on the `studentId`. If the given `studentId` is not found in the `student` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.


#### Success Response

```
{
    "studentId": 13,
    "studentName": "Olivia",
    "gender": "Female",
    "standard": 3
}
```

### API 5

#### Path: `/students/{studentId}`

#### Method: `PUT`

#### Description:

Updates the details of a student in the `student` table based on the `studentId`.  Also, return the updated student details from the `student` table using the `studentId`.


#### Request

```
{
    "studentName": "Yuvi"
    "gender": "Male",
    "standard": 6
}
```

#### Success Response

```
{
    "studentId": 3,
    "studentName": "Yuvi",
    "gender": "Male",
    "standard": 6
}
```

### API 6

#### Path: `/students/{studentId}`

#### Method: `DELETE`

#### Description:

Deletes a student from the `student` table based on the `studentId`. 

**Do not modify the code in `SchoolApplication.java`***/
