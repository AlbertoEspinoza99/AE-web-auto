package rimac.test.task.terceros;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.Pause;
import rimac.test.task.utils.DblClickVisibleItemByXPath;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static rimac.test.userinterfaces.home.HomeUi.*;

public class BuscarModulo implements Task {

    private String modulo;
    private String subModuloA;
    private String subModuloB;
    private String transTercero;

    public BuscarModulo(String modulo, String subModuloA, String subModuloB, String transTercero) {
        this.modulo = modulo;
        this.subModuloA = subModuloA;
        this.subModuloB = subModuloB;
        this.transTercero = transTercero;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Pause.withDuration(5),
                WaitUntil.the(DIV_CERRAR_DESCRIPCION, WebElementStateMatchers.isEnabled()).forNoMoreThan(20).seconds(),
                Click.on(DIV_CERRAR_DESCRIPCION)
        );

        if (!"Producto".equals(modulo)) {
            System.out.println("Modulo no es 'Producto', realizando acciones adicionales.");
            actor.attemptsTo(
                    WaitUntil.the(LBL_MODULO.of(modulo), WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                    Click.on(LBL_MODULO.of(modulo))
            );
        } else {
            System.out.println("Modulo es 'Producto', omitiendo acciones adicionales.");
        }

        actor.attemptsTo(
                Pause.withDuration(2),
                DblClickVisibleItemByXPath.on(LBL_SUBMODULO_TERCEROS.of(subModuloA), 10),
                WaitUntil.the(LBL_SUBMODULO_TERCEROSB.of(subModuloB), WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                DoubleClick.on(LBL_SUBMODULO_TERCEROSB.of(subModuloB)),
                WaitUntil.the(LBL_SUBMODULO_TERCEROSB.of(transTercero), WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(LBL_SUBMODULO_TERCEROSB.of(transTercero))
        );

    }
    public static BuscarModulo enModulo(String modulo,String subModuloA,String subModuloB,String transTercero) {
        return instrumented(BuscarModulo.class, modulo,subModuloA,subModuloB,transTercero);
    }
}
