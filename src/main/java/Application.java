import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "Vstupinfo0108@";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM book WHERE id=(?)")) {
                statement.setInt(1, 6);
                final ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String titleOfBook = "Title: " + resultSet.getString("title");
                    String authorOfBook = "Author_id: " + resultSet.getString("id");
                    int amountOfBook = resultSet.getInt(4);

                    System.out.println(titleOfBook);
                    System.out.println(amountOfBook);
                    System.out.println("Amount: " + amountOfBook);

                }

            }
        }

    }

}
