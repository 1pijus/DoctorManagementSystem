package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IDoctorRepository;
import com.nt.model.Doctor;

@Service
public class IDoctorMgmtServiceImpl implements IDoctorMgmtService {
  @Autowired
  private IDoctorRepository docRepo;
  
  @Override
  public List<Doctor> showAllDoctor() {
    
    return docRepo.findAll();

  }
  
  @Override
  public String registerDoctor(Doctor doctor) {
     //set windows Username As the created by username
    doctor.setCreatedBy(System.getProperty("user.name"));
    //save the Object
    int idValue=docRepo.save(doctor).getDid();
   
    return "Doctor is Saved with id Value"+idValue;
  }

  
  @Override
  public Doctor fetchDoctorById(int id) {
     Doctor doc=docRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
    return doc;
  }
  
@Override
  public String editDoctor(Doctor doctor) {
  System.out.println(doctor.getDid());
    Optional<Doctor> opt=docRepo.findById(doctor.getDid());
    
    if(opt.isPresent())
    {
      Doctor doctor1=opt.get();
      doctor.setUpdateCount(doctor1.getUpdateCount());
      doctor.setUpdatedBy(System.getProperty("user.name"));
      docRepo.save(doctor);
      return doctor.getDid()+"Doctor is Modified";
    }

    return doctor.getDid()+"Doctor is not Modified";
  }

@Override
public String deleteDoctor(int id) {
     Optional<Doctor>opt=docRepo.findById(id);
     if(opt.isPresent())
     {
       docRepo.deleteById(id);
       return "The Id no of " +id+" Doctor has been Succesfuly Removed";
       
     }
  return "The doctor not Found";
}
}
