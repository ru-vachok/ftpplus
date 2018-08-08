package ru.vachok.parsers.intern;


import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 @since 08.08.2018 (23:43) */
public class Win1251 implements Encodings {

   private static final Optional<String> NULL_STRING = Optional.empty();

   @Override
   public String convertFromString(String stringForConvert) {
      try{
         return new String(stringForConvert.getBytes(), "Windows-1251");
      }
      catch(UnsupportedEncodingException e){
         Logger.getLogger(Win1251.class.getName()).log(Level.WARNING, MessageFormat.format("{0}\n\n\n{1}",
               e.getMessage(), Arrays.toString(e.getStackTrace()).replaceAll(", ",
                     "\n").replace("{", "").replace("}", "")));
      }
      return String.valueOf(NULL_STRING);
   }

   @Override
   public String convertFromBytes(byte[] bytesForConvert) {
      try{
         return new String(bytesForConvert, "Windows-1251");
      }
      catch(UnsupportedEncodingException e){
         Logger.getLogger(Win1251.class.getName()).log(Level.WARNING, MessageFormat.format("{0}\n\n\n{1}",
               e.getMessage(), Arrays.toString(e.getStackTrace()).replaceAll(", ",
                     "\n").replace("{", "").replace("}", "")));
      }
      return String.valueOf(NULL_STRING);
   }
}