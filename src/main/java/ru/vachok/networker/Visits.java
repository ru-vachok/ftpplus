package ru.vachok.networker;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;


public class Visits {

   public static Integer visit;


   public void saverDB() {
      SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
      JdbcTemplate jdbcTemplate = new JdbcTemplate();
   }

}
