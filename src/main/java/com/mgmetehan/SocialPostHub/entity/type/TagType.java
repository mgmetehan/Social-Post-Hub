package com.mgmetehan.SocialPostHub.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TagType {

    FINANCE(1L, 1L),
    HEALTH(2L, 2L),
    EDUCATION(3L, 3L),
    TECHNOLOGY(4L, 4L);

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
