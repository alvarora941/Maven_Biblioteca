import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VulnerableService {

    public void searchUser(String username) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            statement = connection.createStatement();
            // Vulnerabilidad de inyección SQL aquí
            String query = "SELECT * FROM users WHERE username = '" + username + "'";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Procesamiento de los resultados
                System.out.println("User found: " + resultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void processTransaction(String cardNumber, String cvv) {
        try {
            // Lógica de procesamiento ficticia
            if(cardNumber == null || cvv == null) {
                throw new IllegalArgumentException("Credit card details are not complete.");
            }
            System.out.println("Processing transaction with card: " + cardNumber);
        } catch (Exception e) {
            // Exponiendo información sensible en logs
            e.printStackTrace(); // Esta línea es potencialmente peligrosa
        }
    }

    public static void main(String[] args) {
        VulnerableService service = new VulnerableService();
        service.searchUser("admin");  // Prueba de la vulnerabilidad
    
        SensitiveDataExposure example = new SensitiveDataExposure();
        example.processTransaction("1234-5678-9012-3456", "123"); // Datos de tarjeta de crédito expuestos


        // Simulación de código de producción

        int valorImportante = calcularValorImportante();

        // Se debe eliminar o asegurar que el siguiente código no se ejecute en producción
        // assert valorImportante > 0 : "El valor no puede ser cero o negativo";

        // Continuación del flujo normal del programa
        System.out.println("El valor importante es: " + valorImportante);
    }

    public static int calcularValorImportante() {
        // Implementación del método que calcula algún valor
        return 100;
    }

}
