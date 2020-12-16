package org.sci.repository;

import org.sci.model.Utilizator;
import org.sci.util.ConnectionUtil;

import java.sql.Connection;

public class UtilizatorRepo {

    private Connection connection;

    public UtilizatorRepo() {
        connection = ConnectionUtil.getInstance().getConn();
    }


    public Utilizator createUtilizator(Utilizator utilizator) {
        //INSERT
        return null;
    }

    public Utilizator readUtilizator(Utilizator utilizator) {
        //SELECT
        return null;
    }

    public Utilizator updateUtilizator(Utilizator utilizator) {
        //UPDATE
        return null;
    }

    public boolean deleteUtilizator(Utilizator utilizator) {
        //DELETE
        return false;
    }
}
