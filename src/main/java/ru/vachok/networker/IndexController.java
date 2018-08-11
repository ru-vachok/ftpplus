package ru.vachok.networker;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@Controller
public class IndexController {

   @GetMapping ("/")
   public ModelAndView index() {
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.addObject("Name", "Vachok");
      return modelAndView;
   }


   @RequestMapping("/docs")
   @ResponseBody
   public void addrInLocale( HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse ) throws IOException {
      httpServletResponse.sendRedirect("https://vachok.testquality.com/project/3260/plan/6672/test/86686");
      String re = "redirect:https://vachok.testquality.com/project/3260/plan/6672/test/86686\n" + Arrays.toString(new UnknownError().getStackTrace()).replaceAll(", " , "\n\n");

   }
}
