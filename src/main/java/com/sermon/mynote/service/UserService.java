
package com.sermon.mynote.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sermon.mynote.domain.User;

public interface UserService{

	public List<User> findAll();
	
	public User findById(Long id);
	
	public User save(User user);
	
	public Page<User> findAllByPage(Pageable pageable);	
	
}
