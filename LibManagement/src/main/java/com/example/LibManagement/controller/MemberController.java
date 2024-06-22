package com.example.LibManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibManagement.model.Member;
import com.example.LibManagement.service.MemberService;

@RestController
@RequestMapping("/mem")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/save")
	public Member save(@RequestBody Member member) {
		return memberService.save(member);
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	@PutMapping("/{id}")
	public Member update(@PathVariable Long id, @RequestBody Map<String,String>  update) {
		String name="",email="";
		 name=update.get("name");
		 email=update.get("email");
		return memberService.update(id,name,email);
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/all")
	public List<Member> findAll() {
		return memberService.findAll();
	}
	@DeleteMapping("/{id}")
	public String  delete(@PathVariable Long id) {
		return memberService.delete(id);
	}
	
}
