package com.accolite.msproject.controllers;


import com.accolite.msproject.model.Audit;
import com.accolite.msproject.service.impl.AuditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("audit")
public class AuditController {
    @Autowired
    AuditServiceImpl auditServiceImpl;

    //Get the user operations log for audit from audit table

    @GetMapping(value = "/getAll")
    public List<Audit> getAllAudit()
    {
        List<Audit> auditList;
        auditList = auditServiceImpl.getAllAudit();
        return auditList;
    }

    //Add the operations log entry in the audit table

    @PostMapping(value = "/addAudit")
    public int addAudit(@RequestBody Audit audit)
    {
        return auditServiceImpl.insertAudit(audit);
    }

}
