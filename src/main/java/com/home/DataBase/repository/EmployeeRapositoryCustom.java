package com.home.DataBase.repository;

import java.util.Date;

/**
 * Created by AlVlShcherbakov on 07.12.2018.
 */
public interface EmployeeRapositoryCustom {

    public Long getMaxEmpId();

    public Long updateEmployee(Long empId, String fullName, Date hireDate);
}
