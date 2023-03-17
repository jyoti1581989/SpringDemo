package com.example.SpringDemo.controller;

import com.example.SpringDemo.model.Emp;
import com.example.SpringDemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/all")
    public List<Emp> getAllEmp() {
        return empService.getAllEmps();
    }

    @GetMapping("/id/{empno}")
    public ResponseEntity<Object> getEmpByEmpno(@PathVariable Integer empno) {
        Emp employee = empService.getEmpByEmpno(empno);
        if (employee.getEmpno() == 0) {
            return new ResponseEntity<>("STUDENT DOESN'T EXIT", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addEmp(@RequestBody Emp emp) {
        empService.upsert(emp);
    }

    @PutMapping("/update")
    public void updateEmp(@RequestBody Emp emp) {
        empService.upsert(emp);
    }

    @DeleteMapping("/delete/{empno}")
    public void deleteEmp(@PathVariable("empno") int empno) {
        empService.deleteEmp(empno);
    }
}

