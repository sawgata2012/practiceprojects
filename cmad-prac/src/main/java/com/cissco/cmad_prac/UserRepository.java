package com.cissco.cmad_prac;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserDetails, String>{
	public UserDetails findByUsname(String usname);
	public UserDetails findByUid(String uid);
	public List<UserDetails> findByUsaddress(String usaddress);
	public List<UserDetails> findByUsaddressOrUsrtitle(String usaddress,String usrtitle);
	public List<UserDetails> findByUsaddressAndUsrtitle(String usaddress,String usrtitle);
}