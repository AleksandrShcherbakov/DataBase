package com.home.DataBase.repository;

import com.home.DataBase.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by AlVlShcherbakov on 07.12.2018.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByEmpNo(String empNo);

    List<Employee> findByFullNameLike(String fullName);

    List<Employee> findByHireDateGraterThan(Date hireDate);

    @Query("select coalesce(max(e.id),0) from Employee e")
    Long getMaxId();
}
