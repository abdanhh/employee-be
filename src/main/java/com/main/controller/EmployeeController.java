package com.main.controller;

import com.main.dtos.RequestDTO;
import com.main.exception.ResourceNotFoundException;
import com.main.models.Employee;
import com.main.models.Position;
import com.main.repositories.DivisionRepository;
import com.main.repositories.EmployeeRepository;
import com.main.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/main")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    DivisionRepository divisionRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<?>> getAllEmployees(){
        List<RequestDTO> requestDTOS =new ArrayList<RequestDTO>();
        for (Employee employee : employeeRepository.findAll()){
            RequestDTO r = new RequestDTO();
            r.setId(employee.getId());
            r.setName(employee.getName());
            r.setNik(employee.getNik());
            r.setCreatedDate(r.getCreatedDate());
            r.setPositionId(employee.getPositionId());
            r.setDivisionId(employee.getDivisionId());
//            Position pst = positionRepository.findById(employee.getPositionId()).orElseThrow(() -> new ResourceNotFoundException("Position", "id", employee.getPositionId()));
//            if (pst.getId() != employee.getPositionId()){
//                throw new ResourceNotFoundException("Id Not Found");
//            }
//            r.setPositionId(pst.getName());
            Position pst2 = positionRepository.findById(employee.getLastPosition()).orElseThrow(() -> new ResourceNotFoundException("Position", "id", employee.getPositionId()));
            if (pst2.getId() != employee.getLastPosition()){
                throw new ResourceNotFoundException("Id Not Found");
            }
            r.setLastPosition(pst2.getName());
//            Division dvs = divisionRepository.findById(employee.getDivisionId()).orElseThrow(() -> new ResourceNotFoundException("Division", "id", employee.getPositionId()));
//            if (dvs.getId() != employee.getDivisionId()){
//                throw new ResourceNotFoundException("Id Not Found");
//            }
//            r.setDivisionId(dvs.getName());
            r.setType(employee.getType());
            r.setCreatedDate(employee.getCreatedDate());
            requestDTOS.add(r);

        }
        return ResponseEntity.ok(requestDTOS);
    }

    @GetMapping("/employee-sequence")
    public Long getEmployeeCurrentSequence(){
        return employeeRepository.count();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        if (employee.getId() != id){
            throw new ResourceNotFoundException("Id Not Found");
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@Validated @RequestBody Employee employee){
        Date now = new Date();
        employee.setCreatedDate(now);
        long employeeId = employeeRepository.findMaxid()+1;
        long a = 10000 + employeeId;
        String b = String.valueOf(a);
        String c = b.substring(b.length()-4);
        employee.setNik("EM"+c);

        employee.setType("PROMOTION");
        employee.setLastPosition(employee.getPositionId());
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@Validated @PathVariable(value = "id") Long id, @RequestBody Employee emp){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        if (employee.getId() != id){
            throw new ResourceNotFoundException("Id Not Found");
        }

        if (emp.getPositionId() <= employee.getLastPosition()){
            employee.setType("PROMOTION");
        } else {
            employee.setType("DEMOTION");
        }

        employee.setLastPosition(employee.getPositionId());
        employee.setPositionId(emp.getPositionId());

        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        if (employee.getId() != id){
            throw new ResourceNotFoundException("Id Not Found");
        }
        employeeRepository.delete(employee);
        return ResponseEntity.ok().build();
    }
}
