package rimac.test.task.preEmisionWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.preEmisionWorksite.TitulasUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class TitularTask implements Task {


    private final String dni;
    private final String codigoEmpleado;

    public TitularTask(String dni, String codigoEmpleado) {
        this.dni = dni;
        this.codigoEmpleado = codigoEmpleado;
    }

    public static TitularTask Titular(String dni,String codigoEmpleado){
        return Instrumented.instanceOf(TitularTask.class).withProperties(dni,codigoEmpleado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TitulasUI.INPUT_DNI, isVisible()).forNoMoreThan(26).seconds(),
                Enter.theValue(dni).into(TitulasUI.INPUT_DNI),
                Pause.withDuration(2),
                JavaScriptClick.on(TitulasUI.BTN_BUSCAR_USUARIO),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(2),
                Enter.theValue(codigoEmpleado).into(TitulasUI.INPUT_COD_EMPLEADO),
                Pause.withDuration(1)

        );

    }


    }














