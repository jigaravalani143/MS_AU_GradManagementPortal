package com.accolite.msproject.controllers;

import com.accolite.msproject.EntityData;
import com.accolite.msproject.TestConfig;
import com.accolite.msproject.model.Audit;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.service.AuditService;
import com.accolite.msproject.service.GradService;
import com.accolite.msproject.service.impl.AuditServiceImpl;
import com.accolite.msproject.service.impl.GradServiceImpl;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(TestConfig.class)
@WebMvcTest(GradController.class)
class GradControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GradService gradService;

    @MockBean
    AuditService auditService;

//    @MockBean
//    public GradServiceImpl gradServiceImpl;

//    @MockBean
//    public AuditServiceImpl auditServiceImpl;

    @Test
    void getAllGrads() throws Exception {
        Grad grad= EntityData.getGrad();
        grad.setId(1);
        List<Grad> grads=new ArrayList<>();
        grads.add(grad);

        when(gradService.findAllGrads()).thenReturn(grads);

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/grad/all"))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(result).isNotNull();


        System.out.println(result.getResponse().getContentAsString());


    }

    @Test
    void getGradById() throws Exception {
        Grad grad= EntityData.getGrad();
        grad.setId(1);
        when(gradService.findGradById(anyInt())).thenReturn(grad);

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/grad/find/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(grad.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(grad.getId()))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void updateGrad() throws Exception {
        Grad grad= EntityData.getGrad();
        grad.setId(1);
        grad.setName("new name");
        Mockito.when(gradService.updateGrad(grad)).thenReturn(grad);

        Mockito.when(gradService.findGradById(1)).thenReturn(grad);
        Mockito.when(gradService.addGrad(grad)).thenReturn(grad);

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.put("/grad/update")
                .header("Email","jigar.avalani@accolitedigital.com")
                .header("Name","Jigar Avalani")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(grad)))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());

    }

    @Test
    void deleteGrad() throws Exception {

        Grad grad = EntityData.getGrad();
        Mockito.when(gradService.findGradById(1)).thenReturn(grad);

        Audit audit = EntityData.setAuditObj();
        Mockito.when(auditService.insertAudit(audit)).thenReturn(1);


        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.delete("/grad/delete/1")
        .header("Email","jigar.avalani@accolitedigital.com")
        .header("Name","Jigar Avalani"))
                .andExpect(status().isOk())
                .andReturn();
        assertThat(result.getResponse().getContentAsString()).isEqualTo("");
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void addGrad() throws Exception {
        Grad grad= EntityData.getGrad();
        grad.setId(1);

        when(gradService.addGrad(any(Grad.class))).thenReturn(grad);

        MvcResult result= mockMvc.perform(MockMvcRequestBuilders.post("/grad/add")
                .header("Email","jigar.avalani@accolitedigital.com")
                .header("Name","Jigar Avalani")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(grad)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(grad.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(grad.getId()))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());



    }
}