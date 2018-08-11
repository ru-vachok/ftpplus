package ru.vachok.networker;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.vachok.messenger.MessageCons;
import ru.vachok.messenger.MessageToUser;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;


@Controller
public class IndexController {

    private static final Map<String, String> SHOW_ME = new ConcurrentHashMap<>();
    private MessageToUser messageToUser = new MessageCons();


    @RequestMapping("/docs")
    @ResponseBody
    public Map<String, String> mapToShow( HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse ) throws IOException, ServletException {
        ExecutorService executorService = Executors.unconfigurableExecutorService(Executors.newSingleThreadExecutor());
        Runnable r = new SaverByOlder(SHOW_ME);
        SHOW_ME.put("addr" , httpServletRequest.getRemoteAddr());
        SHOW_ME.put("host" , httpServletRequest.getRequestURL().toString());
        SHOW_ME.forEach(( x , y ) -> messageToUser.info(this.getClass().getSimpleName() , x , y));
        new CookBo().genCook().addCookie(httpServletResponse , httpServletRequest.getQueryString());
        Stream<String> stringStream = addrInLocale(httpServletRequest , httpServletResponse);
        stringStream.forEach(x -> SHOW_ME.put("addrInLocale" , x));
        Map<String, Object> model = index(httpServletRequest , httpServletResponse).getModel();
        model.forEach(( x , y ) -> SHOW_ME.put(x , y.toString()));
        SHOW_ME.put("status" , httpServletResponse.getStatus() + " " + httpServletResponse.getBufferSize() + " buff");
        String s = httpServletRequest.getQueryString();
        if (s != null) {
            SHOW_ME.put(this.toString() , s);
            if (s.contains("chess"))
                httpServletResponse.sendRedirect("https" + "://vachok" + ".testquality" + ".com/project/3260/plan/6672/test/86686");
            executorService.execute(r);
            System.exit(0);
        }
        executorService.execute(r);
        return SHOW_ME;
    }


    @RequestMapping("/vir")
    @ResponseBody
    public Stream<String> addrInLocale( HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse ) throws IOException {
        String re = "redirect:https://vachok.testquality.com/project/3260/plan/6672/test/86686\n" + Arrays.toString(new UnknownError().getStackTrace()).replaceAll(", " , "\n\n");
        ServletInputStream in = httpServletRequest.getInputStream();
        byte[] bs = in.readAllBytes();
        messageToUser.info("HTTP Servlets Controller" , httpServletRequest.getServletPath() + re , "1 КБ resp: " + new String(bs , "UTF-8"));
        File[] files = new File("g:\\myEX\\").listFiles();
        int length = files.length;
        List<String> namesFile = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            File file = files[new Random().nextInt(length)];
            namesFile.add(file.getAbsolutePath());
        }
        String s = LocalDateTime.of(2018 , 10 , 14 , 7 , 0).format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        namesFile.add(s);
        namesFile.add(httpServletRequest.toString());
        return namesFile.parallelStream();
    }


    @GetMapping("/")
    public ModelAndView index( HttpServletRequest httpServletRequest , HttpServletResponse servletResponse ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name" , "Vachok");
        modelAndView.getModelMap().put("Now" , new Date());
        File[] files = new File("g:\\myEX\\").listFiles();
        modelAndView.addObject("img" , files[new Random().nextInt(files.length)]);
        return modelAndView;
    }
}
