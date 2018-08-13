/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javaweb.assessment.controllers;

import br.com.javaweb.assessment.dao.BookDao;
import br.com.javaweb.assessment.dao.UserDao;
import br.com.javaweb.assessment.model.Books;
import br.com.javaweb.assessment.model.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hp
 */
@Controller
public class BookController {
    Integer id = null;
    @RequestMapping(value="/books.htm", method = RequestMethod.POST)
    public String books(@ModelAttribute("book")Books book){
        return "books";
    }    
    
    @RequestMapping(value="/cadastrobook.htm", method = RequestMethod.GET)
    public String callCadastroBook(@ModelAttribute("book")Books book){
        return "cadastrobook";
    }
   
    
    @RequestMapping(value="/cadastrarbook.htm", method = RequestMethod.POST)
    public String cadastrarBook(@ModelAttribute("book")Books book, HttpServletRequest req){
       try {  
            BookDao dao = new BookDao();
            dao.cadastrarBook(book);
            req.setAttribute("msg1", "Novo livro cadastrado com sucesso.");
            return "books";
       
       
       } catch (Exception e) {
           req.setAttribute("msg1", "Por favor preencha todos os campos");
        return "cadasdrobook";
       }   
    }
    
    @RequestMapping(value="/consultarbooks.htm", method = RequestMethod.GET)
    public String callConsulta(@ModelAttribute("book")Books book, HttpServletRequest req){
        BookDao bdao = new BookDao();
        List<Books> books = bdao.consultarBooks();
        req.setAttribute("books",books);
       
        return "consultabook";
    }
    @RequestMapping(value="/editabook.htm", method = RequestMethod.POST)
    public String callEditaBook(@ModelAttribute("book")Books book, HttpServletRequest req){
        Integer idb = Integer.valueOf(req.getParameter("idBook"));
        Books b = new Books();
        b.setIdbook(idb);
        BookDao bdao = new BookDao();
        b = bdao.persistirBook(b);
        req.setAttribute("id1",b.getIdbook());
        req.setAttribute("titulo1",b.getTitulo());
        req.setAttribute("autor1",b.getAutor());
        req.setAttribute("editora1",b.getEditora());
        req.setAttribute("ano1",b.getAno());
        return "editabook";
    }
    @RequestMapping(value="/editarbook.htm", method = RequestMethod.POST)
    public String editarBook(@ModelAttribute("book")Books book, HttpServletRequest req){
            BookDao bdao = new BookDao();
            bdao.editarBook(book);
        
        List<Books> books = bdao.consultarBooks();
        req.setAttribute("books",books);
         return "consultabook";
    } 
    
    @RequestMapping(value="/excluirbook.htm", method = RequestMethod.POST)
    public String excluirBook (@ModelAttribute("book")Books book, HttpServletRequest req){
        Integer idb = Integer.valueOf(req.getParameter("idExcluir"));
        Books b = new Books();
        b.setIdbook(idb);
        BookDao bdao = new BookDao();
        bdao.excluirBook(b);
        List<Books> books = bdao.consultarBooks();
        req.setAttribute("books",books);
        
        return "consultabook";
    }
}
