package ru.vachok.parsers.currency;


import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class CurrenciesTest {

   private static final String SOURCE_CLASS = CurrenciesTest.class.getSimpleName();

   private MessageToUser messageToUser = new MessageCons();

   @Test (testName = "CB connector")
   public void conToCB() {
      String urlString = "https://www.cbr.ru/currency_base/daily/";
      try{
         URL url = new URL(urlString);
         URLConnection urlConnection = url.openConnection();
         urlConnection.connect();
         InputStream inputStream = urlConnection.getInputStream();
         File destination = new File("cb.html");
         FileUtils.copyInputStreamToFile(inputStream, destination);
         List<String> destinanionList = FileUtils.readLines(destination, StandardCharsets.UTF_8);
         Stream<String> desStream = destinanionList.stream();
         desStream.filter(x -> x.contains("<td>")).forEach(x -> {
            if(x.contains("USD")) x = "";
            System.out.println(x);
         });

      }
      catch(IOException e){
         Logger.getLogger(SOURCE_CLASS).log(Level.WARNING, String.format("%s%n%n%s", e.getMessage(), Arrays.toString(e.getStackTrace()).replaceAll(", ", "\n").replace("{", "").replace("}", "")));
      }
   }
}