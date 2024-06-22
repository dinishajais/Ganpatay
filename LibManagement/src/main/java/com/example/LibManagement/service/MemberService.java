package com.example.LibManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.LibManagement.model.Member;
import com.example.LibManagement.repository.Memberrepo;

@Service
public class MemberService {

	@Autowired
	Memberrepo memberrepo;

	@ResponseStatus(HttpStatus.ACCEPTED)
	public Member save(Member member) {
		return memberrepo.save(member);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	public Member update(Long id, String name, String email) {
		Member found = memberrepo.findById(id).get();
		if (name != null) {
			found.setName(name);
			save(found);
			return found;
		}
		if (email != null) {
			found.setEmail(email);
			save(found);
			return found;
		}
		return found;
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Member> findAll() {

		return memberrepo.findAll();
	}
	public String delete(Long id) {
		if(memberrepo.findById(id).isPresent()) {
		memberrepo.deleteById(id);
		return "as u say my lord, Its deleted";
		}
		else {
			return "sorry my lord, this id ain't present";
		}
	}

}
