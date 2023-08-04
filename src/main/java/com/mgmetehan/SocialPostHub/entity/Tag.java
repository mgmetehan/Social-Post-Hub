package com.mgmetehan.SocialPostHub.entity;

import com.mgmetehan.SocialPostHub.core.entity.BaseEntity;
import com.mgmetehan.SocialPostHub.entity.type.TagType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TagType tagType;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostTag> postTags;

    @Override
    public <T extends BaseEntity> void update(T entity) {

    }
}
