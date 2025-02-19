package com.example.c_mail.service;

import com.example.c_mail.common.constant.VariableConstant;
import com.example.c_mail.model.MailModel;
import com.example.c_mail.model.ResponseModel;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public ResponseModel sendMail(MailModel mailModel){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("form@gmail.com", mailModel.getMail());
            helper.setTo("to@gmail.com");
            helper.setSubject(mailModel.getMail());
            helper.setText(mailModel.getMessage(), true);

            javaMailSender.send(message);
            return ResponseModel.builder().status(VariableConstant.SUCCESS).message(VariableConstant.SEND_MAIL_SUCCESS).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
