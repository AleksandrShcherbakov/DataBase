package com.home.DataBase.controller;

import com.home.DataBase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by AlVlShcherbakov on 07.12.2018.
 */
@Controller
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final  String[] NAMES = new String[]{"Tom", "Jerry", "Donald"};

    
}
