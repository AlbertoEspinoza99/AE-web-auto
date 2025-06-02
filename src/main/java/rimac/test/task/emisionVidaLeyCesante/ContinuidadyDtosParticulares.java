package rimac.test.task.emisionVidaLeyCesante;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyCesante.continuidadUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class ContinuidadyDtosParticulares implements Task {


    private final String tipoDOC;
    private final String numDOC;
    private final String ultimaRemuneracion;


    public ContinuidadyDtosParticulares(String tipoDOC, String numDOC, String ultimaRemuneracion) {
        this.tipoDOC = tipoDOC;
        this.numDOC = numDOC;
        this.ultimaRemuneracion = ultimaRemuneracion;
    }

    public static ContinuidadyDtosParticulares ConYPart(String tipoDOC, String numDOC, String ultimaRemuneracion){
        return Instrumented.instanceOf(ContinuidadyDtosParticulares.class).withProperties(tipoDOC,numDOC,ultimaRemuneracion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        /*
        LocalDate fecha=LocalDate.now();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechFormateada=fecha.format(format);
        */

        actor.attemptsTo(

                WaitUntil.the(continuidadUI.BTN_CONTINUIDAD,isVisible()).forNoMoreThan(90).seconds(),
                WaitUntil.the(continuidadUI.INPUT_FECHA_CESE,isVisible()).forNoMoreThan(90).seconds(),
                WaitUntil.the(continuidadUI.BTN_FECHA,isVisible()).forNoMoreThan(90).seconds(),

                JavaScriptClick.on(continuidadUI.BTN_FECHA),
                WaitUntil.the(continuidadUI.BTN_SELECCION_FECHA_ACTUAL,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(continuidadUI.BTN_SELECCION_FECHA_ACTUAL),

                Pause.withDuration(2),
                WaitUntil.the(continuidadUI.BTN_AGREGAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(continuidadUI.BTN_AGREGAR),

                WaitUntil.the(continuidadUI.INPUT_TIPO_DOCUMENTO,isVisible()).forNoMoreThan(90).seconds(),
                Enter.theValue(tipoDOC).into(continuidadUI.INPUT_TIPO_DOCUMENTO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(continuidadUI.DINAMICO_TIPO_DOCUMENTO,tipoDOC),
                WaitUntil.the(continuidadUI.INPUT_NUMERO_DOCUMENTO,isVisible()).forNoMoreThan(90).seconds(),
                Enter.theValue(numDOC).into(continuidadUI.INPUT_NUMERO_DOCUMENTO),
                JavaScriptClick.on(continuidadUI.BTN_BUSCAR_CLIENTE),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2),
                Click.on(continuidadUI.BTN_SELECCION_RESULTADO),
                Pause.withDuration(2),
                JavaScriptClick.on(continuidadUI.BTN_SELECCIONAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2),
                WaitUntil.the(continuidadUI.BTN_VALIDAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(continuidadUI.BTN_VALIDAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(continuidadUI.BTN_ACEPTAR_NO_CONTINUIDAD,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(continuidadUI.BTN_ACEPTAR_NO_CONTINUIDAD),
                WaitUntil.the(continuidadUI.INPUT_ULTIMA_REMUNERACION,isVisible()).forNoMoreThan(90).seconds(),
                Enter.theValue(ultimaRemuneracion).into(continuidadUI.INPUT_ULTIMA_REMUNERACION),
                Pause.withDuration(2),
                WaitUntil.the(continuidadUI.BTN_GRABAR_DATOS_PARTICULARES,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(continuidadUI.BTN_GRABAR_DATOS_PARTICULARES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2)

                );

    }


}
