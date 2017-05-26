package com.BookKeeperApp;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by RdDvls on 5/23/17.
 */
public interface UserRepository extends CrudRepository<User,Integer> {
	User findFirstByUserName(String name);
}
