package com.mgmetehan.SocialPostHub.entity;

import com.mgmetehan.SocialPostHub.core.BaseEntity;
import com.mgmetehan.SocialPostHub.entity.type.VoteType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVote extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VoteType voteType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_comment_id")
    private PostComment postComment;

    @Override
    public <T extends BaseEntity> void update(T entity) {

    }
}
