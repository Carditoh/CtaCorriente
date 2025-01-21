package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    private WebDriver driver;

    @Given("que estoy en la página de inicio de sesión")
    public void abrirPaginaInicioSesion() {
        System.setProperty("webdriver.chrome.driver", "ruta/a/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:9090/login");
    }

    @When("ingreso el nombre de usuario {string}")
    public void ingresoNombreUsuario(String username) {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        driver.findElement(By.id("submit")).click();
    }

    @When("ingreso el nombre de usuario {string} y password {string}")
    public void ingresoNombreUsuarioYPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @Then("el sistema permite el acceso exitosamente")
    public void verificarAccesoExitoso() {
        WebElement successMessage = driver.findElement(By.id("success"));
        assertNotNull(successMessage, "El acceso no fue exitoso.");
        driver.quit();
    }

    @Then("el sistema muestra un mensaje de error")
    public void verificarMensajeError() {
        WebElement errorMessage = driver.findElement(By.id("error"));
        assertNotNull(errorMessage, "No se mostró el mensaje de error.");
        driver.quit();
    }

    @Given("que estoy en la página de registro de citas")
    public void abrirPaginaRegistroCitas() {
        driver.get("http://localhost:9090/citas");
    }

    @When("selecciono el horario {string}")
    public void seleccionoHorario(String horario) {
        WebElement horarioField = driver.findElement(By.id("horario"));
        horarioField.sendKeys(horario);
    }

    @When("confirmo la cita")
    public void confirmoCita() {
        driver.findElement(By.id("confirmar")).click();
    }

    @Then("el sistema registra la cita exitosamente")
    public void verificarCitaRegistrada() {
        WebElement successMessage = driver.findElement(By.id("success"));
        assertNotNull(successMessage, "La cita no se registró correctamente.");
        driver.quit();
    }
}