package ca.lenguyen.employeejpa.controllers;

import ca.lenguyen.employeejpa.beans.Employee;
import ca.lenguyen.employeejpa.databases.EmployeeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("employeeList", employeeRepository.findAll());
        model.addAttribute("emailList", employeeRepository.findById(1L).get().getEmails());
        return "index";
    }
}
