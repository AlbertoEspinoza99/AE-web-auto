package rimac.test.task.emisionVidaLeyGrupo_Corporativo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyGrupo.buscarPlanCoberturaUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class PlanCoberturas_Corporativo_Task implements Task {


    private final String plan;
    private final String sumaAseguradaMN;
    private final String sumaAseguradaMA;
    private final String sumaAseguradaIP;


    public PlanCoberturas_Corporativo_Task(String plan, String sumaAseguradaMN, String sumaAseguradaMA, String sumaAseguradaIP) {
        this.plan = plan;
        this.sumaAseguradaMN = sumaAseguradaMN;
        this.sumaAseguradaMA = sumaAseguradaMA;
        this.sumaAseguradaIP = sumaAseguradaIP;
    }

    public static PlanCoberturas_Corporativo_Task planporcoberturas(String plan,String sumaAseguradaMN,String sumaAseguradaMA,String sumaAseguradaIP){
        return Instrumented.instanceOf(PlanCoberturas_Corporativo_Task.class).withProperties(plan,sumaAseguradaMN,sumaAseguradaMA,sumaAseguradaIP);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(buscarPlanCoberturaUI.INPUT_PLAN,isVisible()).forNoMoreThan(90).seconds(),
                Pause.withDuration(2),
                Enter.theValue(plan).into(buscarPlanCoberturaUI.INPUT_PLAN),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(buscarPlanCoberturaUI.DINAMICO_PLAN,plan),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2),
                JavaScriptClick.on(buscarPlanCoberturaUI.BTN_BUSCAR_PLANES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCoberturaUI.BTN_VER_COBERTURAS,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCoberturaUI.BTN_VER_COBERTURAS),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),

                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCoberturaUI.CHECK_COBERTURA_MUERTE_NATURAL,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCoberturaUI.CHECK_COBERTURA_MUERTE_NATURAL),
                Pause.withDuration(1),
                Click.on(buscarPlanCoberturaUI.BTN_SUMA_ASEGURADA_MUERTE_NATURAL),
                WaitUntil.the(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_MUERTE_NATURAL,isVisible()).forNoMoreThan(90).seconds(),
                DoubleClick.on(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_MUERTE_NATURAL),
                Enter.theValue(sumaAseguradaMN).into(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_MUERTE_NATURAL),

                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCoberturaUI.CHECK_COBERTURA_MUERTE_ACCIDENTAL,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCoberturaUI.CHECK_COBERTURA_MUERTE_ACCIDENTAL),
                Pause.withDuration(1),
                Click.on(buscarPlanCoberturaUI.BTN_SUMA_ASEGURADA_MUERTE_ACCIDENTAL),
                WaitUntil.the(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL,isVisible()).forNoMoreThan(90).seconds(),
                DoubleClick.on(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL),
                Enter.theValue(sumaAseguradaMA).into(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL),

                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCoberturaUI.CHECK_COBERTURA_INVALIDEZ_TOTAL_PERMANENTE,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCoberturaUI.CHECK_COBERTURA_INVALIDEZ_TOTAL_PERMANENTE),
                Pause.withDuration(1),
                Click.on(buscarPlanCoberturaUI.BTN_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE),
                WaitUntil.the(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE,isVisible()).forNoMoreThan(90).seconds(),
                DoubleClick.on(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE),
                Enter.theValue(sumaAseguradaIP).into(buscarPlanCoberturaUI.INPUT_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE),

                Click.on(buscarPlanCoberturaUI.Lbl_VERSION),
                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCoberturaUI.BTN_GRABAR_SELECCIONADOS,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(buscarPlanCoberturaUI.BTN_GRABAR_SELECCIONADOS),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                JavaScriptClick.on(buscarPlanCoberturaUI.BTN_SALIR_VER_PLANES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(buscarPlanCoberturaUI.BTN_SALIR_PLANES,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(buscarPlanCoberturaUI.BTN_SALIR_PLANES),
                Pause.withDuration(4)





                );


    }



}
