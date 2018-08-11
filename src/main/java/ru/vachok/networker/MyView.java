package ru.vachok.networker;



import org.springframework.web.servlet.View;
import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * @since 11.08.2018 (18:42)
 */
public class MyView implements View {

    /**
     * Simple Name класса, для поиска настроек
     */
    private static final String SOURCE_CLASS = MyView.class.getSimpleName();
    /**
     * {@link }
     */
    private static MessageToUser messageToUser = new MessageCons();
    private Map<String, ?> model;
    private HttpServletRequest request;
    private HttpServletResponse response;


    public MyView( Map<String, ?> model , HttpServletRequest request , HttpServletResponse response ) {
        this.model = model;
        this.request = request;
        this.response = response;
    }


    /**
     * Render the view given the specified model.
     * <p>The first step will be preparing the request: In the JSP case, this would mean
     * setting model objects as request attributes. The second step will be the actual
     * rendering of the view, for example including the JSP via a RequestDispatcher.
     *
     * @param model    Map with name Strings as keys and corresponding model
     *                 objects as values (Map can also be {@code null} in case of empty model)
     * @param request  current HTTP request
     * @param response HTTP response we are building
     * @throws Exception if rendering failed
     */
    @Override
    public void render( Map<String, ?> model , HttpServletRequest request , HttpServletResponse response ) throws Exception {

        this.model = model;
        this.request = request;
        this.response = response;
    }
}