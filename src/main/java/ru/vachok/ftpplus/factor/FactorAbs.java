package ru.vachok.ftpplus.factor;



/**
 Класс абстрактной фабрики.

 @since 01.05.2018 (22:04) */
public class FactorAbs {

    MessagesFactory createFactory(String typeFac) {
        switch (typeFac) {
            case "MSG":
                return new MessagesFactory();
            case "FTP":
                return null;
            case "SSH":
                return new SSHFact();
            default:
                return new MessagesFactory();
        }
    }
}