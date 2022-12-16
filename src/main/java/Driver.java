import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args){

        Connection connection = null;

        try {

            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "developer";

            connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet query = statement.executeQuery("select * from students");

            List<String> surnames = new ArrayList<>();

            System.out.println("_________ Name _________");

            while(query.next()){
                System.out.println(query.getString(3));
                surnames.add(query.getString(2));
            }

            System.out.println("________ Surname ________");

            surnames.stream().forEach(System.out::println);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}