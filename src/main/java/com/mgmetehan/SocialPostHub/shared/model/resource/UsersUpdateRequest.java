package com.mgmetehan.SocialPostHub.shared.model.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsersUpdateRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
