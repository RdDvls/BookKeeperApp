package com.BookKeeperApp;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RdDvls on 5/31/17.
 */
@RestController
public class BookKeeperRestController {
	@Autowired
	BookItemRepository books;

	@Autowired
	AuthorRepository authors;

	@Autowired
	UserRepository users;

	@RequestMapping(path = "/getAllBooks.json", method = RequestMethod.GET)
	public List<BookItem> getAllBooks(Model model, HttpSession session){
		if (session.getAttribute("user") != null){
			model.addAttribute("user",session.getAttribute("user"));
		}
		User savedUser = (User)session.getAttribute("user");
		ArrayList<BookItem> bookItemList = new ArrayList<>();
		Iterable<BookItem> allBooks = books.findBooksByUser(savedUser);
		for (BookItem book : allBooks){
			bookItemList.add(book);
		}
		return bookItemList;
	}

	@RequestMapping(path = "/addBook.json",method = RequestMethod.POST)
	public List<BookItem> addBook(Model model,HttpSession session, @RequestBody Author author, @RequestBody BookItem bookItem)throws Exception{
		User user = (User)session.getAttribute("user");
		if (user == null){
			throw new Exception("You must sign in first");
		}
		bookItem.user = user;
		books.save(bookItem);
		return getAllBooks(model,session);
	}
}
