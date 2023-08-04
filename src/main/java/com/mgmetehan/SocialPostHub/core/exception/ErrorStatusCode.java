package com.mgmetehan.SocialPostHub.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorStatusCode {

    NOT_FOUND(404, "Not Found", false, HttpStatus.NOT_FOUND);


    private final int value;
    private final String description;
    private final boolean isRepeatable;
    private final HttpStatus httpStatus;

    public static ErrorStatusCode getByValue(int value) {
        for (ErrorStatusCode status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + value);
    }
}
