package rimac.test.task.LoteEmisionVidaHiraoka;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.joda.time.format.DateTimeFormat;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.LoteEmisionVidaHiraoka.ConsultaUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class ConsultaTask implements Task {

    private final String canalNegocio;
    private final String producto;


    public ConsultaTask(String canalNegocio, String producto) {
        this.canalNegocio = canalNegocio;
        this.producto = producto;
    }


    public static ConsultaTask consulta(String canalNegocio, String producto){
        return Instrumented.instanceOf(ConsultaTask.class).withProperties(canalNegocio,producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        LocalDate fecha=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada=fecha.format(formato);

        actor.attemptsTo(
                WaitUntil.the(ConsultaUI.INPUT_CANAL_NEGOCIO,isVisible()).forNoMoreThan(90).seconds(),
                Pause.withDuration(2),
                Enter.theValue(canalNegocio).into(ConsultaUI.INPUT_CANAL_NEGOCIO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(ConsultaUI.DINAMICO_CANAL_NEGOCIO,canalNegocio),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                Enter.theValue(fechaFormateada).into(ConsultaUI.INPUT_CARGA_DESDE),
                Pause.withDuration(1),
                Enter.theValue(fechaFormateada).into(ConsultaUI.INPUT_CARGA_HASTA),
                Pause.withDuration(1),
                Enter.theValue(producto).into(ConsultaUI.INPUT_PRODUCTO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(ConsultaUI.DINAMICO_PRODUCTO,producto),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                JavaScriptClick.on(ConsultaUI.BTN_BUSCAR),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1)

                );


    }



}
