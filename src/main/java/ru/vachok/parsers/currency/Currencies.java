package ru.vachok.parsers.currency;


import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;


/**
 @since 09.08.2018 (3:35) */
public class Currencies {

   /**
    Simple Name класса, для поиска настроек
    */
   private static final String SOURCE_CLASS = Currencies.class.getSimpleName();

   /**
    {@link }
    */
   private static MessageToUser messageToUser = new MessageCons();

   public static void getCurrency(String curName) {
      connectToCB();
      if(curName.equalsIgnoreCase("usd")) getUSD();
      if(curName.equalsIgnoreCase("eur")) getEUR();
   }

   private static void connectToCB() {
      throw new UnsupportedOperationException();
   }

   private static void getUSD() {
      throw new UnsupportedOperationException();
   }

   private static void getEUR() {
      throw new UnsupportedOperationException();
   }
}