package com.mkhitaryan.test.sax.dao;

import com.mkhitaryan.test.sax.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OperationDAOImpl implements OperationDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveOperation(Operation operation) {
        Session session = sessionFactory.getCurrentSession();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        // Получаю текущего пользователя веб-приложения
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        operation.setDate(java.time.LocalDate.now());
        operation.setUsername(username);

        session.saveOrUpdate(operation);
    }

    @Override
    public List<Operation> showOperations() {
        return null;
    }
}
