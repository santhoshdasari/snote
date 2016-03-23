package com.sermon.mynote.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

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

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return Lists.newArrayList(userRepository.findAll());
	}

	@Transactional(readOnly = true)
	public User findById(Integer id) {
		return userRepository.findOne(id.intValue());
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void createUser(String username, String useremail,
			String userpassword) {
		/*
		 * List result = em .createNamedQuery("add_user")
		 * .setParameter("username", username) .setParameter("useremail",
		 * useremail) .setParameter("userpassword", userpassword)
		 * .getResultList();
		 */

		StoredProcedureQuery proc = em
				.createNamedStoredProcedureQuery("User.add_user");

		proc.setParameter("username", username)
				.setParameter("useremail", useremail)
				.setParameter("userpassword", userpassword);
		proc.execute();

	}

	public int updateUserPassword(Integer userId, String newPassword) {

		StoredProcedureQuery proc = em
				.createNamedStoredProcedureQuery("User.update_userpassword");

		proc.setParameter("userId", userId)
				.setParameter("userPwd", newPassword);

		int result = proc.executeUpdate();
		return result;

	}

	@Transactional(readOnly = true)
	public Page<User> findAllByPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Integer validateUser(String username, String password) {

		try {
			Query query = em
					.createNativeQuery(
							"select userid returnvalue from user where username=:username and userpassword= encrypt(:password ,'snote')")
					.setParameter("username", username)
					.setParameter("password", password);
			System.out.println(query);
			query.setParameter("username", username);

			if (query.getSingleResult() != null) {
				return (Integer) query.getSingleResult();
			}
		} catch (NoResultException e) {

		}
		return 0;

		/*
		 * Integer val = (Integer) query.getSingleResult(); if(val==null){
		 * return 0; } return val;
		 */
	}

	@Transactional(readOnly = true)
	public Integer checkUserNameAvailability(String username) {

		try {
			Query query = em
					.createNativeQuery(
							"select userid returnvalue from user where username=:username")
					.setParameter("username", username);
			System.out.println(query);
			query.setParameter("username", username);

			if (query.getSingleResult() != null) {
				return (Integer) query.getSingleResult();
			}
		} catch (NoResultException e) {

		}
		return 0;

	}

	@Transactional(readOnly = true)
	public int checkUserEmailAvailability(String useremail) {
		
		try {
			Query query = em
					.createNativeQuery(
							"select userid returnvalue from user where useremail=:useremail")
					.setParameter("useremail", useremail);
			System.out.println(query);
			query.setParameter("useremail", useremail);

			if (query.getSingleResult() != null) {
				return (Integer) query.getSingleResult();
			}
		} catch (NoResultException e) {

		}
		return 0;

	}

}
