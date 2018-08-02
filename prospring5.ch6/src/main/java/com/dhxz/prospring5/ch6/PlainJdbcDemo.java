package com.dhxz.prospring5.ch6;

import com.dhxz.prospring5.ch6.dao.PlainSingerDao;
import com.dhxz.prospring5.ch6.dao.SingerDao;
import com.dhxz.prospring5.ch6.entities.Singer;

public class PlainJdbcDemo {

    private static SingerDao singerDao = new PlainSingerDao();

    public static void main(String[] args) {
        listAllSingers();
        System.out.println("-------------------------------");

    }

    private static void listAllSingers() {
        for (Singer singer : singerDao.findAll()) {
            System.out.println(singer);
        }
        ;
    }
}
