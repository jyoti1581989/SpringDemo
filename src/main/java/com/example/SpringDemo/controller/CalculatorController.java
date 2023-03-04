package com.example.SpringDemo.controller;

import com.example.SpringDemo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired//dependency injection
    CalculatorService calcService;


    @GetMapping("/add/{first}/{second}")
    public ResponseEntity<Object> add(@PathVariable("first") double firstNumber,
                                               @PathVariable("second") double secondNumber) {
        if(firstNumber == 0 || secondNumber == 0){
            return new ResponseEntity<>("INVALID INPUT, PLEASE CHECK AND RETRY", HttpStatus.BAD_REQUEST);
        }
        double result = calcService.add(firstNumber, secondNumber);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @GetMapping("/subtract/{first}/{second}")
    public ResponseEntity<Object> subtract(@PathVariable("first") double firstNumber,
                                      @PathVariable("second") double secondNumber) {
        if(firstNumber == 0 || secondNumber == 0){
            return new ResponseEntity<>("INVALID INPUT, PLEASE CHECK AND RETRY", HttpStatus.BAD_REQUEST);
        }
        double result = calcService.subtract(firstNumber, secondNumber);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @GetMapping("/multiply/{first}/{second}")
    public ResponseEntity<Object> multiply(@PathVariable("first") double firstNumber,
                                      @PathVariable("second") double secondNumber) {
        if(firstNumber == 0 || secondNumber == 0){
            return new ResponseEntity<>("INVALID INPUT, PLEASE CHECK AND RETRY", HttpStatus.BAD_REQUEST);
        }
        double result = calcService.multiply(firstNumber, secondNumber);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @GetMapping("/divide/{first}/{second}")
    public ResponseEntity<Object> divide(@PathVariable("first") double firstNumber,
                                      @PathVariable("second") double secondNumber) {
        if(firstNumber == 0 || secondNumber == 0){
            return new ResponseEntity<>("INVALID INPUT, PLEASE CHECK AND RETRY", HttpStatus.BAD_REQUEST);
        }
        double result = calcService.divide(firstNumber, secondNumber);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}