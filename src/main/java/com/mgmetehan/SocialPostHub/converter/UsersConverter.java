package com.mgmetehan.SocialPostHub.converter;

import com.mgmetehan.SocialPostHub.entity.Users;
import com.mgmetehan.SocialPostHub.shared.model.resource.UsersRequest;
import com.mgmetehan.SocialPostHub.shared.model.resource.UsersUpdateRequest;
import com.mgmetehan.SocialPostHub.shared.model.response.UsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.channels.Pipe;

@Component
@RequiredArgsConstructor
public class UsersConverter {

    public Users toRequest(UsersRequest usersRequest) {
        Users users = new Users();
        users.setFirstName(usersRequest.getFirstName());
        users.setLastName(usersRequest.getLastName());
        users.setEmail(usersRequest.getEmail());
        return users;
    }

    public Users toUpdateRequest(UsersUpdateRequest usersUpdateRequest) {
        Users users = new Users();
        users.setId(usersUpdateRequest.getId());
        users.setFirstName(usersUpdateRequest.getFirstName());
        users.setLastName(usersUpdateRequest.getLastName());
        users.setEmail(usersUpdateRequest.getEmail());
        return users;
    }

    public UsersResponse toResponse(Users users) {
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setFirstName(users.getFirstName());
        usersResponse.setLastName(users.getLastName());
        usersResponse.setEmail(users.getEmail());
        return usersResponse;
    }

}
