package rimac.test.stepsdefinition.common;

import cucumber.api.java.en.Given;
import rimac.test.task.login.IniciarSesion;

import static rimac.test.stepsdefinition.hooks.Hooks.actor;

public class CommonSteps {

    @Given("^ingreso a la aplicacion web de SAS$")
    public void queIngresamosALaWebDeSAS(){


        actor.attemptsTo(

                IniciarSesion.conCredenciales()
        );

    };



}