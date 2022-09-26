package com.mkhitaryan.test.sax.service;

import com.mkhitaryan.test.sax.entity.Operation;

import java.util.List;

public interface OperationService {
    public void saveOperation(Operation operation);

    public List<Operation> showOperations();
}
