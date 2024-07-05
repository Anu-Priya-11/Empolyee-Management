package net.javaguides.ms.service;

import net.javaguides.ms.dto.EmployeeDto;
import java.util.List;
import org.hibernate.annotations.ListIndexBase;



public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);

}
