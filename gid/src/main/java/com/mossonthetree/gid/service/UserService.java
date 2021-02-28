package com.mossonthetree.gid.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mossonthetree.gid.model.User;
import com.mossonthetree.gid.view.UserView;
import com.mossonthetree.gid.repository.UserRepository;
import com.mossonthetree.gid.mapper.UserMapper;
import com.mossonthetree.gid.view.ItemView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private ItemService itemService;

	public UserView insert(UserView newUser) { 
		User dbResult = repo.insert(UserMapper.mapUserView(newUser));
		List<ItemView> itemViews = itemService.selectOfUser(dbResult.getUserId());
		UserView result = UserMapper.mapUser(dbResult, itemViews);
		return result;
	}

	public boolean delete(int id) {
		boolean result = repo.delete(id);
		return result;
	}

	public UserView selectByPk(int value) {
		User dbResult = repo.selectByPk(value);
		List<ItemView> items = itemService.selectOfUser(dbResult.getUserId());
		UserView result = UserMapper.mapUser(dbResult, items);
		return result;
	}

	public List<UserView> selectAll() {
		List<User> dbResult = repo.selectAll();
		List<UserView> result = dbResult
			.stream()
			.map(x -> {
				List<ItemView> itemViews = itemService.selectOfUser(x.getUserId());
				return UserMapper.mapUser(x, itemViews);
			})
			.collect(Collectors.toList());
		return result;
	}

	public UserView selectByEmail(String value) {
		User dbResult = repo.selectByEmail(value);
		List<ItemView> items = itemService.selectOfUser(dbResult.getUserId());
		UserView result = UserMapper.mapUser(dbResult, items);
		return result;
	}


	public boolean update(UserView updatedUser) { 
		boolean result = repo.update(UserMapper.mapUserView(updatedUser));
		return result;
	}

}
