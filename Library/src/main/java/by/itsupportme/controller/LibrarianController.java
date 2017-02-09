package by.itsupportme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itsupportme.service.BookService;
import by.itsupportme.service.TemporaryPossessionService;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private TemporaryPossessionService temporaryPossessionService;
	
	@RequestMapping(value = "/booksInLibrary", method = RequestMethod.GET)
	public String getBooksInLibraryPage(Model model) {
		model.addAttribute("books", bookService.getAllBooksInLibrary());
		return "librarian/booksInLibrary";
	}
	
	@RequestMapping(value = "/booksIssuedOnHands", method = RequestMethod.GET)
	public String getBooksIsNotInLibraryPage(Model model) {
		model.addAttribute("books", bookService.getBooksIssuedOnHands());
		return "librarian/booksIssuedOnHands";
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String getHistory(Model model) {
		model.addAttribute("temporaryPossessions", temporaryPossessionService.getAllTemporaryPossessions());
		return "librarian/history";
	}
	
	@RequestMapping(value = "/giveABook", method = RequestMethod.POST)
	public String giveABook(String readerLogin, long bookId) {
		if (temporaryPossessionService.createTemporaryPossession(readerLogin, bookId)) {
			return "redirect:/";
		}
		return "redirect:/error";
	}
	
	@RequestMapping(value = "/takeABook", method = RequestMethod.POST)
	public String takeABook(long bookId) {
		if (temporaryPossessionService.editTemporaryPossession(bookId)) {
			return "redirect:/";
		}
		return "redirect:/error";
	}

}
