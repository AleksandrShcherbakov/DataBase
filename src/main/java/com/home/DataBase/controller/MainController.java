package com.home.DataBase.controller;

import com.home.DataBase.entity.Employee;
import com.home.DataBase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Random;

/**
 * Created by AlVlShcherbakov on 07.12.2018.
 */
@Controller
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final  String[] NAMES = new String[]{"Tom", "Jerry", "Donald"};

    @ResponseBody
    @RequestMapping("/")
    public String home(){
        String html="";
        html+="<ul>";
        html+="<li><A href='/testInsert'>Test Insert</a></li>";
        html+="<li><A href='/showAllEmployee'>Show All Employee</a></li>";
        html+="<li><A href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html+="<li><A href='/deleteAllEmployee'>Delete All Employee</a></li>";
        html+="</ul>";
        return html;
    }

    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert(){

        Long empIdMax = this.employeeRepository.getMaxId();

        Employee employee = new Employee();

        int random = new Random().nextInt(3);

        long id = empIdMax+1;
        String fullName = NAMES[random]+" "+id;

        employee.setId(id);
        employee.setEmpNo("E"+id);
        employee.setFullName(fullName);
        employee.setHireDate(new Date());
        this.employeeRepository.save(employee);

        return "Instead: "+employee;
    }




}
