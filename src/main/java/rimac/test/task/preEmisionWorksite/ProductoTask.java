package rimac.test.task.preEmisionWorksite;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rimac.test.interaction.ClickDinamico;
import rimac.test.interaction.DoubleClickDinamico;
import rimac.test.interaction.Pause;
import rimac.test.userinterfaces.preEmisionWorksite.ProductosUI;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static rimac.test.userinterfaces.constantes.RegistrarCotizacionUi.PATH_CARGANDO;

public class ProductoTask implements Task {

    private final String producto;
    private final String plan;
    private final String TipoPlan;
    private final String fraccionamiento;

    public ProductoTask(String producto, String plan, String tipoPlan, String fraccionamiento) {
        this.producto = producto;
        this.plan = plan;
        TipoPlan = tipoPlan;
        this.fraccionamiento = fraccionamiento;
    }

    public static ProductoTask producto(String producto,String plan,String TipoPlan,String fraccionamiento){
     return Instrumented.instanceOf(ProductoTask.class).withProperties(producto,plan,TipoPlan,fraccionamiento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(ProductosUI.BTN_CONFIRMAR_PRODUCTOS,isVisible()).forNoMoreThan(26).seconds(),
                ClickDinamico.clickDinamicos(ProductosUI.CHECKBOX_SELECCION_PRODUCTO,producto),
                Pause.withDuration(1),
                DoubleClickDinamico.clickDinamicos(ProductosUI.BTN_SELECCION_PRODUCTO,producto),
                WaitUntil.the(ProductosUI.INPUT_PLAN,isVisible()).forNoMoreThan(26).seconds(),
                Enter.theValue(plan).into(ProductosUI.INPUT_PLAN),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(ProductosUI.DINAMICO_PLAN,plan),
                WaitUntil.the(PATH_CARGANDO, WebElementStateMatchers.isNotVisible()).forNoMoreThan(300).seconds(),
                Pause.withDuration(1),
                Enter.theValue(TipoPlan).into(ProductosUI.INPUT_TIPO_PLAN),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(ProductosUI.DINAMICO_TIPO_PLAN,TipoPlan),
                Pause.withDuration(1),
                Enter.theValue(fraccionamiento).into(ProductosUI.INPUT_FRACCIONAMIENTO),
                Pause.withDuration(2),
                ClickDinamico.clickDinamicos(ProductosUI.DINAMICO_FRACCIONAMIENTO,fraccionamiento),
                Pause.withDuration(1),
                JavaScriptClick.on(ProductosUI.BTN_GRABAR_PRODUCTO),
                Pause.withDuration(1),
                JavaScriptClick.on(ProductosUI.BTN_CONFIRMAR_PRODUCTOS)

                );
    }


}
