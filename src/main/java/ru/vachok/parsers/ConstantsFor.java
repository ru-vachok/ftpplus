package ru.vachok.parsers;


import ru.vachok.parsers.intern.Encodings;
import ru.vachok.parsers.intern.UTF8;
import ru.vachok.parsers.intern.Win1251;


public enum ConstantsFor {
   OK;

   public static final Encodings UTF = new UTF8();

   public static final Encodings WIN = new Win1251();

   static final Float DOLLAR_26_JAN_2014 = 34.26f;

   static final Float EURO_26_JAN_2014 = 46.89f;

}
