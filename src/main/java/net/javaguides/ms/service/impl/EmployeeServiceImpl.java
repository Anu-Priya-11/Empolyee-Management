package net.javaguides.ms.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ms.dto.EmployeeDto;
import net.javaguides.ms.entity.Employee;
import net.javaguides.ms.exception.ResourceNotFoundException;
import net.javaguides.ms.mapper.EmployeeMapper;
import net.javaguides.ms.repository.EmployeeRepository;
import net.javaguides.ms.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService { //to create the spring beam for this class
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){ //we need to convert empdto int emp jp entity bcoz we need to store emp entity into database
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto); //converted empd2 to em jp
        Employee savedEmployee = employeeRepository.save(employee); //it has saver mathod
        return EmployeeMapper.mapToEmployeeDto(savedEmployee); //returned the saved emp
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));//return a emp object //lamda expration
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll(); //to map one object into other
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)) //to convert empjpa (empid) into empdtos //call empmapper
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setFirstName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee); //it perfrm the updated emp obj
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );
        employeeRepository.deleteById(employeeId);
        System.out.println("employee deleted"+employeeId);
    }
}
