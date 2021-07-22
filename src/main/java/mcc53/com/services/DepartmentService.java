/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcc53.com.services;

import java.util.List;
import mcc53.com.models.Department;
import mcc53.com.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WahyuKu
 */
@Service
public class DepartmentService {
    
    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
    
    public Department findByEmployeeId(Long id) {
        return departmentRepository.findByEmployees_id(id);
    }
}
