package rimac.test.stepsdefinition.rodolfo;

import cucumber.api.java.en.And;
import rimac.test.task.emisionPolizaWorksite.ConsultaWorksiteTask;

import static rimac.test.stepsdefinition.hooks.Hooks.actor;

public class EmisionPolizaWORKSITE {

    @And("^hacemos la busqueda de solicitudes: solicitud (.*),NroSolicitud (.*)$")
    public void busquedaSolicitud(String solicitud,String NroSolicitud){
        actor.attemptsTo(
                ConsultaWorksiteTask.consultaWorksite(solicitud,NroSolicitud)
        );
    }

}
