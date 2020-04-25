package com.cissco.cmad_prac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	@RequestMapping(path="/add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<UserDetails> addUser(@RequestBody UserDetails userdetails){
		repo.save(userdetails);
		return new ResponseEntity<UserDetails>(userdetails, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<UserDetails>> getAllUsers(){
		List<UserDetails> allusers = repo.findAll();
		return new ResponseEntity<List<UserDetails>>(allusers,HttpStatus.OK);
	}
	@RequestMapping(path="/userbyname",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<UserDetails> searchUserByName(@RequestParam(name="usname") String usname){
		UserDetails usr = repo.findByUsname(usname);
		return new ResponseEntity<UserDetails>(usr,HttpStatus.OK);
	}
	@RequestMapping(path="/{uid}",produces="application/json")
	public ResponseEntity<UserDetails> searchUserById(@PathVariable("uid") String uid){
		UserDetails usr = repo.findByUid(uid);
		return new ResponseEntity<UserDetails>(usr,HttpStatus.OK);
	}
	@RequestMapping(path="/userbyloc",method=RequestMethod.GET,produces="applicatio/json")
	public ResponseEntity<List<UserDetails>> searchUserByLocation(@RequestParam(name="usaddress") String usaddress){
		List<UserDetails> usr = repo.findByUsaddress(usaddress);
		return new ResponseEntity<List<UserDetails>>(usr, HttpStatus.OK);
	}
	
	@RequestMapping(path="/userbylocortitle",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<UserDetails>> getUserByLocationOrTitle(@RequestParam(name="usaddress") String usaddress,@RequestParam(name="usrtitle") String usrtitle){
		List<UserDetails> usr = repo.findByUsaddressOrUsrtitle(usaddress, usrtitle);
		return new ResponseEntity<List<UserDetails>>(usr, HttpStatus.OK);
	}
	@RequestMapping(path="/userbylocandtitle",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<UserDetails>> getUserByLocationAndTitle(@RequestParam(name="location") String location,@RequestParam(name="title") String title){
		List<UserDetails> usr= repo.findByUsaddressAndUsrtitle(location, title);
		return new ResponseEntity<List<UserDetails>>(usr, HttpStatus.OK);
	}
    public void delUser(){
		
	}
	public void updateUser(){
		
	}
	//use a multipart form data to upload file to server .zip etc
	public void uploadData(){
		//important one 
	}
}
