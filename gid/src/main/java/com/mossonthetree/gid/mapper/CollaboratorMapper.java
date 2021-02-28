package com.mossonthetree.gid.mapper;

import com.mossonthetree.gid.model.Collaborator;
import com.mossonthetree.gid.view.CollaboratorView;

import java.util.List;

public class CollaboratorMapper {
	public static CollaboratorView mapCollaborator(Collaborator collaborator) {
		return new CollaboratorView(collaborator.getUserId(), collaborator.getItemId());
	}

	public static Collaborator mapCollaboratorView(CollaboratorView collaboratorView) {
		Collaborator collaborator = new Collaborator();
		collaborator.setUserId(collaboratorView.getUserId());
		collaborator.setItemId(collaboratorView.getItemId());
		return collaborator;
	}
}
