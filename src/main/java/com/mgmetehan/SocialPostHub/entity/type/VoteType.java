package com.mgmetehan.SocialPostHub.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum VoteType {
    UPVOTE(1L, 1L),
    DOWNVOTE(2L, 2L),
    UNVOTE(3L, 3L);

    private final Long databaseId;
    private final Long displayId;

    public static VoteType fromDatabaseId(Long id) {
        for (VoteType value : VoteType.values()) {
            if (value.databaseId.equals(id)) {
                return value;
            }
        }

        //throw new GeneralException(ErrorStatusCode.UNSUPPORTED_VOTE_STATUS);
        return null;
    }

    public static VoteType fromDisplayId(Long id) {
        for (VoteType value : VoteType.values()) {
            if (value.displayId.equals(id)) {
                return value;
            }
        }

        //throw new GeneralException(ErrorStatusCode.UNSUPPORTED_VOTE_STATUS);
        return null;
    }
}
