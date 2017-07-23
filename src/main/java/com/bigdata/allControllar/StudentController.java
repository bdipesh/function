package com.bigdata.allControllar;

import com.bigdata.entities.Student;
import com.bigdata.repositories.StudentRepository;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
//@GetMapping helps to get the data from database    findstudent select all student and kept in list

    @GetMapping("/students")
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }
//@PostMapping helps to insert the data to database  

    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        try {
            studentRepository.save(student);
            return ResponseEntity.ok("Data Inserted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Data could insert. ERROR");
        }

    }

    @DeleteMapping("/students")
    public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
        try {
            studentRepository.delete(student);
            return ResponseEntity.ok("Data Deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something Error occur");
        }

    }
    
    @GetMapping("/user")
  public Principal user(Principal principal) {
    return principal;
  }

    @PutMapping("/students/(id)")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student, @RequestParam String action) {

    }
}
