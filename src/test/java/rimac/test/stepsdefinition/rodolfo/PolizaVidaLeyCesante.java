package rimac.test.stepsdefinition.rodolfo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import rimac.test.questions.polizaVidaLeyCesante.EstadoCotizacion;
import rimac.test.questions.polizaVidaLeyCesante.TransferenciaOK;
import rimac.test.task.emisionVidaLeyCesante.ContinuidadyDtosParticulares;
import rimac.test.task.emisionVidaLeyCesante.PlanCoberturas_vidaLeyCesante;
import rimac.test.task.emisionVidaLeyCesante.RenovarCondicionesTask;

import static com.google.common.base.Predicates.equalTo;
import static rimac.test.stepsdefinition.hooks.Hooks.actor;
import static rimac.test.userinterfaces.PolizaVidaLeyCesante.EstadoTransferenciaOK.LBL_TRANSFERENCIA_OK;

public class PolizaVidaLeyCesante {




    @And("^escogemos los planes y coberutras (.*),sumaAseguradaMN (.*),sumaAseguradaMA (.*),sumaAseguradaIP (.*)$")
    public void plan(String planes,String sumaAseguradaMN,String sumaAseguradaMA,String sumaAseguradaIP){
        actor.attemptsTo(
                PlanCoberturas_vidaLeyCesante.planporcoberturas_cesante(planes,sumaAseguradaMN,sumaAseguradaMA,sumaAseguradaIP)
        );
    }

    @And("^registramos la  y datos particulares FechaCese tipoDOC (.*),numDOC (.*),ultimaRemuneracion (.*)$")
    public void Continuidad(String tipoDOC,String numDOC,String ultimaRemuneracion){
        actor.attemptsTo(
                ContinuidadyDtosParticulares.ConYPart(tipoDOC,numDOC,ultimaRemuneracion)
        );

    }


    @And("^Validamos que los movimientos este es estadoOk (.*)$")
    public void polizaEnEstadoOK(String estadoOk){
        actor.should(
                GivenWhenThen.seeThat("valida el estado del movimiento",
                        TransferenciaOK.validacion(LBL_TRANSFERENCIA_OK,estadoOk),equalTo(true)
                        )
        );

    }


    @And("^renovamos condiciones de la poliza del producto (.*) con estadoInicial (.*)$")
    public void renovacionCondiciones(String producto,String estadoInicial){

        actor.attemptsTo(
                RenovarCondicionesTask.renovar(producto,estadoInicial)
        );

    }


    @Then("^valido que la poliza con su  numero de cotizacion y con estado (.*)$")
    public void ValidamosElEstadoDelaPoliza(String estado){
      actor.should(
              GivenWhenThen.seeThat("validacion estado",
                      EstadoCotizacion.validacion(estado),equalTo(true))
      );
    }





















}
