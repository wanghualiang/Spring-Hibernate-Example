package com.lenovo.leoss.service;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Map;

/**
 * Created by zhangyl27 on 2014/10/14.
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    public void sendMail(String from,
                         String to,
                         String subject,
                         String templateFilePath,
                         Map model){
        String content = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, templateFilePath, "utf-8", model);
        sendMail(from, to, subject, content);
    }

    public void sendMail(final String from,
                         final String to,
                         final String subject,
                         final String content){
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage msg) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(msg);
                helper.setTo(to);
                helper.setFrom(from);
                helper.setSubject(subject);
                helper.setText(content, true);
                helper.setSentDate(new Date());
            }
        };
        mailSender.send(preparator);
    }

}
