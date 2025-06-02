package rimac.test.task.preEmisionWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.preEmisionWorksite.DatosGeneralesUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class DatosGeneralesTask implements Task {

    private final String canal;
    private final String vendedor;

    public DatosGeneralesTask(String canal, String vendedor) {
        this.canal = canal;
        this.vendedor = vendedor;
    }

    public static DatosGeneralesTask DG(String canal,String vendedor){
        return Instrumented.instanceOf(DatosGeneralesTask.class).withProperties(canal,vendedor);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DatosGeneralesUI.INPUT_CANAL,isVisible()).forNoMoreThan(25).seconds(),
                Pause.withDuration(3),
                Enter.theValue(canal).into(DatosGeneralesUI.INPUT_CANAL),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosGeneralesUI.DINAMICO_CANAL,canal),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2),
                WaitUntil.the(DatosGeneralesUI.INPUT_VENDEDOR,isVisible()).forNoMoreThan(25).seconds(),
                Enter.theValue(vendedor).into(DatosGeneralesUI.INPUT_VENDEDOR),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(DatosGeneralesUI.DINAMICO_VENDEDOR,vendedor),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2)
                
                );


    }


}
