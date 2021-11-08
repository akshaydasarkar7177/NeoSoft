package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


	public User findAllByUserid(int userid);

	public boolean existsByuserid(int userid);

	public List<User> findByUsernameAndPassordAndStatus(String username, String passord, boolean b);

	public void deleteAllByuserid(int userid);
}
