package com.BookKeeperApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RdDvls on 5/23/17.
 */
@Controller
public class BookKeeperController {

	@Autowired
	UserRepository users;

	@Autowired
	BookItemRepository books;

	@Autowired
	AuthorRepository authors;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session){
		if (session.getAttribute("user") != null){
			model.addAttribute("user",session.getAttribute("user"));
		}
		User savedUser = (User)session.getAttribute("user");
		List<BookItem> bookList = new ArrayList<>();
		if (savedUser != null){
			bookList = books.findBooksByUser(savedUser);
		}
		model.addAttribute("books", bookList);
		return "home";
	}

	@RequestMapping(path = "/newUser", method = RequestMethod.POST)
	public String newUser(HttpSession session,String firstName, String lastName, String userName, String password) throws Exception{
		User newUser = users.findFirstByUserName(userName);
		if (newUser == null){
			newUser = new User(firstName,lastName,userName,password);
			users.save(newUser);
		}
		System.out.println("Adding new user{\nFirst Name: " + newUser.firstName + "\nLast Name: " + newUser.lastName + "\nUsername: " + newUser.userName + "\n}");
		session.setAttribute("user", newUser);
		return "redirect:/";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, String userName, String password) throws Exception{
		User user = users.findFirstByUserName(userName);
		if (user == null){
			throw new Exception("No user found. Please create an user.");
		} else if (!password.equals(user.getPassword())){
			throw new Exception("Invalid password");
		}
		session.setAttribute("user", user);
		return "redirect:/";
	}

}
