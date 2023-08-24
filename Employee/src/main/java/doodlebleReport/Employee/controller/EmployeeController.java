package doodlebleReport.Employee.controller;

import doodlebleReport.Employee.entity.Employees;
import doodlebleReport.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmp")
    public ResponseEntity<String> addUser(@RequestBody Employees employee){
        return this.employeeService.addUser(employee);
    }

    @GetMapping("/login")
    public ResponseEntity<Map<String, String>> getUser(){
       Map<String,String> response = new HashMap<>();
       response.put("message","Hello FrontEnd");
       return ResponseEntity.ok(response);

    }

}