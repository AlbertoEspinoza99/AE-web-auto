package rimac.test.task.emisionPolizaWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.ClickDinamico2Parametros;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.EmisionPolizaWORKSITE.EditarCertificadoUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class EditarCertificadoTask implements Task {

    private final String producto;
    private final String estadoInicial;
    private final String endoso;


    public EditarCertificadoTask(String producto, String estadoInicial, String endoso) {
        this.producto = producto;
        this.estadoInicial = estadoInicial;
        this.endoso = endoso;
    }

    public static EditarCertificadoTask EditarCertificado(String producto, String estadoInicial, String endoso){
        return Instrumented.instanceOf(EditarCertificadoTask.class).withProperties(producto,estadoInicial,endoso);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickDinamico2Parametros.clickDinamicos(EditarCertificadoUI.DINAMICO_SELECCION,producto,estadoInicial),
                WaitUntil.the(EditarCertificadoUI.BTN_EDITAR,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EditarCertificadoUI.BTN_EDITAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(EditarCertificadoUI.BTN_CERTIFICADOS,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EditarCertificadoUI.BTN_CERTIFICADOS),
                Pause.withDuration(3),
                ClickDinamico.clickDinamicos(EditarCertificadoUI.DINAMICO_SELECCION_CERTIFICADO_01,producto),
                WaitUntil.the(EditarCertificadoUI.BTN_EDITAR_CERTIFICADO,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EditarCertificadoUI.BTN_EDITAR_CERTIFICADO),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(EditarCertificadoUI.BTN_ENDOSOS,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(EditarCertificadoUI.BTN_ENDOSOS),
                ClickDinamico.clickDinamicos(EditarCertificadoUI.DINAMICO_TIPO_ENDOSO,endoso),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(3)

        );

    }




}
