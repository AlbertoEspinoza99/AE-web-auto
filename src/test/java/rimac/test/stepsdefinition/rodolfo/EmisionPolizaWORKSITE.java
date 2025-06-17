package rimac.test.stepsdefinition.rodolfo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import rimac.test.questions.PolizaWorksite.ValidacionEstado;
import rimac.test.task.emisionPolizaWorksite.ActivarPolizaTask;
import rimac.test.task.emisionPolizaWorksite.ConsultaWorksiteTask;
import rimac.test.task.emisionPolizaWorksite.EditarCertificadoTask;
import rimac.test.task.emisionPolizaWorksite.EndosoMedioCobroTask;

import static com.google.common.base.Predicates.equalTo;
import static rimac.test.stepsdefinition.hooks.Hooks.actor;

public class EmisionPolizaWORKSITE {

    @And("^hacemos la busqueda de solicitudes: solicitud (.*),NroSolicitud (.*)$")
    public void busquedaSolicitud(String solicitud,String NroSolicitud){
        actor.attemptsTo(
                ConsultaWorksiteTask.consultaWorksite(solicitud,NroSolicitud)
        );
    }







    // ENDOSO CAMBIO DE COBRO

    @And("^seleccionamos el producto (.*) con estado (.*) y nos dirigimos a editar certificado y realizamos el siguiente endoso (.*)$")
    public void editarCertificado(String producto,String estado,String endoso){

        actor.attemptsTo(
                EditarCertificadoTask.EditarCertificado(producto,estado,endoso)
        );
    }


    @And("^realizamos el endoso cambio de la forma de pago (.*)$")
    public void endosoCambioDePago(String Formapago){

        actor.attemptsTo(
                EndosoMedioCobroTask.endoso(Formapago)
        );
    }


    @And("^activamos la poliza del producto (.*) con estado (.*)$")
    public void activamosLaPoliza(String producto,String estado){

        actor.attemptsTo(
                ActivarPolizaTask.activar(producto,estado)
        );
    }


    @Then("^validamos que la poliza del (.*) este en estado (.*)$")
    public void validacionEstadoPoliza(String producto,String estado){

        actor.should(
                GivenWhenThen.seeThat("validacion estado Ensodo forma de pago",
                        ValidacionEstado.validacion(producto,estado),equalTo(true))
        );
    }




}
