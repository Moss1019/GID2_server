package com.mossonthetree.gid.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.mossonthetree.gid.view.MilestoneView;
import com.mossonthetree.gid.service.MilestoneService;

@RequestMapping(value = "/api/milestones")
@Controller
public class MilestoneController {
	@Autowired
	private MilestoneService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> selectAll() {
		List<MilestoneView> result = service.selectAll();
		if (result.size() == 0) {
			return ResponseEntity.status(404).body("No results");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "{value}", method = RequestMethod.GET)
	public ResponseEntity<?> getByPk(@PathVariable int value) {
		MilestoneView result = service.selectByPk(value);
		if (result == null) {
			return ResponseEntity.status(404).body("Could not find Milestone");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody MilestoneView updatedMilestone) { 
		boolean result = service.update(updatedMilestone);
		if (!result) {
			return ResponseEntity.status(400).body("Could not update Milestone");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable int id) {
		boolean result = service.delete(id);
		if (!result) {
			return ResponseEntity.status(400).body("Could not delete Milestone");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody MilestoneView newMilestone) { 
		MilestoneView result = service.insert(newMilestone);
		if (result == null) {
			return ResponseEntity.status(400).body("Could not create new Milestone");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "forItem/{itemId}", method = RequestMethod.GET)
	public ResponseEntity<?> getOfItem(@PathVariable int itemId) { 
		List<MilestoneView> result = service.selectOfItem(itemId);
		if (result.size() == 0) {
			return ResponseEntity.status(404).body("No results");
		}
		return ResponseEntity.ok(result);
	}

}
