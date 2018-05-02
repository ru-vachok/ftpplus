package ru.vachok.ftpplus;



import ru.vachok.ftpplus.factor.MessageForUser;

import java.time.LocalDateTime;

/**
 Класс будет давать объект <b>сообщение.</b>

 @see ru.vachok.ftpplus.factor.FactorAbs
 @since 01.05.2018 (22:23) */
public class Err implements MessageForUser {
    /**
     Ошибка.
     <p>
     {@link System#err}

     @param message сообщение для пользователя.
     */
    @Override
    public void errorMs(String message) {
        System.err.println("message = " + message + LocalDateTime.now());
    }
    /**
     OK
     <p>
     {@link System#out}

     @param message сообщение для пользователя.
     */
    @Override
    public void okMs(String message) {
        System.out.println("message = " + message + " OKE");
    }
}