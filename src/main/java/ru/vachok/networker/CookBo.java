package ru.vachok.networker;



import org.springframework.web.util.CookieGenerator;
import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;


/**
 * @since 11.08.2018 (18:08)
 */
public class CookBo {

    /**
     * Simple Name класса, для поиска настроек
     */
    private static final String SOURCE_CLASS = CookBo.class.getSimpleName();
    /**
     * {@link }
     */
    private static MessageToUser messageToUser = new MessageCons();


    public CookieGenerator genCook() {
        CookieGenerator cookieGenerator = new CookieGenerator();
        cookieGenerator.setCookieDomain("eatmeat.ru");
        cookieGenerator.setCookieMaxAge(3600);
        cookieGenerator.setCookieName(System.currentTimeMillis() + "");
        return cookieGenerator;
    }
}