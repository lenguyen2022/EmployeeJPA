package ca.lenguyen.employeejpa.controllers;

import ca.lenguyen.employeejpa.beans.Employee;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class FunController {
    private List<Employee> employeeList = new ArrayList<>();
    @GetMapping("/pageOne")
    public String pageOne(HttpSession session){

        Employee employee = new Employee();
        employee.setName("John " + new Random().nextInt(1, 2000));
        employeeList.add(employee);
        session.setAttribute("employeeList", employeeList);
        return "page1";
    }
    @GetMapping("pageTwo")
    public String pageTwo(){
        return "page2";
    }

    @GetMapping("/readCookie")
    public String readCookie(Model model, @CookieValue(value = "username", defaultValue = "John") String userName) {
        model.addAttribute("userName",  userName);
        return "cookieOne";
    }

    @GetMapping("/funCookie")
    public String funCookie(Model model, @CookieValue(value = "username", defaultValue = "John") String userName) throws UnsupportedEncodingException {
        String decodeString = URLDecoder.decode(userName,StandardCharsets.UTF_8.toString());
        model.addAttribute("userName", decodeString);
        return "hello";
    }
    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse response) throws UnsupportedEncodingException {
        // create a cookie
        String s = URLEncoder.encode("Kelly Jordan", StandardCharsets.UTF_8.toString());

        //String s = "Kelly Jordan";
        Cookie cookie = new Cookie("username", s);
        cookie.setMaxAge(22222);
        //add cookie to response
        response.addCookie(cookie);


        return "redirect:readCookie";
    }

}
