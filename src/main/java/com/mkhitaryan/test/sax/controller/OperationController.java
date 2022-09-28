package com.mkhitaryan.test.sax.controller;

import com.mkhitaryan.test.sax.entity.Operation;
import com.mkhitaryan.test.sax.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping()// produces = "text/plain; charset=Windows-1251
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveOperation(@ModelAttribute("operation") Operation operation) {
        operationService.saveOperation(operation);
    }

    @ResponseBody
    @GetMapping(value = "/dog")
    public List<Operation> showOperations(@RequestParam(name = "date") Date date) {
        return operationService.showOperations(date);
    }
}
