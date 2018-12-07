package com.home.DataBase.repository.customImpl;

import com.home.DataBase.entity.Employee;
import com.home.DataBase.repository.EmployeeRapositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;

/**
 * Created by AlVlShcherbakov on 07.12.2018.
 */
@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRapositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public Long getMaxEmpId() {
        try{
            String sql= "Select coalesce(max(e.id), 0) from Employee e";
            Query query = entityManager.createQuery(sql);
            return (Long) query.getSingleResult();
        }
        catch (NoResultException e){
            return 0L;
        }
    }

    @Override
    public Long updateEmployee(Long empId, String fullName, Date hireDate) {
        Employee e = entityManager.find(Employee.class, empId);
        if (e==null){
            return 0;
        }
        e.setFullName(fullName);
        e.setHireDate(hireDate);
        entityManager.flush();
        return 1;
    }
}
