package com.doksakura.service;

import com.doksakura.model.EmailMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    public static void send(EmailMessage emailMessage) throws UnsupportedEncodingException, MessagingException {

        String host = "*";
        final String user = "*";
        final String password = "*";

        String to = "kittikan.ma@ku.th";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("contact@doksakura.com", emailMessage.getPersonal()));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessage.getTo()));
        message.setSubject(emailMessage.getHeader());
        message.setContent(emailMessage.getHtml(), "text/html; charset=utf-8");

        Transport.send(message);
    }
}