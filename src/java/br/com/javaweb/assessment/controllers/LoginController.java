/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javaweb.assessment.controllers;

import br.com.javaweb.assessment.dao.UserDao;
import br.com.javaweb.assessment.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hp
 */
@Controller
public class LoginController {
    
      @RequestMapping(value="/login.htm", method = RequestMethod.GET)
    public String chamarLogin(@ModelAttribute("user") User user, HttpSession session, HttpServletRequest req){

        return"login";
    }
    
    
    @RequestMapping(value="/logar.htm", method = RequestMethod.POST)
    public String logar(@ModelAttribute("user") User user, 
    HttpSession session, HttpServletRequest req){
        
        UserDao dao = new UserDao();
        if(dao.validarUser(user)){
            User u = dao.persistirUser(user);
            session.setAttribute("token", "aprovado");
            req.setAttribute("msg1", "Olá "+u.getName()+", você está logado.");
        return"books";  
        }else{
                req.setAttribute("msg1", "Dados não conferem, tente novamente");
                return "login";
             }
    }
    
    
}