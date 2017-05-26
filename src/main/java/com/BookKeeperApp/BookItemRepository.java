package com.BookKeeperApp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by RdDvls on 5/23/17.
 */
public interface BookItemRepository extends CrudRepository<BookItem, Integer> {
	List<BookItem> findBooksByUser(User user);
}
