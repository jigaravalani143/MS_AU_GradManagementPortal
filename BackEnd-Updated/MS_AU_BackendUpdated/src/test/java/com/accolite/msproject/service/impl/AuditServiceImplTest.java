package com.accolite.msproject.service.impl;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.exception.GradNotFoundException;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.repo.GradRepo;
import com.accolite.msproject.repo.AuditRepo;
import com.accolite.msproject.model.Audit;
import com.accolite.msproject.service.impl.AuditServiceImpl;
import com.accolite.msproject.service.AuditService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuditServiceImplTest {

    @MockBean
    AuditRepo auditRepo;

    @Autowired
    AuditServiceImpl auditService;

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    AuditServiceImpl auditServiceImpl;

    @Test
    void addGrad() {
        int expectedVal = 1;
        Audit audit = EntityData.setAuditObj();
        Mockito.when(jdbcTemplate.update(
                Mockito.anyString(),
                (Object[]) Mockito.any()
        )).thenReturn(expectedVal);
        int resultVal = auditServiceImpl.insertAudit(audit);
        Assert.assertEquals(expectedVal, resultVal);
    }

    @Test
    void getAllAudit() {
        Audit audit = EntityData.setAuditObj();
        audit.setId(1);
        List<Audit> audits = new ArrayList<>();
        audits.add(audit);

        when(auditRepo.findAll()).thenReturn(audits);

        assertThat(auditService.getAllAudit()).isEqualTo(audits);
    }

}
