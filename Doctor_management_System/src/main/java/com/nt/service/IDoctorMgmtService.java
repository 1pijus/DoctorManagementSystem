package com.nt.service;

import java.util.List;

import com.nt.model.Doctor;

public interface IDoctorMgmtService {

  public List<Doctor> showAllDoctor();
  public String registerDoctor(Doctor doctor);
  public Doctor fetchDoctorById(int id);
  public String editDoctor(Doctor doctor);
  public String deleteDoctor(int id);
}
