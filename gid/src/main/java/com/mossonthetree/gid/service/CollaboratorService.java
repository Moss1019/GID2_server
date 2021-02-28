package com.mossonthetree.gid.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mossonthetree.gid.model.User;
import com.mossonthetree.gid.model.Collaborator;
import com.mossonthetree.gid.mapper.UserMapper;
import com.mossonthetree.gid.view.UserView;
import com.mossonthetree.gid.view.CollaboratorView;
import com.mossonthetree.gid.repository.CollaboratorRepository;
import com.mossonthetree.gid.mapper.CollaboratorMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollaboratorService {
	@Autowired
	private CollaboratorRepository repo;
	@Autowired
	private UserService userService;

	public CollaboratorView insert(CollaboratorView newCollaborator) { 
		Collaborator dbResult = repo.insert(CollaboratorMapper.mapCollaboratorView(newCollaborator));
		CollaboratorView result = CollaboratorMapper.mapCollaborator(dbResult);
		return result;
	}

	public List<UserView> selectItemCollaborators(int itemId) {
		List<User> dbResult = repo.selectItemCollaborators(itemId);
		List<UserView> result = dbResult.stream()
			.map(x -> {
				return UserMapper.mapUser(x, null);
			})
			.collect(Collectors.toList());
		return result;
	}

	public boolean delete(int userId ,int itemId) {
		boolean result = repo.delete(userId ,itemId);
		return result;
	}

}
