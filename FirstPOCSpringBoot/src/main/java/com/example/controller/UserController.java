package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService us;
	
	@GetMapping
	@RequestMapping("/prelogin")
	public User PreLogin()
	{
		User u=new User();
		u.setUserid(1);
		u.setName("Manoj");
		u.setAddress("ahemadnagar");
		u.setPinocode(444303);
		u.setPancard("BPBPD1234S");
		u.setUsername("manoj");
		u.setPassord("manoj");
		u.setDOB("12/12/2012");
		u.setJoiningDate("1/1/2020");
		u.setStatus(false);
		return u;
		
	}
	
	@PostMapping
	@RequestMapping("/registerdata")
	public void registerdata(@RequestBody User u)
	{
		us.registerdata(u);
	}
	
	@GetMapping
	@RequestMapping("/Fetchdata/{username}/{passord}")
	public List<User> fetchdata(@PathVariable ("username") String username,@PathVariable("passord") String passord)
	{
		List<User> l=us.fetchdata(username,passord);
		return l;
	}
	
	@PostMapping
	@RequestMapping("/editdata/{userid}")
	public User editdata(@PathVariable("userid")int userid)
	{
		User l=(User) us.editdata(userid);
		return l;
		
	}
	
    @PutMapping
    @RequestMapping("/updatedata")
    public List<User> updatedata(@RequestBody User u)
    {
    	List<User> l=us.updatedata(u);
		return l;
    	
    }
    @DeleteMapping
    @RequestMapping("/delete/{userid}")
     public void deletedata(@PathVariable("userid") int userid)
     {
    	us.deletedata(userid);
     }
    
    @DeleteMapping
    @RequestMapping("/harddelete/{userid}")
     public void harddeletedata(@PathVariable("userid") int userid)
     {
    	us.harddeletedata(userid);
     }
    @GetMapping
    @RequestMapping("/sordbydob")
    public List<User> getDob()
    {
    	List<User> list=us.getDob();
    	return list;
    }
    
    @GetMapping
    @RequestMapping("/sordbyjoiningdate")
    public List<User> getJoiningDate()
    {
    	List<User> list=us.getJoiningDate();
    	return list;
    }
    
}
