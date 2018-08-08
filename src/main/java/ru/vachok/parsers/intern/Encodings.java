package ru.vachok.parsers.intern;


public interface Encodings {

   String convertFromString(String stringForConvert);

   String convertFromBytes(byte[] bytesForConvert);
}
