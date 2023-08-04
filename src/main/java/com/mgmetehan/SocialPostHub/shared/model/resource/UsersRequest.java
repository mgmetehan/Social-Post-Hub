package com.mgmetehan.SocialPostHub.shared.model.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsersRequest {
    private String firstName;
    private String lastName;
    private String email;

}
