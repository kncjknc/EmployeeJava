package doodlebleReport.Employee.repository;

import doodlebleReport.Employee.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    public Optional<Employees> findByName(String username);

}
