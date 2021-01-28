//package com.studensJournal.utils.email;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import javax.mail.internet.MimeMessage;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.stream.Stream;
//
//import static java.util.stream.Collectors.toList;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class EmailSender {
//
//    private static final String CONFIRM_LOGIN = "Nomad | Restore password";
//    private static final String CONFIRM_REGISTER = "Nomad | Registration success";
//
//
//    private final ExecutorService executorService = Executors.newCachedThreadPool();
//    private final JavaMailSender mailSender;
//
//
//    private void send(String toEmail, String subject, String emailMessage) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setText(emailMessage);
//        message.setSubject(subject);
//        message.setTo(toEmail);
//        message.setFrom("info.ciclex@gmail.com");
//        mailSender.send(message);
//    }
//
//    public void sendEmailToAddress(List<String> emails, String subject, String message) {
//        executorService.submit(() -> emails.forEach(email -> send(email, subject, message)));
//        log.info("Email send to - " + emails);
//    }
//
//    public void sendEmailOnLoginConfirm(String email, String code) {
//        sendEmailToAddress(Stream.of(email).collect(toList()), CONFIRM_LOGIN, String.format(
//                        "You code :\n" +
//                        "%s\n" +
//                        "Thank you for using our service!",code
//        ));
//    }
//
//    public void sendEmailToAddressHtmlMessage(List<String> emails, String subject, String message) {
//        executorService.submit(() -> emails.forEach(email -> sendHtml(email, subject, message)));
//
//    }
//
//    @SneakyThrows
//    private void sendHtml(String toEmail, String subject, String emailMessage){
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//        mimeMessage.setContent(emailMessage, "text/html");
//        helper.setText(emailMessage, true);
//        helper.setTo(toEmail);
//        helper.setSubject(subject);
//        helper.setFrom("ciclexexchange@gmail.com");
//        mailSender.send(mimeMessage);
//    }
//
//    public void sendEmailOnRestorePasswordConfirm(String email, String code) {
//        sendEmailToAddressHtmlMessage(Stream.of(email).collect(toList()), CONFIRM_LOGIN, HtmlEmailPattern.getRestorePasswordLetter(code, email));
//    }
//
//    public void sendEmailOnRegister(String email) {
//        sendEmailToAddressHtmlMessage(Stream.of(email).collect(toList()), CONFIRM_REGISTER, HtmlEmailPattern.getRegisterLetter(email));
//    }
//
//    //@PostConstruct
//    public void testEmail() {
//        sendEmailToAddressHtmlMessage(Stream.of("---").collect(toList()), CONFIRM_REGISTER, HtmlEmailPattern.getRegisterLetter("---"));
//    }
//
//}
