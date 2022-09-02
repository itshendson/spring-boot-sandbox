package itshendson.springbootsandbox.service;

import itshendson.springbootsandbox.entity.Department;
import itshendson.springbootsandbox.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        // Mocking departmentRepository
        Department department = Department.builder()
                .departmentName("Finance")
                .departmentAddress("Toronto")
                .departmentCode("FIN-123")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Finance"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on valid Department name.")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        // Given
        String departmentName = "Finance";

        // When
        Department found = departmentService.fetchDepartmentByNameIgnoreCase(departmentName);

        // Then
        assertEquals(departmentName, found.getDepartmentName());
    }
}