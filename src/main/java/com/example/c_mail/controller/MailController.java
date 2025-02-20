package com.example.c_mail.controller;

import com.example.c_mail.model.MailModel;
import com.example.c_mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMail(@RequestParam("fullName") String fullName,
                                      @RequestParam("mail") String mail,
                                      @RequestParam("message") String message) {

        MailModel mailModel = MailModel.builder().fullName(fullName).mail(mail).message(message).build();
        return ResponseEntity.ok(mailService.sendMail(mailModel));
    }
}
