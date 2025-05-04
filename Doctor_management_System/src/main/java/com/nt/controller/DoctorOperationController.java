package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Doctor;
import com.nt.service.IDoctorMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorOperationController {
  
  @Autowired
  private IDoctorMgmtService docService;  
  
  @GetMapping("/")
  public String showHomepage()
  {
    return "welcome";
  }
  
  @GetMapping("/report") //(G) 
   public String showReport(Map<String, Object> map)
   {
     List<Doctor> list=docService.showAllDoctor();
     map.put("listDoctor", list);
     
     return "show_report";
   }
  
  @GetMapping("/register")
  public String showRegistrationForm(@ModelAttribute("doctor") Doctor doctor)
  {
    
    return "doctor_register_form";
  }
  
  /*  @PostMapping("/register")//double posting problem code
  public String registerDoctor(@ModelAttribute("doctor") Doctor doctor,Map<String, Object> map)
  {
    String msg=docService.registerDoctor(doctor);
    List<Doctor> list=docService.showAllDoctor();
    map.put("listDoctor", list);
    map.put("resultmsg", msg);
    
    return "show_report";
  }*/
  
  /*  @PostMapping("/register")//solution 1-implementing PRG(POST-REDIRECT-GET) pattern(p)
  public String registerDoctor(@ModelAttribute("doctor") Doctor doctor,Map<String, Object> map)
  {
    //use service
    String msg=docService.registerDoctor(doctor);
    //keep the result in model attribute
    map.put("resultmsg", msg);
    //return lvn
    return "redirect:report";//(R)
  }*/
  
    
    @PostMapping("/register")//solution 2-using Special Shared Memory(best solution )
  public String registerDoctor(@ModelAttribute("doctor") Doctor doctor,RedirectAttributes attrs)
  {
    //use service
    String msg=docService.registerDoctor(doctor);
    //keep the result in model attribute
    attrs.addFlashAttribute("resultmsg", msg);
    //return lvn
    return "redirect:report";//(R)
  }
  
  /*    @PostMapping("/register")//solution 3-using Session attribute
  public String registerDoctor(@ModelAttribute("doctor") Doctor doctor,HttpSession ses)
  {
    //use service
    String msg=docService.registerDoctor(doctor);
    //keep the result in model attribute
    ses.setAttribute("resultmsg", msg);
    //return lvn
    return "redirect:report";//(R)
  }*/
    
    @GetMapping("/edit")
    public String showEditpage(@ModelAttribute("doctor") Doctor doctor,@RequestParam("no") int id)
    {
      //use Service
     Doctor doctor1=docService.fetchDoctorById(id);
     //Copy Doctor1 object to Doctor Object(ModelAttribute)
     BeanUtils.copyProperties(doctor1, doctor);
      
      return "doctor_edit_form";
    }
    
    @PostMapping("/edit")
    public String editDoctor(@ModelAttribute("doctor") Doctor doctor,RedirectAttributes attrs)
    {
     
      //use Service
      String msg=docService.editDoctor(doctor);
      //keep the result in the flush attribute
      
      attrs.addFlashAttribute("resultmsg",msg);
      
      return "redirect:report";
    }
    
    @GetMapping("delete")
    public String deleteDoctor(@RequestParam("no") int id,Map<String , Object> map)
    {
      //use Service
      String msg=docService.deleteDoctor(id);
      map.put("resultmsg", msg);
      
      return "forward:report";
    }
  
}
