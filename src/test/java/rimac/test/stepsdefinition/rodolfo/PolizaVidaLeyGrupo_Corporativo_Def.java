package rimac.test.stepsdefinition.rodolfo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import rimac.test.questions.polizaVidaLeyGrupo.ValidacionTransferenciaOK;
import rimac.test.task.emisionVidaLeyGrupo_Corporativo.*;

import static com.google.common.base.Predicates.equalTo;
import static rimac.test.stepsdefinition.hooks.Hooks.actor;

public class PolizaVidaLeyGrupo_Corporativo_Def {



    @And("^seleccion de plan y coberturas (.*),sumaAseguradaMN (.*),sumaAseguradaMA (.*),sumaAseguradaIP (.*)$")
    public void plan(String planes,String sumaAseguradaMN,String sumaAseguradaMA,String sumaAseguradaIP){
        actor.attemptsTo(
                PlanCoberturas_Corporativo_Task.planporcoberturas(planes,sumaAseguradaMN,sumaAseguradaMA,sumaAseguradaIP)
        );
    }


    @And("^registramos los datos particulares y ingresamos tipoVigencia (.*),PrimaMinEmision (.*),PrimaMinEndoso (.*),SueldoAsegurable (.*)$")
    public void datosParticulares(String tipoVigencia,String PrimaMinEmision,String PrimaMinEndoso,String SueldoAsegurable){

        actor.attemptsTo(
                DatosParticularesTask.DT(tipoVigencia,PrimaMinEmision,PrimaMinEndoso,SueldoAsegurable)
        );
    }


    @And("^renovamos vigencia la poliza del producto (.*) con estadoInicial (.*) y colocamos el tipo de vigencia (.*)$")
    public void renovacionesPoliza(String producto,String estadoInicial,String vigencia){

        actor.attemptsTo(
                RenovarTask.renovar(producto,estadoInicial,vigencia)
        );

    }


    @And("^registramos la planilla de asegurados del producto (.*) con estado (.*) y colocamos en el numero de tramite (.*) y en el excel colocamos el tipoProducto (.*)$")
    public void registroPlanillaAsegurado(String producto,String estado,String tramite,String tipoProducto){

        actor.attemptsTo(
                PlanillaAseguradosTask.asegurados(producto,estado,tramite,tipoProducto)
        );

    }


    @Then("^validamos que el estadoTransferencia (.*) del TipoMovimiento (.*) de la pestana del historial de movimientos$")
    public void estadoHistorialMovimiento(String estadoTransferencia,String TipoMovimiento){

        actor.should(
                GivenWhenThen.seeThat("valida el estado del movimiento",
                        ValidacionTransferenciaOK.valida(estadoTransferencia,TipoMovimiento),equalTo(true))
        );
    }



    @And("^registramos la planilla de asegurados para inclusion y/o exclusion certificado del producto (.*) con estado (.*) y colocamos en el numero de tramite (.*), el tipoProductoDes (.*) y en el excel colocamos el tipoProducto (.*)$")
    public void ExclusionInclusionCertificado(String producto,String estado,String tramite,String tipoProductoDes,String tipoProducto){
        actor.attemptsTo(
                InclusionExclusionCertificadoTask.asegurados(producto,estado,tramite,tipoProductoDes,tipoProducto)
        );

    }






}
