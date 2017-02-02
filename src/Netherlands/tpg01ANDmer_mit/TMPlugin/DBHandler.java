package Netherlands.tpg01ANDmer_mit.TMPlugin;

import java.sql.Connection;
        import java.sql.*;
        import org.apache.derby.jdbc.EmbeddedDriver;


public class DBHandler {
    private static String dbURL = "jdbc:derby:myDB;create=true;user=me;password=mine";
    private static String tableName = "PlayerSettings";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main()
    {
        createConnection();
        insert("mer_mit", "On", "[Material.Bedrock,Material.Tnt]", "[tpg01]");
        select();
        shutdown();
    }

    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }

    private static void insert(String PlayerName, String NotificationSetting, String NotificationOnBlocks, String NoNotificationsOnPlayers)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    PlayerName + ",'" + NotificationSetting + "','" + NotificationOnBlocks + "','" + NoNotificationsOnPlayers +"')");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    private static void select()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)

            while(results.next())
            {
                String PlayerName = results.getString(1);
                String NotificationSetting = results.getString(2);
                String NotificationOnBlocks = results.getString(3);
                String NoNotificationsOnPlayers = results.getString(4);
                System.out.println(PlayerName + ", " + NotificationSetting + ", " + NotificationOnBlocks + ", " + NoNotificationsOnPlayers);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        }
        catch (SQLException sqlExcept)
        {

        }

    }
}