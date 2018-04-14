package DataLayer;
import java.sql.*;

public class accountDetails {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mess";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Aa123456@1";

    public boolean isPasswordCorrect(String adminName, String password) {
        Connection conn = null;
        Statement stmt = null;
        boolean flag = false;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query

            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql;
            sql = "SELECT * FROM accounts WHERE username = \"" +
                    adminName + "\"";

            System.out.println(adminName + ' ' + password);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //System.out.println("inside while");
                String ps = rs.getString("password");
                System.out.println(ps);
                if (ps.equals(password)) {
                    //System.out.println(ps+password);
                    flag = true;
                }
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");
            return flag;
        }
    }


    public boolean addUser(String name, String username, String password, String dep, int year) {
        Connection conn = null;
        Statement stmt = null;
        boolean flag = true;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
           String sql = "SELECT * FROM accounts WHERE username = \"" +
                    username + "\"";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("after rs");
            while (rs.next()){
                System.out.println("inside while");
                flag = false;
            }
            if(flag) {
                System.out.println("Creating statement...");
                sql = "insert into accounts (username,password,name,department,cur_year)  values (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, name);
                ps.setString(4, dep);
                ps.setInt(5, year);

                ps.executeUpdate();
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");
            return flag;
        }
    }

    public  int isBf(String username){
        Connection conn = null;
        Statement stmt = null;
        int  flag = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
            String sql = "SELECT * FROM accounts WHERE username = \"" +
                    username + "\"";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("after rs");
            while (rs.next()) {
                System.out.println("inside while");
                flag = rs.getInt("bf");
            }
        }

             catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources

                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();

                }//end finally try

                System.out.println("Closing DB Connection - Goodbye!");
                return flag;
            }
    }

    public  void setBf(String username){
        Connection conn = null;
        Statement stmt = null;
        int  flag = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
            String sql = "UPDATE  accounts SET bf ='1' WHERE username = \"" +
                    username + "\"";

            stmt.executeUpdate(sql);
        }

        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");

        }
    }


    public  int isLu(String username){
        Connection conn = null;
        Statement stmt = null;
        int  flag = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
            String sql = "SELECT * FROM accounts WHERE username = \"" +
                    username + "\"";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("after rs");
            while (rs.next()) {
                System.out.println("inside while");
                flag = rs.getInt("lu");
            }
        }

        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");
            return flag;
        }
    }

    public  void setLu(String username){
        Connection conn = null;
        Statement stmt = null;
        int  flag = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
            String sql = "UPDATE  accounts SET lu ='1' WHERE username = \"" +
                    username + "\"";

            stmt.executeUpdate(sql);
        }

        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");

        }
    }


    public  int isDi(String username){
        Connection conn = null;
        Statement stmt = null;
        int  flag = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
            String sql = "SELECT * FROM accounts WHERE username = \"" +
                    username + "\"";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("after rs");
            while (rs.next()) {
                System.out.println("inside while");
                flag = rs.getInt("di");
            }
        }

        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");
            return flag;
        }
    }


    public  void setDi(String username){
        Connection conn = null;
        Statement stmt = null;
        int  flag = 1;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
            String sql = "UPDATE  accounts SET di ='1' WHERE username = \"" +
                    username + "\"";

            stmt.executeUpdate(sql);
        }

        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");

        }
    }



    public  boolean delete(String username){
        Connection conn = null;
        Statement stmt = null;
        boolean flag = false;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            //STEP 4: Execute a query
            String sql = "SELECT * FROM accounts WHERE username = \"" +
                    username + "\"";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("after rs");
            while (rs.next()) {
                System.out.println("inside while");
                flag = true;
                sql = "DELETE  FROM accounts WHERE username = \""  +
                        username + "\"";
                stmt.executeUpdate(sql);
            }
        }

        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }//end finally try

            System.out.println("Closing DB Connection - Goodbye!");
            return flag;
        }
    }
}
