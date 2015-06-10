
package com.sermon.mynote.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sermon.mynote.domain.User;
import com.sermon.mynote.repository.UserRepository;
import com.sermon.mynote.service.UserService;


@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly=true)
	public List<User> findAll() {
		return Lists.newArrayList(userRepository.findAll());
	}

	@Transactional(readOnly=true)
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	@Transactional(readOnly=true)
	public Page<User> findAllByPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}	
	
}
