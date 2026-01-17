package stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroUsuario {
	
	private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger logger = LoggerFactory.getLogger(RegistroUsuario.class);
    
    
    @Given("Ingreso al portal")
    public void ingreso_portal() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
    }
    
    @When("Clic en el menu {string}")
    public void i_enter_username(String opcionMenu) {
    	logger.info("Se dara clic en el menu.....");
        WebElement opcionMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + opcionMenu + "')]")));
        opcionMenuElement.click();
        logger.info("Se abre pantalla");
    }
	
    @When("Type en el campo {string} {string}")
    public void type_en_el_campo(String nombreCampo, String texto) {
    	try {
    		logger.info("Buscando el campo '{}' para escribir '{}'", nombreCampo, texto);
        	WebElement nombreCampoElement = driver.findElement(By.xpath("//input[@name='" + nombreCampo + "']"));        	
            nombreCampoElement.click();
            logger.info("Texto '{}' escrito exitosamente en el campo '{}'", texto, nombreCampo);
            nombreCampoElement.sendKeys(texto);    		
    	}catch(Exception e) {   		
    		
    		logger.error("ERROR CRÍTICO: No se pudo ingresar al portal", e);
            fail("Error al capturar en el campo: " + e.getMessage());
    	} 	
        
    }
    
    @When("Seleccionar opcion {string}")
    public void seleccionar_opcion(String opcion) {
    	try {
    		logger.info("Selecciona la opcion'{}'", opcion);
    		WebElement selecionPaisElement = driver.findElement(By.name("country"));

    		Select paisSeleccion = new Select(selecionPaisElement);
    		paisSeleccion .selectByVisibleText(opcion);
    		
    		
    	}catch(Exception e) {
    		logger.error("ERROR CRÍTICO: No se pudo ingresar al portal", e);
            fail("Error al seleccionar la opcion: " + e.getMessage());	
    	}     	
    }
    
    
    @Then("click en el boton {string}")
    public void click_en_el_boton(String nombreBoton) {
    	try {
    		logger.info("Clic en el boton'{}' ", nombreBoton);
        	WebElement nombreBotonElement = driver.findElement(By.xpath("//input[@name='" + nombreBoton + "']"));        	
            nombreBotonElement.click();
            logger.info("Clic en el boton de manera correcta");    		
    	}catch(Exception e) {   		    		
    		logger.error("ERROR CRÍTICO: No se pudo ingresar al portal", e);
            fail("Error al dar clic en el boton: " + e.getMessage());
    	} 	    	
    }

    @When("Cerrar ventana emergente")
    public void ejecutar_en_ventana_emergente_y_regresar() {
        String originalWindow = driver.getWindowHandle();
        try {
            logger.info("Inicia Busqueda de PopUP");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("div.cb-close")
            ));
            closeButton.click();
            logger.info("Click normal exitoso");
            Thread.sleep(1000);
            logger.info("Ventana emergente cerrada");

        } catch (Exception e) {
            logger.error("Error al cerrar pup up", e);
        }
    }

    @When("Tiempo de espera {int}")
    public void tiempo_espera(Integer segundos){
        try{
            logger.info("Tiempo de espera'{}'", segundos );
            Thread.sleep(segundos * 1000L);
        }catch(Exception e){
            logger.error("ERROR CRÍTICO: Tiempo de espera fallo", e);
            fail("Error al dar tiempo de espera: " + e.getMessage());
        }
    }
    
    @When("Flujo terminado")
    public void Flujo_terminado() {
    	try {
    		logger.info("Cerrando sesion");
        	driver.quit();
    	}catch(Exception e) {
    		logger.error("ERROR CRÍTICO: No se pudo ingresar al portal", e);
            fail("Error cerrar el flujo: " + e.getMessage());
    	}
    }	

}
