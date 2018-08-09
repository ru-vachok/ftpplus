package ru.vachok.parsers;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;
import ru.vachok.mysqlandprops.props.DBRegProperties;
import ru.vachok.mysqlandprops.props.FileProps;
import ru.vachok.mysqlandprops.props.InitProperties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;


public class StartMeTest {

   Properties properties = new Properties();

   InitProperties initProperties = new DBRegProperties(ConstantsFor.DB_NAME + SOURCE_CLASS);

   private static final String SOURCE_CLASS = StartMeTest.class.getSimpleName();

   private MessageToUser messageToUser = new MessageCons();

   @Test (testName = "Props get")
   public void propGet() {
      dataBaseProp();
      Preferences preferences = Preferences.userRoot();
      String absolutePathPref = preferences.absolutePath();
      Assert.assertNotNull(absolutePathPref);
      messageToUser.info(SOURCE_CLASS, "absolutePathPref is", absolutePathPref);
      try{
         messageToUser.info(SOURCE_CLASS,
               Arrays.toString(preferences.childrenNames()).replaceAll(", ", "\n"),
               Arrays.toString(preferences.keys()).replaceAll(", ", "\n"));
         preferences.exportSubtree(new FileOutputStream("mypref-subtree.pref"));
         preferences.exportNode(new FileOutputStream("mypref-node.pref"));
      }
      catch(BackingStoreException | IOException e){
         Logger.getLogger(SOURCE_CLASS).log(Level.WARNING, String.format("%s%n%n%s", e.getMessage(), Arrays.toString(e.getStackTrace()).replaceAll(", ", "\n").replace("{", "").replace("}", "")));
      }
      ;
      float vachokdep = Float.parseFloat(properties.get("vachokdep").toString());
      float startmoney = Float.parseFloat(properties.get("startmoney").toString());
      messageToUser.info(SOURCE_CLASS, vachokdep + " vachok", startmoney + " all");
      String s2 = vachokdep / ConstantsFor.DOLLAR_26_JAN_2014 + " USD(v)";
      String s1 = vachokdep / ConstantsFor.EURO_26_JAN_2014 + " EURO(v)";
      messageToUser.info(ConstantsFor.UTF.convertFromString("В валюте на 26 янв. 2014 год. Сумма депозита"), s1, s2);
      String s11 = startmoney / ConstantsFor.EURO_26_JAN_2014 + " EURO";
      String s21 = startmoney / ConstantsFor.DOLLAR_26_JAN_2014 + " USD";
      messageToUser.info(ConstantsFor.UTF.convertFromString("В валюте на 26 янв. 2014 год. Сумма депозита"), s11, s21);
      properties.setProperty("startv", s1 + "-" + s2);
      properties.setProperty("startall", s11 + "-" + s21);
      initProperties.delProps();
      initProperties.setProps(properties);
   }

   private void dataBaseProp() {
      properties = initProperties.getProps();
      initProperties = new FileProps(SOURCE_CLASS);
      initProperties.setProps(properties);
   }

}