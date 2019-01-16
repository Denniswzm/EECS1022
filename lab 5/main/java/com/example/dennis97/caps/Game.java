package com.example.dennis97.caps;

import java.util.List;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {

    private CountryDB db;

    public Game() {
        db = new CountryDB();
    }



    public String qa(){
        List<String> list = db.getCapitals();
        int n = (int)((list.size())*Math.random());
        Country ref = db.getData().get(list.get(n));
//        return c.toString();
        if (Math.random() < 0.5) {
            return String.format("What is the capital city of %s?\n%s", ref.getName(), ref.getCapital());
        } else {
            return String.format("%s is the capital of ?\n%s", ref.getCapital(), ref.getName());
        }
    }

}
