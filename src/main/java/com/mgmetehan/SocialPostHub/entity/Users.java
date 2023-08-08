package com.mgmetehan.SocialPostHub.entity;

import com.mgmetehan.SocialPostHub.core.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserVote> userVotes;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostComment> postComments;

    @Override
    public <T extends BaseEntity> void update(T entity) {
        var users = (Users) entity;

        if (Objects.nonNull(users.getFirstName())) {
            firstName = users.getFirstName();
        }
        if (Objects.nonNull(users.getLastName())) {
            lastName = users.getLastName();
        }
        if (Objects.nonNull(users.getEmail())) {
            email = users.getEmail();
        }
    }
}
