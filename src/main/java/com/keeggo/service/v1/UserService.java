package com.keeggo.service.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keeggo.exception.v1.ResourceNotFoundException;
import com.keeggo.model.v1.User;
import com.keeggo.repository.v1.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;

	public User create(User User) {
		return repository.save(User);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public User update(User user) {
		User entity = repository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setEmail(user.getEmail());		

		return repository.save(entity);
	}

	public void delete(Long id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

	public User getByEmail(String email) {
		return null;
	}
}
