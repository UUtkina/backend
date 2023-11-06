package ait;

import ait.de.config.MessageConfig;

import ait.de.model.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Создание и инициализация контекста Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

        // Получение бина класса Message
        Message message = context.getBean(Message.class);

        // Установка сообщения
        message.setMessage("Добрій день");

        // Вывод сообщения
        System.out.println(message.getMessage());


    }
}
