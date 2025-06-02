package rimac.test.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static rimac.test.userinterfaces.login.LoginUi.TXT_CONTRASEÑA;
import static rimac.test.userinterfaces.login.LoginUi.TXT_USUARIO;
import static rimac.test.utils.Constantes.PASSWORD;
import static rimac.test.utils.Constantes.USERNAME;

public class IniciarSesion implements Task {

    private String user;
    private String password;

    @Override
    public <T extends Actor> void performAs(T actor) {


        Actions actions = new Actions(actor.usingAbilityTo(BrowseTheWeb.class).getDriver());

        user = actor.recall(USERNAME);
        password = actor.recall(PASSWORD);

        actor.attemptsTo(
                WaitUntil.the(TXT_USUARIO, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(TXT_USUARIO),
                WaitUntil.the(TXT_CONTRASEÑA, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(TXT_CONTRASEÑA)

        );
        actions.sendKeys(Keys.ENTER).perform();


    }

    public static IniciarSesion conCredenciales() {
        return instrumented(IniciarSesion.class);
    }
}
