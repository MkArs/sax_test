package com.mkhitaryan.test.sax.service;

import com.mkhitaryan.test.sax.dao.OperationDAO;
import com.mkhitaryan.test.sax.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationDAO operationDAO;

    @Override
    @Transactional
    public void saveOperation(Operation operation) {
        operationDAO.saveOperation(operation);
    }

    @Override
    @Transactional
    public List<Operation> showOperations(Date date) {
        return operationDAO.showOperations(date);
    }
}
