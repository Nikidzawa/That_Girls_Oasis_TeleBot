package ru.nikidzawa.datingapp.configs.mail;

import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import ru.nikidzawa.datingapp.store.entities.event.EventEntity;

import java.io.File;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MailSender {

    JavaMailSender javaMailSender;

    @SneakyThrows
    public void sendMessage(String mail, String imagePath, EventEntity eventEntity) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("thatgirl-oasis@mail.ru");
        helper.setTo(mail);
        helper.setSubject("Билет на мероприятие ThatGirl Oasis");
        helper.setText(
                "Вы приобрели билет на мероприятие - \"" + eventEntity.getName() +
                "\", которое начнётся " + eventEntity.getDate() + " в " + eventEntity.getTime() + " по мск" +
                "\n\nДля участия, покажите прикреплённый QR-код организатору на месте проведения мероприятия - " +
                eventEntity.getCity().getName() + ", " + eventEntity.getAddress() +
                "\n\nКонтактный номер телефона организатора мероприятия - " + eventEntity.getContactPhone() +
                "\nСтраница мероприятия - https://thatgirloasis.ru/events/" + eventEntity.getId() +
                "\n\nКоманда ThatGirl Oasis желает вам хорошо провести время!)"
        );

        FileSystemResource file = new FileSystemResource(new File(imagePath));
        helper.addAttachment("Ticket.png", file);

        javaMailSender.send(message);
    }

    public void sendTextMessage(String mail, String messageText) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("thatgirl-oasis@mail.ru");
        message.setTo(mail);
        message.setSubject("Код подтверждения ThatGirl Oasis");
        message.setText("Ваш код подтверждения " + messageText);
        javaMailSender.send(message);
    }
}
