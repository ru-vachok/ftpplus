package ru.vachok.parsers;


/**
 @since 10.07.2018 (11:47) */
public interface InternetSiteParser {

   /**
    Создание URL, для скачивания. Например, динамически просавлять дату.
    */
   void getUrl();

   /**
    Загрузить страницу. В память, или на диск, или в БД.
    */
   void dnldSites();

   /**
    Парсинг/обработка. Что надо от загруженной информации.
    */
   void docsParser();
}
