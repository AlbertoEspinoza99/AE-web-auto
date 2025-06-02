package rimac.test.stepsdefinition.rodolfo;

import cucumber.api.java.en.And;
import rimac.test.task.LoteEmisionVidaHiraoka.ConsultaTask;

import static rimac.test.stepsdefinition.hooks.Hooks.actor;

public class LoteEmisionVidaHiraoka {


    @And("^rellenamos los datos de busqueda CanalNegocio (.*),Producto (.*)$")
    public void rellenamosLosDatos(String CanalNegocio,String Productod){
         actor.attemptsTo(
                 ConsultaTask.consulta(CanalNegocio,Productod)
         );
    }












}
