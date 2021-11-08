package com.example.serviceIMPL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	UserRepository ur;

	@Override
	public void registerdata(User u) {
		try {
			ur.save(u);
		}
		catch(IllegalArgumentException i)
		{
			System.out.println(i.getMessage());
		}
		
	}

	@Override
	public List<User> fetchdata(String username, String passord) {
		if(username.equals("admin") && passord.equals("admin"))
		{
			List<User> list=(List<User>)ur.findAll();
			return list;
		}
		else
		{
			List<User> list=ur.findByUsernameAndPassordAndStatus(username, passord,false);
			return list;
		}
		
		
	}

	@Override
	public User editdata(int userid) {
		User l=ur.findAllByUserid(userid);
		return l;
	}

	@Override
	public List<User> updatedata(User u) {
		List<User> l=new ArrayList<>();
		User u1=ur.save(u);
		User u2=ur.findAllByUserid(u.getUserid());
		l.add(u2);
		return l;
	}

	@Override
	public void deletedata(int userid) {
		if(ur.existsByuserid(userid))
		{
			User u=editdata(userid);
			u.setStatus(true);
			updatedata(u);
		}
		
	}

	@Override
	public void harddeletedata(int userid) {
		ur.deleteAllByuserid(userid);
		
	}

	@Override
	public List<User> getDob() {
		List<User> list=ur.findAll();
		Comparator<User> comp=(c1,c2)->{
		return c1.getDOB().compareTo(c2.getDOB());};
		Collections.sort(list,comp);
		return list;
	}

	@Override
	public List<User> getJoiningDate() {
		List<User> list=ur.findAll();
		Comparator<User> comp1=(c3,c4)->{
		return c3.getJoiningDate().compareTo(c4.getJoiningDate());};
		Collections.sort(list,comp1);
		return list;
	}
	
	

}
