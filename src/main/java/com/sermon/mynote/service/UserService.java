
package com.sermon.mynote.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sermon.mynote.domain.User;

public interface UserService{

	public List<User> findAll();
	
	public User findById(Integer id);
	
	public User save(User user);
	
	
	public void createUser(String username,String useremail,String userpassword);
	

	public int updateUserPassword(Integer userId,String password);
	
	public Page<User> findAllByPage(Pageable pageable);	
	
    public Integer validateUser(String username,String password);

	public Integer checkUserNameAvailability(String username);

	public int checkUserEmailAvailability(String useremail);
	
}
