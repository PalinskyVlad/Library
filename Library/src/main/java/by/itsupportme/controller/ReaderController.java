package by.itsupportme.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itsupportme.entity.Reader;
import by.itsupportme.service.BookService;
import by.itsupportme.service.TemporaryPossessionService;
import by.itsupportme.service.UserService;

@Controller
@RequestMapping("/reader")
public class ReaderController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TemporaryPossessionService temporaryPossessionService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(Model model, Principal principal) {
		Reader reader = (Reader) userService.findUserByLogin(principal.getName());
		model.addAttribute("books", bookService.getAllBooksOfReader(reader));
		return "reader/books";
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String getHistory(Model model, Principal principal) {
		model.addAttribute("temporaryPossessions", temporaryPossessionService.getAllTemporaryPossessionsOfReader(principal.getName()));
		return "reader/history";
	}

}
