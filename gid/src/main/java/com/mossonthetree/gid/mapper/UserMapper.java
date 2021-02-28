package com.mossonthetree.gid.mapper;

import com.mossonthetree.gid.model.User;
import com.mossonthetree.gid.view.UserView;

import com.mossonthetree.gid.view.ItemView;

import java.util.List;

public class UserMapper {
	public static UserView mapUser(User user, List<ItemView> items) {
		return new UserView(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), items);
	}

	public static User mapUserView(UserView userView) {
		User user = new User();
		user.setUserId(userView.getUserId());
		user.setFirstName(userView.getFirstName());
		user.setLastName(userView.getLastName());
		user.setEmail(userView.getEmail());
		return user;
	}
}
