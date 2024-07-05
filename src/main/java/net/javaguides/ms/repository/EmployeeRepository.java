package net.javaguides.ms.repository;

import net.javaguides.ms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//entity , primary key

public interface EmployeeRepository extends JpaRepository<Employee , Long> {

}
