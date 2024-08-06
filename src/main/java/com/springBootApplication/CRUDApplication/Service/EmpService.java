package com.springBootApplication.CRUDApplication.Service;
import com.springBootApplication.CRUDApplication.Model.Employee;
import java.util.List;

public interface EmpService {

     List<Employee> getAllEmp();
     Employee getEmpByID(String id);
     Employee updateEmp(Employee employee);
     String removeEmp(String id);
     Employee addEmp(Employee employee);
     List<Employee> searchByKeyword(String key);



}
