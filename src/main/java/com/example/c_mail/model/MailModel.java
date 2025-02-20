package com.example.c_mail.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MailModel {
    private String fullName;
    private String mail;
    private String message;
}
