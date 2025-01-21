package Junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private Connection connection;

    // Configuración de la conexión a la base de datos
    private final String DB_URL = "jdbc:mysql://localhost:3306/Cuentas_clientes";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    @BeforeEach
    public void setUp() throws SQLException {
        // Establece la conexión antes de cada prueba
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @AfterEach
    public void tearDown() throws SQLException {
        // Cierra la conexión después de cada prueba
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testConnectionNotNull() {
        // Verifica que la conexión no sea nula
        assertNotNull(connection, "La conexión a la base de datos debería establecerse correctamente.");
    }

    @Test
    public void testConnectionIsValid() throws SQLException {
        // Verifica si la conexión es válida
        assertTrue(connection.isValid(2), "La conexión a la base de datos no es válida.");
    }

    @Test
    public void testQueryExecution() throws SQLException {
        // Ejecuta una consulta simple para verificar la conectividad
        var query = "SELECT 1";
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(query);

        assertTrue(resultSet.next(), "La consulta debería devolver al menos un resultado.");
        assertEquals(1, resultSet.getInt(1), "El resultado de la consulta no es el esperado.");

        resultSet.close();
        statement.close();
    }
}