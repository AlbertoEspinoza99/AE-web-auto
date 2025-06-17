package rimac.test.task.emisionPolizaWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico2Parametros;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.EmisionPolizaWORKSITE.ActivarPolizaUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class ActivarPolizaTask implements Task {

    private final String producto;
    private final String estadoModificado;

    public ActivarPolizaTask(String producto, String estadoModificado) {
        this.producto = producto;
        this.estadoModificado = estadoModificado;
    }

    public static ActivarPolizaTask activar(String producto, String estadoModificado){
        return Instrumented.instanceOf(ActivarPolizaTask.class).withProperties(producto,estadoModificado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(ActivarPolizaUI.BTN_ACTUALIZAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(ActivarPolizaUI.BTN_ACTUALIZAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                ClickDinamico2Parametros.clickDinamicos(ActivarPolizaUI.DINAMICO_SELECCION,producto,estadoModificado),
                WaitUntil.the(ActivarPolizaUI.BTN_EDITAR_ACTIVAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(ActivarPolizaUI.BTN_EDITAR_ACTIVAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(ActivarPolizaUI.BTN_ACTIVAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(ActivarPolizaUI.BTN_ACTIVAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(ActivarPolizaUI.BTN_CONFIRMAR_ACTIVACION_POLIZA,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(ActivarPolizaUI.BTN_CONFIRMAR_ACTIVACION_POLIZA),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(ActivarPolizaUI.BTN_ACTIVACION_EXITOSA,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(ActivarPolizaUI.BTN_ACTIVACION_EXITOSA),
                WaitUntil.the(ActivarPolizaUI.BTN_SALIR_EDITAR_POLIZA,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(ActivarPolizaUI.BTN_SALIR_EDITAR_POLIZA),
                Pause.withDuration(2)

        );
    }





}
