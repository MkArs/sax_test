package com.mkhitaryan.test.sax.dao;

import com.mkhitaryan.test.sax.entity.Operation;

import java.sql.Date;
import java.util.List;

public interface OperationDAO {
    public void saveOperation(Operation operation);

    public List<Operation> showOperations(Date date);
}
