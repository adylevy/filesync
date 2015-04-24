package FileSync;

import FileSync.Dal.AnotherThing;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;


/**
 * Created by Ady on 2/14/2015.
 */
public class Db {
/*
    public static void playWithSql1() {
// Setup the entity manager
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager em = factory.createEntityManager();
// Create it
        AnotherThing t = new AnotherThing();
        t.setText("Heya2");
// Add it
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(t);

        trans.commit();
// Fetch them
        AnotherThing k=em.find(AnotherThing.class,51);
        
        TypedQuery<AnotherThing> q = em.createQuery("select ting from AnotherThing ting", AnotherThing.class);
        List<AnotherThing> results = q.getResultList();
        for (AnotherThing thing : results) {
            System.out.println(thing.getId() + ": " + thing.getText());
        }
// Close the entity manager
        em.close();
        factory.close();
    }
/*
    public static void playWithSql() {
        // load the sqlite-JDBC driver using the current class loader
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");

            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from person");
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }

    }
*/
}