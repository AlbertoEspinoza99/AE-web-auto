@Scenario17y18
Feature: generacion poliza vida ley activo


  Background:
    Given ingreso a la aplicacion web de SAS

  @Scenario17
  Scenario Outline:  generar cotizacion
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Registrar Cotización"
    And en la sección datos de cabecera se ingrese rol <rol> , Canal <canal> , Grupo <grupo>, Producto <producto>, Moneda <moneda>
    And registro un cliente con Tipo de Documento TipoDocumento <TipoDocumento>, NumeroDeDocumento <NumeroDocumento>
    And registro los datos particulares y ingresamos la PrimaMinima <prima minima>
    And registro de riesgos y rellenamos el formulario TipoRiesgo <TipoRiesgo> , NumeroAsegurado <NumeroAsegurado> , MontoPlanillaMensual <MontoPlanillaMensual>
    And pasamos al siguiente estado Por aprobar <porAprobar>
    #And pasamos al siguiente estado aprobada <aprobada>
    And pasamos al siguiente estado generar poliza <PolizaGenerada>
    Then valido que la poliza este en estado <generado>
    And validamos que la poliza en acsele en estado cotizada <cotizada>

    Examples:
      | rol        | canal            | grupo    | producto         | moneda       | TipoDocumento | NumeroDocumento | prima minima | TipoRiesgo | NumeroAsegurado | MontoPlanillaMensual | porAprobar | aprobada       | PolizaGenerada | generado |cotizada |
      | CORREDORES | SEGUROS DIRECTOS | VIDA LEY | Vida Ley Activos | NUEVOS SOLES | RUC           | 20288916528     | 2000         | Empleados  | 1               | 2000                 | POR APROBAR|    APROBADA    | GENERAR PÓLIZA | Generado | Cotizada|

  @Scenario18
  Scenario Outline: emision poliza
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Mantenimiento Póliza"
    And Nos dirigimos a la opcion de Mantenimiento Poliza y consultamos la poliza
    And agregamos una sucursal tramite <tramite>,tipoProducto <tipoProducto>
    Then validamos que la poliza este en estado transferida <transferidad>
    And validamos que la poliza en acsele en estado cotizada <cotizada>

    Examples:
      |tramite| transferidad   | cotizada | tipoProducto|
      | 153   | TRANSFERIDO OK |  Cotizada|    VL       |
