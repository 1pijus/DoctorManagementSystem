package com.nt.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_DOCTOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor {
  @SequenceGenerator(name="gen1",sequenceName = "DID_SEQ",initialValue = 1000,allocationSize = 1)
  @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
  @Id
  @Column(name="doctor_id")
  private Integer did;
  
  @Column(name="doctor_name",length = 30)
  @NonNull
  private String dname;
  
  @Column(name="doctor_qlfy",length=30)
  @NonNull
  private String qlfy;
  
  @Column(name="doctor_incom")
  @NonNull
  private Long income;
  
  @Column(name="doctor_mobileno")
  @NonNull
  private Long mobileno;
  
  @Column(name="doctor_specialization" ,length=30)
  @NonNull
  private String specialization;
  
  
  @CreationTimestamp
  @Column(updatable = false)
  private LocalDateTime createDate;//time Stamp Feature 
  @CreationTimestamp
  @Column(insertable = false)
  private LocalDateTime updateDate;//time Stamp Feature 
   
  @Version
  private Integer updateCount;  //Versioning Feature 
  @Column(length=20)
  private String createdBy;
  @Column(length=20)
  private String updatedBy;
}
