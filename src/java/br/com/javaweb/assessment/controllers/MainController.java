/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javaweb.assessment.controllers;

import br.com.javaweb.assessment.dao.UserDao;
import br.com.javaweb.assessment.model.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hp
 */
@Controller
public class MainController {
    @RequestMapping(value="/index.htm", method = RequestMethod.GET)
    public String callIndex(){
    return "index";
    }
    
    @RequestMapping(value="/cadastro.htm", method = RequestMethod.GET)
    public String callCadastro(@ModelAttribute("user")User user){
    return "cadastro";
    }
    
    @RequestMapping(value="/cadastrar.htm", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute("user")User user, HttpServletRequest req){
       try {  
            UserDao dao = new UserDao();
            dao.cadastrarUser(user);
            req.setAttribute("msg1", "Olá"+user.getName()+": você está cadastrado.");
            req.setAttribute("msg2", "Seu login é: "+user.getEmail());
            return "index";
       
       
       } catch (Exception e) {
           req.setAttribute("msg1", "Por favor preencha todos os campos");
           req.setAttribute("msg2", "Use um email não cadastrado");
        return "cadastro";
       }
           
        
         
    }
    
    
}
