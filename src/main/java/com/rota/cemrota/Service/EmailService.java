package com.rota.cemrota.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService {

     @Autowired
     private JavaMailSender insEnJavaMailSender;

     public void Enviar(String para,String titulo, String conteudo){
           log.info("Enviando email para confirmação");
           var messagem = new SimpleMailMessage();
           messagem.setFrom("samucafab28@gmail.com");
           messagem.setTo(para);
           messagem.setSubject(titulo);
           messagem.setText(conteudo);
           this.insEnJavaMailSender.send(messagem);
           log.info("Email enviado com sucesso");
     }

}
