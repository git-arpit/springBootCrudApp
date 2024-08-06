package com.springBootApplication.CRUDApplication.Repository;
import com.springBootApplication.CRUDApplication.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByCommentsContainingIgnoreCase(String keyword);

}
