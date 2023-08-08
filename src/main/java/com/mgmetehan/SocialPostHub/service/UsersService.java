package com.mgmetehan.SocialPostHub.service;

import com.mgmetehan.SocialPostHub.shared.model.resource.UsersRequest;
import com.mgmetehan.SocialPostHub.shared.model.resource.UsersUpdateRequest;
import com.mgmetehan.SocialPostHub.shared.model.response.UsersResponse;

import java.util.List;

public interface UsersService {
    UsersResponse create(UsersRequest newUsers);

    UsersResponse getById(String id);

    List<UsersResponse> getAll();

    UsersResponse delete(String id);

    UsersResponse update(UsersUpdateRequest updateUsers);

    List<String> getAllFirstNames();

    List<String> getAllEmails();
}
