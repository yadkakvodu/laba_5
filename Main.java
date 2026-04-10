
import java.sql.*;
class Main {

    private static final String PASSWORD = "Osman200202";
    private static final String USERNAME = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/rent_of_transport_equipment";

    public static void main(String[] args) throws SQLException {
        String sql = """
                SELECT * FROM clients
                """;
        try (var connection = DriverManager.getConnection(URL,
                USERNAME, PASSWORD);
             var prepareStatement = connection.prepareStatement(sql)) {

            var resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("payment_status"));
            }
        } catch (SQLException e) {
            System.out.println("Ex: " + e.getMessage());
        }
    }
}