package rimac.test.task.emisionPolizaWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.EmisionPolizaWORKSITE.Consulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class ConsultaWorksiteTask implements Task {

    private final String solicitud;
   private final String NumeroSolicitud;


    public ConsultaWorksiteTask(String solicitud, String numeroSolicitud) {
        this.solicitud = solicitud;
        NumeroSolicitud = numeroSolicitud;
    }

    public static ConsultaWorksiteTask consultaWorksite(String solicitud, String numeroSolicitud){
        return Instrumented.instanceOf(ConsultaWorksiteTask.class).withProperties(solicitud,numeroSolicitud);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        LocalDate fecha=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String FechaFormateada=fecha.format(formato);

        actor.attemptsTo(

                WaitUntil.the(Consulta.INPUT_SOLICITUD,isVisible()).forNoMoreThan(90).seconds(),
                Pause.withDuration(2),
                Enter.theValue(solicitud).into(Consulta.INPUT_SOLICITUD),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(Consulta.DINAMICO_SOLICITUD,solicitud),
                Pause.withDuration(1),
                Enter.theValue(NumeroSolicitud).into(Consulta.INPUT_NUMERO_DE_SERVICIO),
                Pause.withDuration(1),
                Enter.theValue(FechaFormateada).into(Consulta.INPUT_FECHA_SOLICITUD),
                Pause.withDuration(1),
                Enter.theValue(FechaFormateada).into(Consulta.INPUT_HASTA),
                Pause.withDuration(1),
                JavaScriptClick.on(Consulta.BTN_BUSCAR_POLIZA),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1)


        );

    }


}
