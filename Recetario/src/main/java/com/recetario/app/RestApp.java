package com.recetario.app;

import com.recetario.servicio.RecetarioServicio;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//https://www.journaldev.com/9170/restful-web-services-tutorial-java

public class  RestApp extends Application {
    private Set<Object> singletons= new HashSet<Object>();

    public RestApp() {
        singletons.add(new RecetarioServicio());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
