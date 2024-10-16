/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 *
 */

// Write your code here
package com.example.school.service;

import com.example.school.model.Student;
import com.example.school.model.StudentRowMapper;
import com.example.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentH2Service implements StudentRepository {

    @Autowired
    JdbcTemplate db;

    @Override
    public ArrayList<Student> getStudents() {
        List<Student> res = db.query("select * from student", new StudentRowMapper());
        ArrayList<Student> students = new ArrayList<>(res);
        return students;
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            return db.queryForObject("select * from student where studentId=?", new StudentRowMapper(), studentId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + studentId + " not found");
        }
    }


    @Override
    public Student addStudent(Student student) {
        db.update("insert into student(studentName,gender,standard) values(?,?,?)",
                student.getStudentName(), student.getGender(), student.getStandard());

        Student addedStudent = db.queryForObject(
                "select * from student where studentName=? and gender=? and standard=?",
                new StudentRowMapper(), student.getStudentName(), student.getGender(), student.getStandard());
        return addedStudent;
    }

    @Override
    public int addStudents(ArrayList<Student> students) {
        int rowsAffected = 0;
        try {
            for (Student student : students) {
                int result = db.update("insert into student(studentName, gender, standard) values(?,?,?)",
                        student.getStudentName(), student.getGender(), student.getStandard());
                rowsAffected += result;
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while adding students");
        }
        return rowsAffected;
    }


    @Override
    public Student updateStudent(int studentId, Student student) {
        if (student.getStudentName() != null) {
            db.update("UPDATE student SET studentName=? WHERE studentId=?", student.getStudentName(), studentId);
        }
        if (student.getGender() != null) {
            db.update("UPDATE student SET gender=? WHERE studentId=?", student.getGender(), studentId);
        }
        if (student.getStandard() != 0) {
            db.update("UPDATE student SET standard=? WHERE studentId=?", student.getStandard(), studentId);
        }

        return getStudentById(studentId);
    }

    @Override
    public void deleteStudent(int studentId) {
        db.update("delete from student where studentId=?", studentId);
    }
}