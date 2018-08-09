package ru.vachok.networker;


import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;


public class ViewRes implements ViewResolver {

   @Override
   public View resolveViewName(String viewName, Locale locale) throws Exception {
      return null;
   }
}
