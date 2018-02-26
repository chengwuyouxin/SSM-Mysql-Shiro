package com.lpq.personallibrary.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lpq.personallibrary.entity.Book;
import com.lpq.personallibrary.service.BookService;

@Controller

public class BookController extends BaseController{
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/index",method = RequestMethod.GET)
	private String index(){
		return "index";
	}

	@RequestMapping(value="/list-books")
	private String getAllBooks(Model model){
		Subject subject=SecurityUtils.getSubject();
		if(!subject.isPermitted("/list-books")){
			return "unauthorized";
		}
		logger.info("/list-books");
		List<Book> books= bookService.getAllBooks();
		model.addAttribute("books", books);
		return "BookList";
	}

	@RequestMapping(value="/input-book")
	private String inputBook(Model model){
		Subject subject=SecurityUtils.getSubject();
		if(!subject.isPermitted("/input-book")){
			return "unauthorized";
		}
		Book book=new Book();
		model.addAttribute(book);
		return "BookAddForm";
	}
	
	@RequestMapping(value="/save-book")
	private String saveBook(@ModelAttribute Book book){
		Subject subject=SecurityUtils.getSubject();
		if(!subject.isPermitted("/save-book")){
			return "unauthorized";
		}
		bookService.addBook(book);
		return "redirect:/list-books";
	}

	@RequestMapping(value="/edit-book/{id}",method=RequestMethod.GET)
	private String editBook(Model model,@PathVariable int id){
		Subject subject=SecurityUtils.getSubject();
		if(!subject.isPermitted("/edit-book")){
			return "unauthorized";
		}
		Book book=bookService.getBookById(id);
		model.addAttribute(book);
		return "BookEditForm";
	}

	@RequestMapping(value="/update-book")
	private String updateBook(Book book){
		Subject subject=SecurityUtils.getSubject();
		if(!subject.isPermitted("/update-book")){
			return "unauthorized";
		}
		bookService.updateBook(book);
		return "redirect:/list-books";
	}

	@RequestMapping(value="/delete-book/{id}",method=RequestMethod.GET)
	private String deleteBook(@PathVariable int id){
		Subject subject=SecurityUtils.getSubject();
		if(!subject.isPermitted("/delete-book")){
			return "unauthorized";
		}
		bookService.deleteBook(id);
		return "redirect:/list-books";
	}
}
