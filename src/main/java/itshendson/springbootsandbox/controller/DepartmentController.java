package itshendson.springbootsandbox.controller;

import itshendson.springbootsandbox.entity.Department;
import itshendson.springbootsandbox.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    // Tell Spring to map the DepartmentService bean to the DepartmentService reference you created below.
    @Autowired
    private DepartmentService departmentService;

    /**
     * This is the slf4j logger in-built to Spring. Another logger is logback
     */
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    /**
     *
     * @param department the @RequestBody converts the json to Department object.
     * @return Department
     */
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Log: saveDepartment in DepartmentController");
//      DepartmentService service = new DepartmentServiceImpl(); You are using Spring, don't manually create new object! Spring should have control of creating new objects. Inversion of Control!!!
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Log: fetchDepartmentList in DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully.";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByNameIgnoreCase(departmentName);
    }
}
