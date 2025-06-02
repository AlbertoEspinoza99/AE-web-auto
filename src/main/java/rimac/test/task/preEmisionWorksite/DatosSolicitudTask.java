package rimac.test.task.preEmisionWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.interaction.Tab;
import rimac.test.userinterfaces.preEmisionWorksite.DatosSolicitudUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class DatosSolicitudTask implements Task {

    private final String solicitud;
    private final String nroSolicitud;
    private final String nroLote;
    private final String nroRegistro;
    private final String RazonSocial;
    private final String dependencia;
    private final String mesProducción;

    public DatosSolicitudTask(String solicitud, String nroSolicitud, String nroLote, String nroRegistro, String razonSocial, String dependencia, String mesProducción) {
        this.solicitud = solicitud;
        this.nroSolicitud = nroSolicitud;
        this.nroLote = nroLote;
        this.nroRegistro = nroRegistro;
        RazonSocial = razonSocial;
        this.dependencia = dependencia;
        this.mesProducción = mesProducción;
    }


    public static DatosSolicitudTask Dsoli(String solicitud,String nroSolicitud,String nroLote,String nroRegistro,String RazonSocial,String dependencia,String mesProducción){
        return Instrumented.instanceOf(DatosSolicitudTask.class).withProperties(solicitud,nroSolicitud,nroLote,nroRegistro,RazonSocial,dependencia,mesProducción);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        LocalDate fechaActual=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada=fechaActual.format(formato);


        actor.attemptsTo(
                WaitUntil.the(DatosSolicitudUI.INPUT_SOLICITUD,isVisible()).forNoMoreThan(26).seconds(),
                Pause.withDuration(2),
                Enter.theValue(solicitud).into(DatosSolicitudUI.INPUT_SOLICITUD),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosSolicitudUI.DINAMICO_SOLICITUD,solicitud),
                Pause.withDuration(1),
                Enter.theValue(nroSolicitud).into(DatosSolicitudUI.INPUT_NUMERO_SOLICITUD),
                Pause.withDuration(1),
                Enter.theValue(nroLote).into(DatosSolicitudUI.INPUT_LOTE),
                Pause.withDuration(1),
                Enter.theValue(nroRegistro).into(DatosSolicitudUI.INPUT_NUMERO_REGITRO),
                Pause.withDuration(1),
                Enter.theValue(fechaFormateada).into(DatosSolicitudUI.INPUT_FECHA_FIRMA),
                Click.on(DatosSolicitudUI.INPUT_RAZON_SOCIAL),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Enter.theValue(RazonSocial).into(DatosSolicitudUI.INPUT_RAZON_SOCIAL),
                Tab.key(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                Enter.theValue(dependencia).into(DatosSolicitudUI.INPUT_DEPENDENCIA),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosSolicitudUI.DINAMICO_DEPENDENCIA,dependencia),
                Pause.withDuration(1),
                Enter.theValue(mesProducción).into(DatosSolicitudUI.INPUT_MES_PRODUCCION),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosSolicitudUI.DINAMICO_MES_PRODUCCION,mesProducción),
                Pause.withDuration(2)

        );

    }



}
