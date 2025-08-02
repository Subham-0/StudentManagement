import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "Run@0";


        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "select * from student";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt("idstudent"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}