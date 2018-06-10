/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigest.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sigest.VARIABLE_SIGest;

/**
 *
 * @author Jair
 */
public class DatabaseMySQL implements Database{
    
    private Connection connection;    
            
    @Override
    public Connection conectar() {
        try {
        
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    VARIABLE_SIGest.DB_URL + VARIABLE_SIGest.DB_NAME, 
                    VARIABLE_SIGest.DB_USER, 
                    VARIABLE_SIGest.DB_PASS
            );
            return this.connection;
        
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void desconectar(Connection conn) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
