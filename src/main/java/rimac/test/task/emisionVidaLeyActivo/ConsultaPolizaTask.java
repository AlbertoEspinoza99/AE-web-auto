package rimac.test.task.emisionVidaLeyActivo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.Pause;
import rimac.test.interaction.PegadoJS;
import rimac.test.userinterfaces.PolizaVidaLeyActivo.EmisionUI;
import rimac.test.utils.UtilApp;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class ConsultaPolizaTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        String nroPoliza = UtilApp.getJsonValue("src/test/resources/jsonData/PolizaVidaLeyActivo.json","$['NumeroPoliza']");

        actor.attemptsTo(

               // WaitUntil.the(EmisionUI.BTN_MANTENIMIENTO_POLIZA,isVisible()).forNoMoreThan(20).seconds(),
               // JavaScriptClick.on(EmisionUI.BTN_MANTENIMIENTO_POLIZA),
               // WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(EmisionUI.INPUT_NUMERO_POLIZA,isVisible()).forNoMoreThan(20).seconds(),
                Pause.withDuration(2),
                 PegadoJS.pegar(EmisionUI.INPUT_NUMERO_POLIZA,nroPoliza),
                //PegadoJS.pegar(EmisionUI.INPUT_NUMERO_POLIZA,"4315|63073928"),
                Pause.withDuration(2),
                JavaScriptClick.on(EmisionUI.BTN_BUSCAR_NUMERO_POLIZA),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2)

                );


    }

    public static ConsultaPolizaTask consulta(){
        return instrumented(ConsultaPolizaTask.class);
    }



}
