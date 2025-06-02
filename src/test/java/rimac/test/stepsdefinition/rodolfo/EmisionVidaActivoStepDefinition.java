package rimac.test.stepsdefinition.rodolfo;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import rimac.test.questions.polizaVidaLeyActivo.NumeroPolizaGenerado;
import rimac.test.questions.polizaVidaLeyActivo.ValidacionEstadoTransferida;
import rimac.test.questions.polizaVidaLeyActivo.ValidarEstadoCotizada;
import rimac.test.task.emisionVidaLeyActivo.*;
import rimac.test.task.terceros.BuscarModulo;
import rimac.test.utils.UtilApp;

import static com.google.common.base.Predicates.equalTo;
import static rimac.test.stepsdefinition.hooks.Hooks.actor;
import static rimac.test.userinterfaces.PolizaVidaLeyActivo.ValidacionFinalUI.DIV_VALIDACION_ESTADO;
import static rimac.test.userinterfaces.PolizaVidaLeyActivo.ValidacionUI.BTN_VALIDACION_POLIZA_GENERADO;

public class EmisionVidaActivoStepDefinition {


    @When("^estoy logeado e ingreso en la opción \"([^\"]*)\" --> \"([^\"]*)\" --> \"([^\"]*)\" --> \"([^\"]*)\"$")
    public void queEstoyLogeadoEIngresoEnLaOpción(String modulo, String subModuloTerceros, String subModuloTercerosB, String transTercero) throws Throwable {
        actor.attemptsTo(
                BuscarModulo.enModulo(modulo,subModuloTerceros,subModuloTercerosB,transTercero)
        );
    }

    @And("^en la sección datos de cabecera se ingrese rol (.*) , Canal (.*) , Grupo (.*), Producto (.*), Moneda (.*)$")
    public void registroDatosGenerales(String rol ,String canal,String grupo,String producto,String moneda){
        actor.attemptsTo(
                DatosGeneralesTask.datosGenerales(rol,canal,grupo,producto,moneda)
        );
    }

    @And("^registro un cliente con Tipo de Documento TipoDocumento (.*), NumeroDeDocumento (.*)$")
    public void registroCliente(String TipoDocumento,String NumeroDeDocumento){
        actor.attemptsTo(
                Cliente.agregarCliente(TipoDocumento,NumeroDeDocumento)
        );
    }

    @And("^registro los datos particulares y ingresamos la PrimaMinima (.*)$")
    public void registroDatosParticulares(String PrimaMinima){
        actor.attemptsTo(
                DatosParticulares.RellenarDT(PrimaMinima)
        );
    }

    @And("^registro de riesgos y rellenamos el formulario TipoRiesgo (.*) , NumeroAsegurado (.*) , MontoPlanillaMensual (.*)$")
    public void registroDeRiesgo(String TipoRiesgo,String NumeroAsegurado,String MontoPlanillaMensual) {
        actor.attemptsTo(
                RiesgosTask.riesgos(TipoRiesgo,NumeroAsegurado,MontoPlanillaMensual)
        );
    }

    @And("^pasamos al siguiente estado Por aprobar (.*)$")
    public void PorAprobar(String estado){
        actor.attemptsTo(
                SIguienteEstadoTask.siguienteEstado(estado)
        );
    }


    @And("^pasamos al siguiente estado aprobada (.*)$")
    public void EstadoAprobado(String estado){
        actor.attemptsTo(
                SIguienteEstadoAPROBADATask.siguienteEstado(estado)
        );
    }


    @And("^pasamos al siguiente estado generar poliza (.*)$")
    public void GeneroPoliza(String estado){
        actor.attemptsTo(
                SIguienteEstadoGENEROPOLIZATask.siguienteEstado(estado)
        );
    }

    @Then("^valido que la poliza este en estado (.*)$")
    public void ValidarElEstado(String estado){
        actor.should(
                GivenWhenThen.seeThat("se valida que el estado este generado",
                        NumeroPolizaGenerado.validacion(BTN_VALIDACION_POLIZA_GENERADO,estado),equalTo(true))
        );
    }


    @And("^validamos que la poliza en acsele en estado cotizada (.*)$")
    public void validamosEnAcseleEstadoCOTIZADA(String cotizada){

        String polizacompleta= UtilApp.getJsonValue("src/test/resources/jsonData/PolizaVidaLeyActivo.json","$['NumeroPoliza']");
        String soloPoliza=polizacompleta.substring(polizacompleta.indexOf("|") + 1);

        actor.should(
                GivenWhenThen.seeThat("se valida el estado",
                        ValidarEstadoCotizada.EstadoSql(soloPoliza),equalTo(cotizada)
                )
        );
    }


    @And("Nos dirigimos a la opcion de Mantenimiento Poliza y consultamos la poliza")
    public void consultarPoliza(){
        actor.attemptsTo(
                ConsultaPolizaTask.consulta()
        );
    }

    @And("^agregamos una sucursal tramite (.*),tipoProducto (.*)$")
    public void sucursal(String tramite,String tipoProducto){
        actor.attemptsTo(
                AgregarSucursalTask.Sucursal(tramite,tipoProducto)
        );
    }

    @Then("^validamos que la poliza este en estado transferida (.*)$")
    public void PolizaEstadoTRASFERIDAok(String transferida){
        actor.should(
                GivenWhenThen.seeThat( "validacion del estado transferida",
                        ValidacionEstadoTransferida.VLtransferencia(DIV_VALIDACION_ESTADO),equalTo(transferida)
                )
        );
    }




}