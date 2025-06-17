package rimac.test.task.emisionVidaLeyCesante;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico2Parametros;
import rimac.test.userinterfaces.PolizaVidaLeyCesante.RenovacionCondiciones;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class RenovarCondicionesTask implements Task {

   private final String producto;
   private final String estadoInicial;


    public RenovarCondicionesTask(String producto, String estadoInicial) {
        this.producto = producto;
        this.estadoInicial = estadoInicial;
    }

   public static RenovarCondicionesTask renovar(String producto, String estadoInicial){
        return Instrumented.instanceOf(RenovarCondicionesTask.class).withProperties(producto,estadoInicial);
   }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                ClickDinamico2Parametros.clickDinamicos(RenovacionCondiciones.DINAMICO_SELECCION_PRODUCTO,producto,estadoInicial),
                WaitUntil.the(RenovacionCondiciones.BTN_RENOVAR_CONDICIONES,isVisible()).forNoMoreThan(90).seconds(),
                Click.on(RenovacionCondiciones.BTN_RENOVAR_CONDICIONES),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(RenovacionCondiciones.BTN_CONFIRMAR_RENOVACION,isVisible()).forNoMoreThan(100).seconds(),
                JavaScriptClick.on(RenovacionCondiciones.BTN_CONFIRMAR_RENOVACION),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(RenovacionCondiciones.BTN_CONFIRMAR_ADVERTENCIA,isVisible()).forNoMoreThan(120).seconds(),
                JavaScriptClick.on(RenovacionCondiciones.BTN_CONFIRMAR_ADVERTENCIA),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(RenovacionCondiciones.BTN_DOCUMENTOS,isVisible()).forNoMoreThan(120).seconds(),
                WaitUntil.the(RenovacionCondiciones.BTN_SIGUIENTE_ESTADO,isVisible()).forNoMoreThan(120).seconds(),
                WaitUntil.the(RenovacionCondiciones.BTN_DATOS_PARTICULARES,isVisible()).forNoMoreThan(120).seconds(),
                Click.on(RenovacionCondiciones.BTN_DATOS_PARTICULARES),
                WaitUntil.the(RenovacionCondiciones.LBL_COTIZACION,isVisible()).forNoMoreThan(120).seconds()
        );

        String valorCotizacion = RenovacionCondiciones.LBL_COTIZACION.resolveFor(actor).getValue().trim();


        Serenity.setSessionVariable("numeroCotizacionDeRenovacion").to(valorCotizacion);

    }



}
