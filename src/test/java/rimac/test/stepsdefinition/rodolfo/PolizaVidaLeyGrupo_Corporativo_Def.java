package rimac.test.stepsdefinition.rodolfo;

import cucumber.api.java.en.And;
import rimac.test.task.emisionVidaLeyGrupo_Corporativo.DatosParticularesTask;
import rimac.test.task.emisionVidaLeyGrupo_Corporativo.PlanCoberturas_Corporativo_Task;

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


}
