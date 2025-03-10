package com.example.c_mail.service;

import com.example.c_mail.common.constant.VariableConstant;
import com.example.c_mail.model.MailModel;
import com.example.c_mail.model.ResponseModel;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${spring.mail.from}")
    private String mailFrom;

    @Value("${spring.mail.to}")
    private String mailTo;

    private final JavaMailSender javaMailSender;

    public ResponseModel sendMail(MailModel mailModel){
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(mailFrom, mailModel.getMail());
            helper.setTo(mailTo);
            helper.setSubject(mailModel.getMail());
            helper.setText(mailModel.getMessage(), true);

            javaMailSender.send(message);
            return ResponseModel.builder().status(VariableConstant.SUCCESS).message(VariableConstant.SEND_MAIL_SUCCESS).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
