import java.sql.*;

public class CheckDB {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/green_reminder", "root", "123456");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SHOW TABLES;");
        System.out.println("Tables in green_reminder:");
        while (rs.next()) {
            System.out.println("  - " + rs.getString(1));
        }
        rs.close();
        st.close();
        conn.close();
    }
}
