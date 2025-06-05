package rimac.test.stepsdefinition.common;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import rimac.test.task.login.IniciarSesion;
import rimac.test.task.utils.BusquedaTask;

import static rimac.test.stepsdefinition.hooks.Hooks.actor;

public class CommonSteps {

    @Given("^ingreso a la aplicacion web de SAS$")
    public void queIngresamosALaWebDeSAS(){


        actor.attemptsTo(

                IniciarSesion.conCredenciales()
        );

    };


    @And("Hacemos la busqueda general sin criterios de la poliza provisional (.*)")
    public void busquedaPoliza(String poliza){
       actor.attemptsTo(
               BusquedaTask.busqueda(poliza)
       );
    }



}