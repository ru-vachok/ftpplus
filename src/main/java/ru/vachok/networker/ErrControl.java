package ru.vachok.networker;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ErrControl implements ErrorController {

   @Override
   public String getErrorPath() {
      return "/error";
   }

   @RequestMapping ("/error")
   @ResponseBody
   public String errHandle(HttpServletRequest httpServletRequest) {
      Integer statCode = ( Integer ) httpServletRequest.getAttribute("javax.servlet.error.status_code");
      Exception exception = ( Exception ) httpServletRequest.getAttribute("javax.servlet.error.exception");
      return String.format("<html><body><h2>ОШИБКА</h2><div>Status code: <b>%s</b></div>"
                  + "<div>Exception Message: <b>%s</b></div><body></html>",
            statCode, exception==null? "N/A": exception.getMessage());
   }

}
