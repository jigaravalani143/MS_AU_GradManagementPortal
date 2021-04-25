package com.accolite.msproject.repo;

import com.accolite.msproject.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface AuditRepo extends JpaRepository<Audit,Integer> {
}
