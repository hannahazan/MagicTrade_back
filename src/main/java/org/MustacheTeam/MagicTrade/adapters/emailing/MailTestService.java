package org.MustacheTeam.MagicTrade.adapters.emailing;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailTestService {
    private final JavaMailSender mailSender;

    public MailTestService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendTest(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("hannahazan@hotmail.fr");
        message.setSubject("Test MagicTrade");
        message.setText("Ça fonctionne");

        mailSender.send(message);
    }
}
