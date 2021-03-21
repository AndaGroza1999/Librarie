package org.sci.repository;

import org.jetbrains.annotations.NotNull;
import org.sci.newModel.Roman;
import org.sci.util.ConnectionUtil;

import java.sql.Connection;

public class RomanRepo {

    @NotNull
    private Connection connection;

    public RomanRepo() {
        connection = ConnectionUtil.getInstance().getConn();
    }


    public Roman createRoman(Roman roman) {
        return null;
    }

    public Roman readRoman(Roman roman) {
        return null;
    }

    public Roman updateRoman(Roman roman) {
        return null;
    }

    public boolean deleteRoman(Roman roman) {
        return false;
    }
}
