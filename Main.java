
import java.sql.*;
class Main {

    private static final String PASSWORD = "Osman200202";
    private static final String USERNAME = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/rent_of_transport_equipment";

    public static void main(String[] args) {
        String sql = """
                SELECT * FROM clients WHERE registration_date BETWEEN ? AND ?
                """;
        try (var connection = DriverManager.getConnection(URL,
                USERNAME, PASSWORD);
             var prepareStatement = connection.prepareStatement(sql)) {

            prepareStatement.setDate(1, Date.valueOf("2010-12-12"));
            prepareStatement.setDate(2, Date.valueOf("2020-12-12"));


            var resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Ex: " + e.getMessage());
        }
    }
}

