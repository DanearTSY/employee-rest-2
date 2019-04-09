package com.example.employeerestdemo.controller;

import com.example.employeerestdemo.model.Cache;
import com.example.employeerestdemo.model.Employee;
import com.example.employeerestdemo.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {

    @Autowired //dependency injection
    private Cache cache;

    @Autowired
    private EmployeeDao employeeDao;

    //method
    @RequestMapping(value = "api/v1/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee input){
        Long id = employeeDao.save(input);
        input.setId(id);
        return input;
    }

}
