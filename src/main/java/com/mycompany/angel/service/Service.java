/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.angel.service;

import com.mycompany.angel.dao.PeoplesDAO;
import com.mycompany.angel.model.Kursanty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static javassist.CtMethod.ConstParameter.integer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author FARHAD
 */
@Path("service")
public class Service {
/*
    //simulate db
    private static Map<Integer, Kursanty> kursants = new HashMap<Integer, Kursanty>();

    //insert text data in db
    static {
        for (int i = 0; i < 10; i++) {
            Kursanty kursant = new Kursanty();
            int id = i + 1;
            kursant.setId(id);
            kursant.setFullName("My wonderful kursssss" + id);
            kursant.setAge(new Random().nextInt(40) + 1);

            kursants.put(id, kursant);
        }
    }

    //method return 1 kursant */
 
    private PeoplesDAO PeoplesDao =  new PeoplesDAO();
    
    @GET
    @Path("/getKursantByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Kursanty getKursantByIdXML(@PathParam("id") int id) {
        return PeoplesDao.getKursantyById(id);

    }

    //method return object in JSON
    @GET
    @Path("/getKursantByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kursanty getKursantByIdJSON(@PathParam("id") int id) {
        return PeoplesDao.getKursantyById(id);
    }

    //method return object all in list
    @GET
    @Path("/getAllKursantByIdJSON")
    @Produces(MediaType.APPLICATION_XML)
    public List<Kursanty> getAllKursantInXML() {
        return PeoplesDao.getAllKursants();
    }

}
