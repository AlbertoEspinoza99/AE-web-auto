package rimac.test.userinterfaces.home;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomeUi extends PageObject {

    public static final Target LBL_MODULO = Target.the("modulo del sistema").locatedBy("//span[(text()='{0}')]//parent::div");
    public static final Target LBL_SUBMODULO_TERCEROS = Target.the("submodulo de terceros del sistema").locatedBy("//div[contains(@id, '000')]//span[contains(text(),'{0}')]");
    public static final Target LBL_SUBMODULO_TERCEROSB = Target.the("submodulo 2 de terceros del sistema").locatedBy("//span[(text()='{0}')]//parent::a");
    public static final Target LBL_SUBMODULO_OPCIONES = Target.the("opciones de submodulos del sistema").locatedBy("//span[(text()='{0}')]//parent::a");
    public static final Target DIV_CERRAR_DESCRIPCION = Target.the("boton para cerrar descripcion").locatedBy("//div[@class=\"x-tool x-tool-toggle x-tool-collapse-south\"]");



}
