package rimac.test.stepsdefinition.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import rimac.test.userinterfaces.login.LoginUi;


import java.io.InputStream;
import java.util.Properties;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static rimac.test.utils.Constantes.PASSWORD;
import static rimac.test.utils.Constantes.USERNAME;

public class Hooks {

    // Se define un actor global que representará al usuario en cada prueba
    public static final Actor actor = Actor.named("Usuario");

    @Before
    public void setTheStage(Scenario scenario) {

        // Se obtienen las variables de entorno definidas en serenity.conf
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

        String ambiente;
        String url;
        String username;
        String password;

        System.out.println("Tags del escenario: " + scenario.getSourceTagNames());

        if (scenario.getSourceTagNames().contains("@SASoci")) {
            ambiente = "SASoci";
            url = variables.getProperty("environments.default.webdriver.base.urlsasoci");
            username = System.getenv("USERNAMESASOCI");
            password = System.getenv("PASSWORDSASOCI");
        } else {
            ambiente = "sas";
            url = variables.getProperty("environments.default.webdriver.base.url");
            username = System.getenv("USERNAME");
            password = System.getenv("PASSWORD");
        }
        System.out.println(url);

        // Fallback a secrets.properties si no están definidas en variables de entorno
        if (username == null || password == null) {
            try (InputStream input = Hooks.class.getClassLoader().getResourceAsStream("secrets.properties")) {
                if (input != null) {
                    Properties props = new Properties();
                    props.load(input);

                    if (ambiente.equals("SASoci")) {
                        username = props.getProperty("usernameSASoci");
                        password = props.getProperty("passwordSASoci");
                    } else {
                        username = props.getProperty("username");
                        password = props.getProperty("password");
                    }
                } else {
                    System.err.println("No se encontró el archivo secrets.properties");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--window-size=1920,1080");
        // Se puede activar para ejecución sin interfaz gráfica
        // options.addArguments("--headless=new");


        // Prepara el WebDriver de Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        // Inicializar el actor y navegador
//        LoginUi loginUi = new LoginUi();
//        loginUi.setDefaultBaseUrl(url);




        OnStage.setTheStage(new OnlineCast()); // <--- Inicializa el escenario de Screenplay con una "compañía" de actores
        actor.can(BrowseTheWeb.with(driver));  // <---  El actor puede navegar en la web usando el driver configurado
        actor.attemptsTo(Open.url(url));  // <--- Usar la instancia con URL configurada
        getDriver().manage().window().maximize();  //  <--- Maximiza la ventana del navegador

        // Guardar credenciales en la memoria del actor
        actor.remember(USERNAME, username);
        actor.remember(PASSWORD, password);
    }

    @After
    public void tearDown() {
        // Esta línea detiene y limpia el entorno de los actores de Screenplay.
        OnStage.drawTheCurtain();
    }


}

