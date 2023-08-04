package com.mgmetehan.SocialPostHub.shared.model.response;

import com.mgmetehan.SocialPostHub.entity.PostComment;
import com.mgmetehan.SocialPostHub.entity.UserVote;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UsersResponse {
    private String firstName;
    private String lastName;
    private String email;
    private List<UserVote> userVotes = new ArrayList<>();
    private List<PostComment> postComments = new ArrayList<>();
}
