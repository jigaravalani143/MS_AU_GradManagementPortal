package com.accolite.msproject.controllers;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.TestConfig;
import com.accolite.msproject.model.Audit;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.service.AuditService;
import com.accolite.msproject.service.impl.AuditServiceImpl;
import com.accolite.msproject.service.GradService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestConfig.class)
@WebMvcTest(AuditController.class)
public class AuditControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AuditService auditService;

    @MockBean
    public AuditServiceImpl auditServiceImpl;

    @Autowired
    public ObjectMapper objectMapper;

    @Test
    public void getAllAudit() throws Exception{
        ArrayList<Audit> auditArrayList = new ArrayList<>();
        Audit audit = EntityData.setAuditObj();
        auditArrayList.add(audit);
        Mockito.when(auditServiceImpl.getAllAudit()).thenReturn(auditArrayList);
        mockMvc.perform(get("/audit/getAll")).andExpect(status().isOk());
    }

    @Test
    public void addAudit() throws Exception{
        ArrayList<Audit> auditArrayList = new ArrayList<>();
        Audit audit = new Audit("jigar","jigar.avalani@accolitedigital.com","Add","Old Val","New Val");
        audit.setId(1);
        String jsonString = objectMapper.writeValueAsString(audit);
        Mockito.when(auditServiceImpl.insertAudit(audit)).thenReturn(1);
        mockMvc.perform(post("/audit/addAudit")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonString)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());
    }


}
