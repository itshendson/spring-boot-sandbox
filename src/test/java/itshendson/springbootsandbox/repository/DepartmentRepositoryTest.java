package itshendson.springbootsandbox.repository;

import itshendson.springbootsandbox.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    // The entityManager allows us to mock insert an entry to the database without ACTUALLY creating a department in our production database.
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Human Resources")
                .departmentAddress("Los Angeles")
                .departmentCode("HR-000")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Human Resources");
    }
}