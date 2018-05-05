package ru.vachok.ftpplus.feat;



import ru.vachok.ftpplus.Const;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;


/**
 Консольный вывод % по депозиту.
 <p>
 Перерасчёт, на валюты. Варианты.
 @since 02.05.2018 (15:13) */
public class RateOfInterestConsole implements Runnable {
    /**
     Сумма на 26 января 2014 года.
     */
    private static final Float SUMMA_START_RUB = 119061.9f;
    /**
     Сумма на счету в руб.

     @since 04.05.2018 (7:29)
     */
    private static final Float CURRENT_SUMM_RUB = 307419.60f;
    /**
     Курс доллара 26 января 2014 года.
     */
    private static final Float DOLLAR_RATE_2014 = 34.26f;
    /**
     Курс ЕВРО 26 января 2014 года.
     */
    private static final Float EURO_RATE_2014 = 46.89f;

    /**
     @see Const#LOGGER
     */
    private static final Logger LOGGER = Const.LOGGER;
    /**
     Запуск через {@link java.util.concurrent.ExecutorService}. Установка лога в файл {@link #logsSetup()}
     <p>
     Сначала покажем инфо.
     <p>
     Потом узнаём у юзера текущую сумму. Если она <i>кривая</i>, тогда берем
     <p>

     @see FeatMain#rateOfInterCon()
     */
    @Override
    public void run() {
        logsSetup();
        LOGGER.log(INFO, () -> SUMMA_START_RUB + " is SUMMA_START_RUB | " + "RateOfInterestConsole.java ID == 57 ||");
        LOGGER.log(INFO, () -> CURRENT_SUMM_RUB + " is CURRENT_SUMM_RUB | " + "RateOfInterestConsole.java ID == 58 ||");
        LOGGER.log(INFO, () -> DOLLAR_RATE_2014 + " is DOLLAR_RATE_2014 | " + "RateOfInterestConsole.java ID == 59 ||");
        LOGGER.log(INFO, () -> EURO_RATE_2014 + " is EURO_RATE_2014 | " + "RateOfInterestConsole.java ID == 60 ||");
        float realDiff = CURRENT_SUMM_RUB - SUMMA_START_RUB;
        countMoney(realDiff);
    }
    /**
     Рассчётный метод.

     @param realDiff сколько сейчас минус сколько было.
     */
    private void countMoney(float realDiff) {
        LOGGER.log(WARNING, () -> realDiff + " is diff from start | " + "RateOfInterestConsole.java ID == 89 ||");
        System.exit(Const.OK.ordinal());
    }
    /**
     Лог класса.
     <p>
     Файл <code>RateOfInterestConsole.class.getSimpleName.log</code> в папке с программой.
     Отказывается от <code>ParentHandlers</code>, в пользу:
     <p>
     new {@link FileHandler}.(new {@link SimpleFormatter}) и new {@link ConsoleHandler}.
     @see #run()
     */
    private void logsSetup() {
        LOGGER.addHandler(new ConsoleHandler());
        try {
            FileHandler fileHandler = new FileHandler(RateOfInterestConsole.class.getSimpleName() + ".log");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(INFO, () -> e.getMessage() + " is e.getMessage() | " + "RateOfInterestConsole.java ID == 73 ||");
        }
        LOGGER.setUseParentHandlers(false);
    }
    /**Скачивает курсы из БД на РЕГ.РУ.
     <p>
     <a href="http://inetor.vachok.ru/ru/vachok/inet/threads/KursToday.html" target=_blank>Доп. материал.</a>
     @return курсы доллара и ЕВРО от ЦБРФ на сегодня
     */
    private ConcurrentHashMap<Float, String> currenciesToday() {
        ConcurrentHashMap<Float, String> kursValut = new ConcurrentHashMap<>();
        return kursValut;
    }
}