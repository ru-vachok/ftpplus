package ru.vachok.parsers.intern;


import java.nio.charset.StandardCharsets;


/**
 @since 08.08.2018 (23:43) */
public class UTF8 implements Encodings {

   @Override
   public String convertFromString(String stringForConvert) {
      return new String(stringForConvert.getBytes(), StandardCharsets.UTF_8);
   }

   @Override
   public String convertFromBytes(byte[] bytesForConvert) {
      return new String(bytesForConvert, StandardCharsets.UTF_8);
   }
}