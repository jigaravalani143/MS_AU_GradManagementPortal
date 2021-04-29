package com.accolite.msproject.service;

import com.accolite.msproject.model.Audit;

import java.util.List;

public interface AuditService {
    public List<Audit> getAllAudit();

    public int insertAudit(Audit audit);
}
