package rimac.test.userinterfaces.PolizaVidaLeyCesante;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class buscarPlanCobertura_cesanteUI {

    public static final Target INPUT_PLAN=Target.the("INPUT_PLAN")
            .located(By.xpath("//input[@name='ideplanselected']/parent::div/input[2]"));

    public static final String DINAMICO_PLAN="//div[contains(text(),'{0}')]";

    public static final Target BTN_BUSCAR_PLANES=Target.the("BTN_BUSCAR_PLANES")
            .located(By.xpath("//input[@name='ideplanselected']/ancestor::div[6]/following::div[1]//button"));

    public static final Target BTN_VER_COBERTURAS=Target.the("BTN_VER_COBERTURAS")
            .located(By.xpath("(//div[contains(text(),'Plan Cesantes Nueva Ley')])[2]/parent::td/parent::tr/td[3]/div//img"));

    // muerte natural

    public static final Target CHECK_COBERTURA_MUERTE_NATURAL=Target.the("CHECK_COBERTURA_MUERTE_NATURAL")
            .located(By.xpath("//div[contains(text(),'Muerte Natural')]/parent::td/parent::tr/td[1]/div/div"));


    public static final Target BTN_SUMA_ASEGURADA_MUERTE_NATURAL=Target.the("BTN_SUMA_ASEGURADA_MUERTE_NATURAL")
            .located(By.xpath("//div[contains(text(),'Muerte Natural')]/parent::td/parent::tr/td[5]/div"));


    public static final Target INPUT_SUMA_ASEGURADA_MUERTE_NATURAL=Target.the("INPUT_SUMA_ASEGURADA_MUERTE_NATURAL")
            .located(By.xpath("(//input[@class='x-form-text x-form-field x-form-num-field x-form-focus'])[1]"));


    // muerte accidental

    public static final Target CHECK_COBERTURA_MUERTE_ACCIDENTAL=Target.the("CHECK_COBERTURA_MUERTE_ACCIDENTAL")
            .located(By.xpath("(//div[contains(text(),'Muerte Accidental')])[1]/parent::td/parent::tr/td[1]/div/div"));


    public static final Target BTN_SUMA_ASEGURADA_MUERTE_ACCIDENTAL=Target.the("BTN_SUMA_ASEGURADA_MUERTE_ACCIDENTAL")
            .located(By.xpath("(//div[contains(text(),'Muerte Accidental')])[1]/parent::td/parent::tr/td[5]/div"));

    public static final Target INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL=Target.the("INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL")
            .located(By.xpath("(//input[@class='x-form-text x-form-field x-form-num-field x-form-focus'])[1]"));


    // invalidez total y permanente por accidente

    public static final Target CHECK_COBERTURA_INVALIDEZ_TOTAL_PERMANENTE=Target.the("CHECK_COBERTURA_INVALIDEZ_TOTAL_PERMANENTE")
            .located(By.xpath("(//div[contains(text(),'Invalidez Total y Permanente por Accidente')])[1]/parent::td/parent::tr/td[1]/div/div"));


    public static final Target BTN_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE=Target.the("BTN_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE")
            .located(By.xpath("(//div[contains(text(),'Invalidez Total y Permanente por Accidente')])[1]/parent::td/parent::tr/td[5]/div"));


    public static final Target INPUT_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE=Target.the("INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL")
            .located(By.xpath("(//input[@class='x-form-text x-form-field x-form-num-field x-form-focus'])[1]"));



    //


    public static final Target BTN_GRABAR_SELECCIONADOS=Target.the("BTN_GRABAR_SELECCIONADOS")
            .located(By.xpath("//button[.='Grabar Seleccionados']"));

    public static final Target BTN_SALIR_VER_PLANES=Target.the("BTN_SALIR_VER_PLANES")
            .located(By.xpath("(//button[.='Salir'])[2]"));

    public static final Target BTN_SALIR_PLANES=Target.the("BTN_SALIR_PLANES")
            .located(By.xpath("(//button[.='Salir'])[1]"));


    public static final Target Lbl_VERSION=Target.the("Lbl_VERSION")
            .located(By.xpath("//input[@name='version']"));









}
