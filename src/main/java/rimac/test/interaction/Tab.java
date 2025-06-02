package rimac.test.interaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class Tab implements Interaction {

    public static Tab key() {
        return Tasks.instrumented(Tab.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Verifica que el actor tenga la habilidad BrowseTheWeb
        BrowseTheWeb browseAbility = actor.abilityTo(BrowseTheWeb.class);
        if (browseAbility == null) {
            throw new IllegalStateException("El actor no tiene la habilidad de navegar por la web.");
        }

        // Obtiene el WebDriver del actor
        WebDriver driver = browseAbility.getDriver();

        // Realiza la acción de enviar la tecla TAB
        new Actions(driver)
                .sendKeys(Keys.TAB)
                .perform();
    }
}
