package com.mossonthetree.gid.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.mossonthetree.gid.view.UserView;
import com.mossonthetree.gid.service.UserService;

@RequestMapping(value = "/api/users")
@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> selectAll() {
		List<UserView> result = service.selectAll();
		if (result.size() == 0) {
			return ResponseEntity.status(404).body("No results");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "{value}", method = RequestMethod.GET)
	public ResponseEntity<?> getByPk(@PathVariable int value) {
		UserView result = service.selectByPk(value);
		if (result == null) {
			return ResponseEntity.status(404).body("Could not find User");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "byEmail/{email}", method = RequestMethod.GET)
	public ResponseEntity<?> selectByEmail(@PathVariable String email) {
		UserView result = service.selectByEmail(email);
		if (result == null) {
			return ResponseEntity.status(404).body("Could not findUser");
		}
		return ResponseEntity.ok(result);
	}


	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody UserView updatedUser) { 
		boolean result = service.update(updatedUser);
		if (!result) {
			return ResponseEntity.status(400).body("Could not update User");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable int id) {
		boolean result = service.delete(id);
		if (!result) {
			return ResponseEntity.status(400).body("Could not delete User");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody UserView newUser) { 
		UserView result = service.insert(newUser);
		if (result == null) {
			return ResponseEntity.status(400).body("Could not create new User");
		}
		return ResponseEntity.ok(result);
	}

}
