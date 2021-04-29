package com.accolite.msproject.service.impl;

import com.accolite.msproject.model.Audit;
import com.accolite.msproject.repo.AuditRepo;
import com.accolite.msproject.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("AuditService")
@Transactional
public class AuditServiceImpl implements AuditService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AuditRepo auditRepo;

    @Override
    public List<Audit> getAllAudit() {
        return auditRepo.findAll();
    }

    @Override
    public int insertAudit(Audit audit) {
        String SQL = "INSERT INTO audit (date, user_name, user_email, operation, old_values, new_values) VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(SQL,new Object[]{
                audit.getDate(),
                audit.getUserName(),
                audit.getUserEmail(),
                audit.getOperation(),
                audit.getOldValues(),
                audit.getNewValues()
        });
        return result;
    }
}
