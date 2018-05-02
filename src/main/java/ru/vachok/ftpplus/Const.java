package ru.vachok.ftpplus;



import com.google.common.base.MoreObjects;

import java.util.logging.Logger;

/**
 Различные константы.

 @since 01.05.2018 (19:00) */
public enum Const {

    /**
     Штатный {@link System#exit(int)}
     */
    OK;
    public static final int BAD_EXIT = 666;
    /**
     {@link Logger}. Если надо что-то "записать :)"
     */
    public static final Logger LOGGER = Logger.getLogger("globalapp");
    public static final String IN_PROGRESS = "In Progress...";
    /**
     Таймаут в 5 сек.
     */
    private static final int TIMEOUT_5 = 5000;
    /**
     @return <code>.toString</code>
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("LOGGER", LOGGER)
                .add("OK", OK)
                .add("TIMEOUT_5", TIMEOUT_5)
                .add("IN_PROGRESS", IN_PROGRESS)
                .toString();
    }
}
