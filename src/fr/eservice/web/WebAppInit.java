package fr.eservice.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class WebAppInit implements WebApplicationInitializer {

    public void onStartup(ServletContext context) throws ServletException {

        System.out.println("initialize servletContext");

    }

}
