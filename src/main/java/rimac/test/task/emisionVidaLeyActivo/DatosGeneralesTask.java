package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.DatosGeneralesUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class DatosGeneralesTask implements Task {

    private final String rol;
    private final String canal;
    private  final String grupo;
    private  final String producto;
    private  final String moneda;

    public DatosGeneralesTask(String rol, String canal, String grupo, String producto, String moneda) {
        this.rol = rol;
        this.canal = canal;
        this.grupo = grupo;
        this.producto = producto;
        this.moneda = moneda;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(DatosGeneralesUI.INPUT_ROL,isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(rol).into(DatosGeneralesUI.INPUT_ROL),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosGeneralesUI.DINAMICO_ROL,rol),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(DatosGeneralesUI.INPUT_CANAL,isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(canal).into(DatosGeneralesUI.INPUT_CANAL),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosGeneralesUI.DINAMICO_CANAL,canal),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(5),
                WaitUntil.the(DatosGeneralesUI.INPUT_GRUPO,isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(grupo).into(DatosGeneralesUI.INPUT_GRUPO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosGeneralesUI.DINAMICO_GRUPO,grupo),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                WaitUntil.the(DatosGeneralesUI.INPUT_PRODUCTO,isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(producto).into(DatosGeneralesUI.INPUT_PRODUCTO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosGeneralesUI.DINAMICO_PRODUCTO,producto),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(DatosGeneralesUI.INPUT_MONEDA,isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(moneda).into(DatosGeneralesUI.INPUT_MONEDA),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosGeneralesUI.DINAMICO_MONEDA,moneda),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(900).seconds(),
                Pause.withDuration(4)
        );

    }

    public static DatosGeneralesTask datosGenerales(String rol,String canal,String grupo,String producto,String moneda){
        return Instrumented.instanceOf(DatosGeneralesTask.class).withProperties(rol,canal,grupo,producto,moneda);
    }


}
