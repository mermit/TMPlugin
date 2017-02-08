package Netherlands.tpg01ANDmer_mit.TMPlugin;

import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;

import org.apache.derby.iapi.sql.*;
import org.apache.derby.iapi.sql.dictionary.SystemColumn;
import org.apache.derby.jdbc.*;

public class DBHandler {
    private static String dbURL = "jdbc:derby:TMPluginDB;create=true";
    private static String tableName = "PlayerSettings";

    public DBHandler() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            Connection conn = DriverManager.getConnection(dbURL);

            dropTables(conn);
            insertPS(conn, "mer_mit", "On", "[Material.Bedrock,Material.Tnt]", "[tpg01]");

            conn.close();
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (Exception e) {
            System.out.println("[TMPlugin LOGHANDLER] Error Creating table PlayerSettings");
            System.out.println("[TMPlugin LOGHANDLER] ERROR: " + e.getMessage());
        }
    }

    public static void dropTables(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE PlaterSettings");
                System.out.println("[TMPlugin LOGHANDLER] PlayerSettings table dropped");
            } catch (SQLException ex) {
            }
        } catch (SQLException ex) {
            System.out.println("[TMPlugin LOGHANDLER] ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    private static void insertPS(Connection conn, String PlayerName, String NotificationSetting, String NotificationOnBlocks, String NoNotificationsOnPlayers)
    {
        try
        {
            Statement stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    PlayerName + ",'" + NotificationSetting + "','" + NotificationOnBlocks + "','" + NoNotificationsOnPlayers +"')");

            System.out.println("[TMPlugin LOGHANDLER] table PlayerSetting created");
        } catch (SQLException ex) {
            System.out.println("[TMPlugin LOGHANDLER] ERROR: " + ex.getMessage());
        }
    }
}