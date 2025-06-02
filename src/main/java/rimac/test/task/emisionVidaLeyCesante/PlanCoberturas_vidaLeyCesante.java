package rimac.test.task.emisionVidaLeyCesante;

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


import rimac.test.userinterfaces.PolizaVidaLeyCesante.buscarPlanCobertura_cesanteUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class PlanCoberturas_vidaLeyCesante implements Task {


    private final String plan_cesante;
    private final String sumaAseguradaMN_cesante;
    private final String sumaAseguradaMA_cesante;
    private final String sumaAseguradaIP_cesante;


    public PlanCoberturas_vidaLeyCesante(String plan_cesante, String sumaAseguradaMN_cesante, String sumaAseguradaMA_cesante, String sumaAseguradaIP_cesante) {
        this.plan_cesante = plan_cesante;
        this.sumaAseguradaMN_cesante = sumaAseguradaMN_cesante;
        this.sumaAseguradaMA_cesante = sumaAseguradaMA_cesante;
        this.sumaAseguradaIP_cesante = sumaAseguradaIP_cesante;
    }

    public static PlanCoberturas_vidaLeyCesante planporcoberturas_cesante(String plan_cesante, String sumaAseguradaMN_cesante, String sumaAseguradaMA_cesante, String sumaAseguradaIP_cesante){
        return Instrumented.instanceOf(PlanCoberturas_vidaLeyCesante.class).withProperties(plan_cesante,sumaAseguradaMN_cesante,sumaAseguradaMA_cesante,sumaAseguradaIP_cesante);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(buscarPlanCobertura_cesanteUI.INPUT_PLAN,isVisible()).forNoMoreThan(90).seconds(),
                Pause.withDuration(2),
                Enter.theValue(plan_cesante).into(buscarPlanCobertura_cesanteUI.INPUT_PLAN),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(buscarPlanCobertura_cesanteUI.DINAMICO_PLAN,plan_cesante),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2),
                JavaScriptClick.on(buscarPlanCobertura_cesanteUI.BTN_BUSCAR_PLANES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.BTN_VER_COBERTURAS,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCobertura_cesanteUI.BTN_VER_COBERTURAS),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),

                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.CHECK_COBERTURA_MUERTE_NATURAL,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCobertura_cesanteUI.CHECK_COBERTURA_MUERTE_NATURAL),
                Pause.withDuration(2),
                Click.on(buscarPlanCobertura_cesanteUI.BTN_SUMA_ASEGURADA_MUERTE_NATURAL),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_MUERTE_NATURAL,isVisible()).forNoMoreThan(90).seconds(),
                DoubleClick.on(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_MUERTE_NATURAL),
                Enter.theValue(sumaAseguradaMN_cesante).into(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_MUERTE_NATURAL),

                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.CHECK_COBERTURA_MUERTE_ACCIDENTAL,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCobertura_cesanteUI.CHECK_COBERTURA_MUERTE_ACCIDENTAL),
                Pause.withDuration(3),
                Click.on(buscarPlanCobertura_cesanteUI.BTN_SUMA_ASEGURADA_MUERTE_ACCIDENTAL),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL,isVisible()).forNoMoreThan(90).seconds(),
                DoubleClick.on(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL),
                Enter.theValue(sumaAseguradaMA_cesante).into(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_MUERTE_ACCIDENTAL),

                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.CHECK_COBERTURA_INVALIDEZ_TOTAL_PERMANENTE,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(buscarPlanCobertura_cesanteUI.CHECK_COBERTURA_INVALIDEZ_TOTAL_PERMANENTE),
                Pause.withDuration(3),
                Click.on(buscarPlanCobertura_cesanteUI.BTN_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE,isVisible()).forNoMoreThan(90).seconds(),
                DoubleClick.on(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE),
                Enter.theValue(sumaAseguradaIP_cesante).into(buscarPlanCobertura_cesanteUI.INPUT_SUMA_ASEGURADA_INVALIDEZ_TOTAL_PERMANENTE),

                Click.on(buscarPlanCobertura_cesanteUI.Lbl_VERSION),
                Pause.withDuration(1),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.BTN_GRABAR_SELECCIONADOS,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(buscarPlanCobertura_cesanteUI.BTN_GRABAR_SELECCIONADOS),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(3),
                JavaScriptClick.on(buscarPlanCobertura_cesanteUI.BTN_SALIR_VER_PLANES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(buscarPlanCobertura_cesanteUI.BTN_SALIR_PLANES,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(buscarPlanCobertura_cesanteUI.BTN_SALIR_PLANES),
                Pause.withDuration(4)





                );


    }



}
