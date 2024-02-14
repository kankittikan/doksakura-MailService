package com.doksakura.service;

import com.doksakura.model.EmailMessage;
import com.doksakura.model.RespondMessage;
import com.doksakura.model.RespondStatus;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class Parser {
    public RespondMessage parse(String raw) {
        if(raw.startsWith("EMAIL")) {
            raw = raw.replaceFirst("EMAIL ", "");
            try {
                EmailMessage emailMessage = new Gson().fromJson(raw, EmailMessage.class);
                SendEmail.send(emailMessage);
            }
            catch (JsonSyntaxException e) {
                return new RespondMessage(RespondStatus.FAILED, "MALFORMED JSON");
            } catch (MessagingException | UnsupportedEncodingException e) {
                return new RespondMessage(RespondStatus.FAILED, "MAIL SERVICE FAILED");
            }


            return new RespondMessage(RespondStatus.OK, "EMAIL SENT");
        }

        return new RespondMessage(RespondStatus.FAILED, "REQUEST NOT ALLOW");
    }
}