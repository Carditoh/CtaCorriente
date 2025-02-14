package Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseConnectionTest {

    private Connection connection;

    // Configuración de la conexión a la base de datos
    private final String DB_URL = "jdbc:mysql://localhost:3306/Cuentas_clientes";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    @Before
    public void setUp() throws SQLException {
        // Establece la conexión antes de cada prueba
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @After
    public void tearDown() throws SQLException {
        // Cierra la conexión después de cada prueba
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testConnectionNotNull() {
        // Verifica que la conexión no sea nula
        assertNotNull("La conexión a la base de datos debería establecerse correctamente.", connection);
    }

    @Test
    public void testConnectionIsValid() throws SQLException {
        // Verifica si la conexión es válida
        assertTrue("La conexión a la base de datos no es válida.", connection.isValid(2));
    }

    @Test
    public void testQueryExecution() throws SQLException {
        // Ejecuta una consulta simple para verificar la conectividad
        String query = "SELECT 1";
        var statement = connection.createStatement();
        var resultSet = statement.executeQuery(query);

        assertTrue("La consulta debería devolver al menos un resultado.", resultSet.next());
        assertEquals("El resultado de la consulta no es el esperado.", 1, resultSet.getInt(1));

        resultSet.close();
        statement.close();
    }
}
