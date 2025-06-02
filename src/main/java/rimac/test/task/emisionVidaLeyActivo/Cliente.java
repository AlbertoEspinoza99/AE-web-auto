package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.ClienteUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class Cliente implements Task {

    String tipoDocumento;
    String numeroDocumento;

    public Cliente(String tipoDocumento, String numeroDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Target btn_original=ClienteUI.BTN_AGREGAR_CLIENTE;
        //Target btn_ley_cesante=ClienteUI.BTN_AGREGAR_CLIENTE_DOS;

        if (btn_original.resolveFor(actor).isCurrentlyVisible() && btn_original.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    WaitUntil.the(ClienteUI.BTN_AGREGAR_CLIENTE,isVisible()).forNoMoreThan(20).seconds(),
                    JavaScriptClick.on(ClienteUI.BTN_AGREGAR_CLIENTE)
            );
        }else {
            actor.attemptsTo(
                    WaitUntil.the(ClienteUI.BTN_AGREGAR_CLIENTE_DOS,isVisible()).forNoMoreThan(20).seconds(),
                    JavaScriptClick.on(ClienteUI.BTN_AGREGAR_CLIENTE_DOS)
            );
        }
        actor.attemptsTo(
                WaitUntil.the(ClienteUI.INPUT_TIPO_DOCUMENTO,isVisible()).forNoMoreThan(26).seconds(),
                Enter.theValue(tipoDocumento).into(ClienteUI.INPUT_TIPO_DOCUMENTO),
                Pause.withDuration(3),
                ClickDinamico.clickDinamicos(ClienteUI.DINAMICO_TIPO_DOCUMENTO,tipoDocumento),
                Pause.withDuration(3),
                WaitUntil.the(ClienteUI.INPUT_NUMERO_DOCUMENTO,isVisible()).forNoMoreThan(50).seconds(),
                Enter.theValue(numeroDocumento).into(ClienteUI.INPUT_NUMERO_DOCUMENTO),
                Pause.withDuration(3),
                WaitUntil.the(ClienteUI.BTN_BUSCAR_CLIENTE,isVisible()).forNoMoreThan(16).seconds(),
                JavaScriptClick.on(ClienteUI.BTN_BUSCAR_CLIENTE),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds()

        );
        //dni

        Target seleccionOriginal=ClienteUI.BTN_RESULTADO_CLIENTE;

        if (seleccionOriginal.resolveFor(actor).isCurrentlyEnabled() && seleccionOriginal.resolveFor(actor).isCurrentlyVisible()){
            actor.attemptsTo(
                    WaitUntil.the(ClienteUI.BTN_RESULTADO_CLIENTE,isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(ClienteUI.BTN_RESULTADO_CLIENTE),
                    Pause.withDuration(2)
            );
        }else {
            actor.attemptsTo(
                    WaitUntil.the(ClienteUI.BTN_RESULTADO_CLIENTE_DOS,isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(ClienteUI.BTN_RESULTADO_CLIENTE_DOS),
                    Pause.withDuration(2)
            );
        }





        Target ubicacion=ClienteUI.BTN_SELECCIONAR_CLIENTE;
        Target ubicacion2=ClienteUI.BTN_SELECCIONAR_CLIENTE_DOS;

        if (ubicacion.resolveFor(actor).isCurrentlyVisible() && ubicacion.resolveFor(actor).isCurrentlyEnabled()){
            actor.attemptsTo(
                    JavaScriptClick.on(ClienteUI.BTN_SELECCIONAR_CLIENTE)
            );

        }else if (ubicacion2.resolveFor(actor).isCurrentlyVisible() && ubicacion2.resolveFor(actor).isCurrentlyEnabled()) {
            actor.attemptsTo(
                    JavaScriptClick.on(ClienteUI.BTN_SELECCIONAR_CLIENTE_DOS)
            );
        }

        actor.attemptsTo(

                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(4)
        );




    }

    public static Cliente agregarCliente(String tipoDocumento,String numeroDocumento){
        return Instrumented.instanceOf(Cliente.class).withProperties(tipoDocumento,numeroDocumento);
    }


}
