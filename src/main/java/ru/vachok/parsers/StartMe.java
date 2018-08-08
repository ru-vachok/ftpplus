package ru.vachok.parsers;


import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;
import ru.vachok.mysqlandprops.props.InitProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import static ru.vachok.parsers.ConstantsFor.UTF;


/**
 @since 08.08.2018 (23:35) */
public class StartMe {

   /**
    Simple Name класса, для поиска настроек
    */
   private static final String SOURCE_CLASS = StartMe.class.getSimpleName();

   private static Properties properties = new Properties();

   /**
    {@link }
    */
   private static MessageToUser messageToUser = new MessageCons();

   private static InitProperties initProperties;

   public static void main(String[] args) {
      propertiesGet();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      messageToUser.info(SOURCE_CLASS, UTF.convertFromString("Это тест!"), new Date().toString());
      messageToUser.info(SOURCE_CLASS, UTF.convertFromString("Курс ЕВРО на ") +
                  LocalDate.parse("26-01-2014", dateTimeFormatter).toString() + UTF.convertFromString(" был ")
                  + ConstantsFor.EURO_26_JAN_2014 + UTF.convertFromString(" руб. за 1 шт."),
            UTF.convertFromString("Сейчас: ") +
                  LocalDate.now().toString());
      messageToUser.info(SOURCE_CLASS, UTF.convertFromString("Курс Доллара США на ") +
                  LocalDate.parse("26-01-2014", dateTimeFormatter).toString() + UTF.convertFromString(" был ")
                  + ConstantsFor.DOLLAR_26_JAN_2014 + UTF.convertFromString(" руб. за 1 шт."),
            UTF.convertFromString("Сейчас: ") +
                  LocalDate.now().toString());
   }

   private static void propertiesGet() {
      try{
         properties.load(new FileInputStream("main.properties"));
      }
      catch(IOException e){
         messageToUser.errorAlert(SOURCE_CLASS, e.getMessage(), Arrays.toString(e.getStackTrace()).replaceAll(", ",
               "\n").replace("{", "").replace("}", ""));
      }
      messageToUser.infoNoTitles(properties.toString());
   }
}