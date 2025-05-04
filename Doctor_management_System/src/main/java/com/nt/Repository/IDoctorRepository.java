package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
