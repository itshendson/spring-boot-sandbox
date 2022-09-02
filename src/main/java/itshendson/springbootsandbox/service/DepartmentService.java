package itshendson.springbootsandbox.service;

import itshendson.springbootsandbox.entity.Department;
import itshendson.springbootsandbox.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department fetchDepartmentByNameIgnoreCase(String departmentName);
}
