package by.itsupportme.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.itsupportme.entity.Role;
import by.itsupportme.entity.User;
import by.itsupportme.service.UserService;

@Controller
public class IndexController {

	@Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStartPage(Principal principal) {
    	if (principal == null) {
    		return "login";
    	}
    	
    	User user = userService.findUserByLogin(principal.getName());

    	if (user.getRole().getName().equals(Role.ROLE_READER_CODE)) {
    		return "redirect:/reader/books";
    	}
    	
    	if (user.getRole().getName().equals(Role.ROLE_LIBRARIAN_CODE)) {
    		return "redirect:/librarian/booksInLibrary";
    	}
    	
    	return "redirect:/login?error";	
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) String logout,
                               Model model) {
        model.addAttribute("isError", error != null);
        model.addAttribute("isLogout", logout != null);

        return "login";
    }
	
}
