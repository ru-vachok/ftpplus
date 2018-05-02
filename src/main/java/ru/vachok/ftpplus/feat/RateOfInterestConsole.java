package ru.vachok.ftpplus.feat;



import ru.vachok.ftpplus.Const;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;
import static ru.vachok.ftpplus.Const.SUMMA_START;

/**
 Консольный вывод % по депозиту

 @since 02.05.2018 (15:13) */
public class RateOfInterestConsole implements Runnable {
    /**
     @see Const#LOGGER
     */
    private static final Logger LOGGER = Const.LOGGER;

    /**
     Запуск через {@link java.util.concurrent.ExecutorService}. Установка лога в файл {@link #logsSetup()}
     <p>
     Сначала покажем инфо.
     <p>
     Потом узнаём у юзера текущую сумму. Если она <i>кривая</i>, тогда берем {@link Const#SUMMA_START}
     <p>
     Запускаем {@link #countMoney()}

     @see FeatMain#rateOfInterCon()
     */
    @Override
    public void run() {
        logsSetup();
        LOGGER.log(INFO, () -> SUMMA_START + " is SUMMA_START | " + "RateOfInterestConsole.java ID == 30 ||");
        float bankRate = 7.35f;
        LOGGER.log(INFO, () -> "% = " + bankRate + " ID == 32 ||");
        int yearToStay = 5;
        LOGGER.log(INFO, () -> "Term = " + yearToStay + " years" + " ID == 34 ||");
        String dateOfDeposit = "26-01-2014";
        LOGGER.log(INFO, () -> "Started Date is " + dateOfDeposit + " ID 36 ||");
        String[] dateSplit = dateOfDeposit.split("-");


        Integer yearDepo = Integer.valueOf(dateSplit[2]);

        Float awaitMoneyIdealForOneYear = SUMMA_START * (bankRate / 100) + SUMMA_START;

        if (Integer.valueOf(dateSplit[2]) < 2009) System.exit(Const.BAD_EXIT);
        for (int i = 2; i < yearToStay; i++) {
            awaitMoneyIdealForOneYear = awaitMoneyIdealForOneYear * (bankRate / 100) + awaitMoneyIdealForOneYear;
        }
        awaitMoneyIdealForOneYear = awaitMoneyIdealForOneYear * (bankRate / 100) + awaitMoneyIdealForOneYear;

        String format2 = MessageFormat.format("Planning SUMM in {0} is {1} ID == 55 ||", yearDepo + yearToStay, awaitMoneyIdealForOneYear);
        LOGGER.log(INFO, format2);

        System.out.println("Enter current real summ: ");
        @SuppressWarnings("MagicNumber 02.05.2018 (15:24)") Float curSumm = 307419.60f;

        float difference = curSumm - awaitMoneyIdealForOneYear;
        String format = MessageFormat.format("{0} is (difference) | RateOfInterestConsole.java ID == 59 ||", difference);
        try {
            Scanner scanner = new Scanner(System.in);
            curSumm = scanner.nextFloat();
        } catch (Exception e) {
            LOGGER.log(WARNING, format);
            LOGGER.log(Level.WARNING, () -> Arrays.toString(e.getStackTrace()) + " is e | " + "RateOfInterestConsole.java ID == 55 ||");
            countMoney();
        }

        String format1 = MessageFormat.format("SUMM difference = {0}", difference);
        LOGGER.log(INFO, format1);

        countMoney();
    }

    private void countMoney() {
        LOGGER.log(INFO, () -> "in progress..." + " is \"in progress...\" | " + "RateOfInterestConsole.java ID == 66 ||");
        System.exit(Const.OK.ordinal());
        // STOPSHIP: 02.05.2018 в работе
    }
    /**
     Лог класса.
     <p>
     Файл <code>RateOfInterestConsole.class.getSimpleName.log</code> в папке с программой.
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
}