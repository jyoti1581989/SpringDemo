package com.example.SpringDemo.service;

import com.example.SpringDemo.model.Emp;
import com.example.SpringDemo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepo;

    public List<Emp> getAllEmps() {
        return empRepo.findAll();
    }

    public Emp getEmpByEmpno(Integer empno) {
        Optional<Emp> opEmp = empRepo.findById(empno);
        if (opEmp.isPresent()) {
            return opEmp.get();
        } else {
            return new Emp();
        }

    }

    public void add(Emp emp) {
        empRepo.save(emp); //insert query

    }

    public void upsert(Emp emp) {
        empRepo.save(emp);
    }


    public void deleteEmp(int empno){
        empRepo.deleteById(empno);
    }
}
