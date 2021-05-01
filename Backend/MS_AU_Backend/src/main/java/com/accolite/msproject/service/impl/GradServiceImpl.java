package com.accolite.msproject.service.impl;

import com.accolite.msproject.exception.GradNotFoundException;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.repo.GradRepo;
import com.accolite.msproject.service.GradService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GradServiceImpl implements GradService {

    private final GradRepo gradRepo;

    @Autowired
    public GradServiceImpl(GradRepo gradRepo) {
        this.gradRepo = gradRepo;
    }

//Add grad to repo

    @Override
    public Grad addGrad(Grad grad) {


        return gradRepo.save(grad);
    }

   //list of all grads from the grad repo

    @Override
    public List<Grad> findAllGrads() {
        return gradRepo.findAll();
    }

   //update grad in the grad repo

    @Override
    public Grad updateGrad(Grad grad) {
        return gradRepo.save(grad);
    }

    //delete grad based on id from grad repo

    @Override
    public void deleteById(Integer id) {
        gradRepo.deleteById(id);
    }

    //find grad by its id from grad repo if not found throw custom exception

    @Override
    public Grad findGradById(Integer id) {
        return gradRepo.findGradById(id).orElseThrow(()->new GradNotFoundException("Grad by id "+id+" was not found"));
    }


}
