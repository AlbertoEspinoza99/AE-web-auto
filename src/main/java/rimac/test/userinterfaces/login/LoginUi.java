package rimac.test.userinterfaces.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url")
public class LoginUi extends PageObject {

    public static final Target TXT_USUARIO = Target.the("Input text para el usuario").located(By.id("CODUSUARIO"));
    public static final Target TXT_CONTRASEÑA = Target.the("Input text para la contraseña").located(By.id("CLAVE"));
    public static final Target BTN_LOGIN = Target.the("Boton para logear").located(By.id("btningresar"));


}