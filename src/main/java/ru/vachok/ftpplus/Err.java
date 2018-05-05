package ru.vachok.ftpplus;



import javafx.scene.control.Dialog;
import ru.vachok.ftpplus.factor.MessageForUser;

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
        Dialog dialog = new Dialog();
        dialog.setContentText(message);
        dialog.showAndWait();
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