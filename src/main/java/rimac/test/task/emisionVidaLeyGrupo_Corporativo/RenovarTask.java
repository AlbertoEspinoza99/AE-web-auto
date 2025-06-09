package rimac.test.task.emisionVidaLeyGrupo_Corporativo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.ClickDinamico2Parametros;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyGrupo.RenovacionVigenciaUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class RenovarTask implements Task {


    private final String producto;
    private final String EstadoInical;
    private final String vigencia;

    public RenovarTask(String producto, String estadoInical, String vigencia) {
        this.producto = producto;
        EstadoInical = estadoInical;
        this.vigencia = vigencia;
    }

    public static RenovarTask renovar(String producto, String estadoInical, String vigencia){
        return Instrumented.instanceOf(RenovarTask.class).withProperties(producto,estadoInical,vigencia);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                ClickDinamico2Parametros.clickDinamicos(RenovacionVigenciaUI.DINAMICO_SELECCION_POLIZA,producto,EstadoInical),
                Pause.withDuration(2),
                JavaScriptClick.on(RenovacionVigenciaUI.BTN_RENOVAR_VIGENCIA),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(RenovacionVigenciaUI.BTN_CONFIRMAR_RENOVACION,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(RenovacionVigenciaUI.BTN_CONFIRMAR_RENOVACION),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(RenovacionVigenciaUI.INPUT_TIPO_VIGENCIA,isVisible()).forNoMoreThan(90).seconds(),
                Enter.theValue(vigencia).into(RenovacionVigenciaUI.INPUT_TIPO_VIGENCIA),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(RenovacionVigenciaUI.DINAMICO_TIPO_VIGENCIA,vigencia),
                Pause.withDuration(2),
                JavaScriptClick.on(RenovacionVigenciaUI.BTN_CONTINUAR_RENOVACION),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(RenovacionVigenciaUI.BTN_ACEPTAR_RENOVACION,isVisible()).forNoMoreThan(90).seconds(),
                JavaScriptClick.on(RenovacionVigenciaUI.BTN_ACEPTAR_RENOVACION),
                Pause.withDuration(3)
                );


    }



}
