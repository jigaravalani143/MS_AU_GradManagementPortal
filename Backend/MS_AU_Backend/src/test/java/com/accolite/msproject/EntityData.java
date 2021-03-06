package com.accolite.msproject;

import com.accolite.msproject.model.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class EntityData {

    public static String[] getSkillsData(){
        String [] skillArray=new String[]{"Java","Spring","Angular","React","Mysql","Other"};
        return skillArray;
    }
    public static String[] getLocData(){
        String [] locArray=new String[]{"Mumbai","Bangalore","Delhi","Hyderabad","Chennai","Other"};

        return locArray;
    }
    public static String[] getInstrData(){
        String [] instrArray=new String[]{"DJSCE","SPIT","KJSCE","TECT","VJTI","Other"};
        return instrArray;
    }
    public static Grad getGrad(){
        int i=1;
        Grad grad = new Grad();
        grad.setLoc(new Location(i+1, getLocData()[i]));
        grad.setInstitute(new Institute(i+1, getInstrData()[i]));
        grad.setJoin_loc(new Location(i+1, getLocData()[i]));
        grad.setContact("0123456789");
        grad.setDescription("SDE Full time");
        grad.setFeedback("Excellent");
        grad.setName("Stefan" + i+1);
        grad.setEmail("stefan" + i+1 + "@gmail.com");
        grad.setTen_join_date("2021-06-15");
        Set<Skill> skillSet = new HashSet<>();
        skillSet.add(new Skill(i+1, getSkillsData()[i]));
        skillSet.add(new Skill(i+1+ 1, getSkillsData()[i+1]));
        grad.setSkills(skillSet);
        return grad;
    }
    public static Audit setAuditObj()
    {
        Audit audit = new Audit();
        audit.setId(1);
        audit.setUserName("jigar");
        audit.setUserEmail("jigar.avalani@accolitedigital.com");
        audit.setDate(new Date(System.currentTimeMillis()));
        audit.setOperation("Get");
        audit.setNewValues("New Val");
        audit.setOldValues("Old Val");
        return audit;
    }


}
