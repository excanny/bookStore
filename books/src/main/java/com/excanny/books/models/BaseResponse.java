package com.excanny.books.models;

import lombok.Data;

@Data
public class BaseResponse {
    private Boolean status;
    private String message;
}
