package ru.vachok.ftpplus.factor;



/**
 Фейс сообщения для юзера.

 @since 01.05.2018 (19:15) */
public interface MessageForUser {
    /**
     Показать ошибку.

     @param message сообщение для пользователя.
     */
    void errorMs(String message);

    /**
     Показать ОК

     @param message сообщение для пользователя.
     */
    void okMs(String message);
}
