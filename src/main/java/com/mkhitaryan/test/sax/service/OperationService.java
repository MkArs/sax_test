package com.mkhitaryan.test.sax.service;

import com.mkhitaryan.test.sax.entity.Operation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface OperationService {
    void saveOperation(Operation operation);

    List<Operation> showOperations(Date date);
}
