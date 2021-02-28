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
import com.mossonthetree.gid.view.CollaboratorView;
import com.mossonthetree.gid.service.CollaboratorService;

@RequestMapping(value = "/api/collaborators")
@Controller
public class CollaboratorController {
	@Autowired
	private CollaboratorService service;

	@RequestMapping(value = "{userId}/{itemId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable int userId, @PathVariable int itemId) {
		boolean result = service.delete(userId, itemId);
		if (!result) {
			return ResponseEntity.status(400).body("Could not delete Collaborator");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody CollaboratorView newCollaborator) { 
		CollaboratorView result = service.insert(newCollaborator);
		if (result == null) {
			return ResponseEntity.status(400).body("Could not create new Collaborator");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "{itemId}", method = RequestMethod.GET)
	public ResponseEntity<?> getItemCollaborators(@PathVariable int itemId) { 
		List<UserView> result = service.selectItemCollaborators(itemId);
		if (result.size() == 0) {
			return ResponseEntity.status(404).body("No results");
		}
		return ResponseEntity.ok(result);
	}

}
