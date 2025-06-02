package rimac.test.task.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DblClickVisibleItemByXPath implements Task {

    private final Target target;
    private final int inTiempo;

    public DblClickVisibleItemByXPath(Target target, int inTiempo) {
        this.target = target;
        this.inTiempo = inTiempo;
    }

    public boolean isClickable(WebDriver driver, WebElement element, int inTiempo) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, inTiempo);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> elements = target.resolveAllFor(actor).stream()
                .map(WebElementFacade::getWrappedElement)
                .collect(Collectors.toList());
        for (WebElement element : elements) {
            if (element.isDisplayed() && isClickable(driver, element, inTiempo) && element.isEnabled()) {
                try {
                    ((JavascriptExecutor) driver).executeScript("var evt = new MouseEvent('dblclick', {bubbles: true, cancelable: true, view: window}); arguments[0].dispatchEvent(evt);", element);
                } catch (Exception e) {
                    // Si el clic falla, intenta con JavaScript
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                }
                break;
            }
        }
    }

    public static DblClickVisibleItemByXPath on(Target target, int inTiempo) {
        return instrumented(DblClickVisibleItemByXPath.class, target, inTiempo);
    }
}
