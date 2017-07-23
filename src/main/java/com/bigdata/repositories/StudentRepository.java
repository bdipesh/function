
package com.bigdata.repositories;

import com.bigdata.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    
}
