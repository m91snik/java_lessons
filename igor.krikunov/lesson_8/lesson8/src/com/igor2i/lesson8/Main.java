package com.igor2i.lesson8;

import java.util.*;

/**
 * Created by igor2i on 06.08.15.
 */
public class Main {

    public static void main(String args[]){

        Map<OrgerId, Order> orgers = new HashMap<>();

        OrgerId orgerId1 = new OrgerId("Dobr","Juice","1");
        orgers.put(orgerId1,new Order(orgerId1,70,"RUB"));

        OrgerId orgerId2 = new OrgerId("J7","Juice","1");
        orgers.put(orgerId2,new Order(orgerId2,90,"RUB"));

        OrgerId orgerId3 = new OrgerId("J7","Juice","2");
        orgers.put(orgerId3,new Order(orgerId3,300,"RUB"));

        orgers.replace(orgerId3, new Order(orgerId3, 100, "RUB"));

        System.out.println(orgers.toString());
        System.out.println(orgers.toString());



    }

}
