package ru.vachok.ftpplus.feat;



/**
 {@link com.mysql.jdbc.jdbc2.optional.MysqlDataSource} для разных баз.

 @since 05.05.2018 (15:13) */
public class DSMySQL implements Runnable {
    /**
     Пароль для этого класса.
     <p>
     идея - запаролить именно запуск класса, а не коннект к БД.
     */
    String myPass;
    public DSMySQL(String myPass) {
        this.myPass = myPass;
    }

    @Override
    public void run() {

    }
}