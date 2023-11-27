package com.module.crimelens.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private String message;
    private Boolean success;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
