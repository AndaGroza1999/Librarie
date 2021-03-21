package org.sci.repository;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.jetbrains.annotations.NotNull;
import org.sci.model.Carte;
import org.sci.util.ConnectionUtil;

import java.sql.*;

public class CarteRepo {

    private static final Logger LOGGER = LogManager.getLogger(CarteRepo.class);

//    static {
//        Configurator.setLevel("org.sci.logger", Level.DEBUG);
//
//        Configurator.setRootLevel(Level.DEBUG);
//    }

    @NotNull
    private Connection connection;

    public CarteRepo() {
        connection = ConnectionUtil.getInstance().getConn();
    }

    Statement stmt = null;

    public Carte createCarte(Carte carte) {
        //INSERT
        //Varianta hardcode-ata

//        String sql = ("INSERT INTO BOOKS.book values(7, 'Zece negri mititei', 'N', 'AC', 'Buzz Books', 304, 35.9)");
//
//        try (Statement stmnt = connection.createStatement();) {
//            stmnt.execute(sql);
//        } catch (SQLException throwables) {
//            System.out.println("SQL exception: createCarte");
//            //throwables.printStackTrace();
//        }

//        String sql = ("INSERT INTO BOOKS.book values("
//                + carte.getId() +
//                ", '"
//                + carte.getNumeCarte() +
//                "', 'NA', 'AC', '"
//                + carte.getEditura() +
//                "', "
//                + carte.getNrPagini() +
//                ", "
//                + carte.getPret() +
//                ")");
//
//        try (Statement stmnt = connection.createStatement();) {
//            stmnt.execute(sql);
//        } catch (SQLException throwables) {
//            System.out.println("SQL exception: createCarte");
//            //throwables.printStackTrace();
//        }
        LOGGER.log(Level.INFO, "Method createCarte starting...");
        String sql = ("INSERT INTO BOOKS.book values(?,    ?,    ?,    ?,    ?,   ?,    ?)");

        try (PreparedStatement stmnt = connection.prepareStatement(sql)) {
            LOGGER.log(Level.DEBUG, "Prepare statement created." + stmnt.toString());

            stmnt.setInt(1, carte.getId());
            stmnt.setString(2, carte.getNumeCarte());
            stmnt.setString(3, "NA");
            stmnt.setString(4, "AC");
            stmnt.setString(5, carte.getEditura());
            stmnt.setInt(6, carte.getNrPagini());
            stmnt.setDouble(7, carte.getPret());

            stmnt.execute();

        } catch (SQLException throwables) {
            LOGGER.log(Level.ERROR, "SQL exception: createCarte" + throwables.getMessage());
            LOGGER.log(Level.ERROR, throwables);
            LOGGER.log(Level.ERROR, "SQL exception: createCarte", throwables);

            //System.out.println("SQL exception: createCarte");
            //throwables.printStackTrace();
        }
        return null;
    } // aici creaza un sql query pe baza unei conexiuni la baza de date si scrie in baza de date

    public Carte readCarte(Carte carte) {
        //SELECT
        String sql = ("SELECT * FROM BOOKS.book WHERE id = ?");

        Carte c = null;
        try (PreparedStatement stmnt = connection.prepareStatement(sql)) {

            stmnt.setInt(1, carte.getId());

            ResultSet result = stmnt.executeQuery();

            if (result.next()) {
                c = new Carte();
                c.setId(result.getInt("ID"));
                c.setNumeCarte(result.getString(2));
                c.setEditura(result.getString(5));
                c.setNrPagini(result.getInt(6));
                c.setPret(result.getDouble(7));
            }


        } catch (SQLException throwables) {
            System.out.println("SQL exception: updateCarte");
        }
        return c;
    }

    public Carte updateCarte(Carte carte) {
        //UPDATE
        //Varianta hardcode-ata
//        String sql = ("UPDATE BOOKS.book SET NRPAGINI = 500 WHERE id = 2");
//
//        try (Statement stmnt = connection.createStatement();) {
//            stmnt.execute(sql);
//        } catch (SQLException throwables) {
//            System.out.println("SQL exception: updateCarte");
//        }

//        String sql = ("UPDATE BOOKS.book SET NRPAGINI = 500 WHERE id =" + carte.getId());
//
//        try (Statement stmnt = connection.createStatement();) {
//            stmnt.execute(sql);
//        } catch (SQLException throwables) {
//            System.out.println("SQL exception: updateCarte");
//        }

        String sql = ("UPDATE BOOKS.book SET NRPAGINI = 500 WHERE id = ?");

        try (PreparedStatement stmnt = connection.prepareStatement(sql)) {

            stmnt.setInt(1, carte.getId());

            stmnt.execute();

        } catch (SQLException throwables) {
            System.out.println("SQL exception: updateCarte");
        }
        return null;
    }

    public boolean deleteCarte(Carte carte) {
        //DELETE
        //Varianta hardcode-ata
//        String sql = ("DELETE FROM BOOKS.book WHERE id = 7");
//
//        try (Statement stmnt = connection.createStatement();) {
//            stmnt.execute(sql);
//        } catch (SQLException throwables) {
//            System.out.println("SQL exception: deleteCarte");
//        }

        String sql = ("DELETE FROM BOOKS.book WHERE id = " + carte.getId());

        try (Statement stmnt = connection.createStatement()) {
            stmnt.execute(sql);
        } catch (SQLException throwables) {
            System.out.println("SQL exception: deleteCarte");
        }

//        String sql = ("DELETE FROM BOOKS.book WHERE id = ?");
//
//        try (PreparedStatement stmnt = connection.prepareStatement(sql)) {
//
//            stmnt.setInt(1, carte.getId());
//
//            stmnt.execute();
//
//        } catch (SQLException throwables) {
//            System.out.println("SQL exception: deleteCarte");
//        }
        return false;
    }
}
