package com.mgmetehan.SocialPostHub.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TagType {
    UPVOTE(1L, 1L),
    DOWNVOTE(2L, 2L),
    UNVOTE(3L, 3L);

    private final Long databaseId;
    private final Long displayId;

    public static TagType fromDatabaseId(Long id) {
        for (TagType value : TagType.values()) {
            if (value.databaseId.equals(id)) {
                return value;
            }
        }

        //throw new GeneralException(ErrorStatusCode.UNSUPPORTED_VOTE_STATUS);
        return null;
    }

    public static TagType fromDisplayId(Long id) {
        for (TagType value : TagType.values()) {
            if (value.displayId.equals(id)) {
                return value;
            }
        }

        //throw new GeneralException(ErrorStatusCode.UNSUPPORTED_VOTE_STATUS);
        return null;
    }
}
