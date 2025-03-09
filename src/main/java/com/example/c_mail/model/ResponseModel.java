package com.example.c_mail.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ResponseModel {
    private String message;
    private String status;
}
