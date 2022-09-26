package com.mkhitaryan.test.sax.controller;

import com.mkhitaryan.test.sax.entity.Operation;
import com.mkhitaryan.test.sax.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/converter")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void saveOperation(@ModelAttribute("operation") Operation operation){
        operationService.saveOperation(operation);
    }
}
