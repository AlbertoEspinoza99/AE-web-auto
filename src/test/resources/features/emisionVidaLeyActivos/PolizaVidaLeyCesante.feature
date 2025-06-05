@Scenario22
Feature: generacion poliza vida ley cesante


  Background:
    Given ingreso a la aplicacion web de SAS

  @Scenario22 #@SASoci
  Scenario Outline:  generar cotizacion
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Registrar Cotización"
    And en la sección datos de cabecera se ingrese rol <rol> , Canal <canal> , Grupo <grupo>, Producto <producto>, Moneda <moneda>
    And escogemos los planes y coberutras <planes>,sumaAseguradaMN <sumaAseguradaMN>,sumaAseguradaMA <sumaAseguradaMA>,sumaAseguradaIP <sumaAseguradaIP>
    And registro un cliente con Tipo de Documento TipoDocumento <TipoDocumento>, NumeroDeDocumento <NumeroDocumento>
    And registramos la  y datos particulares FechaCese tipoDOC <tipoDOC>,numDOC <numDOC>,ultimaRemuneracion <ultimaRemuneracion>
    And pasamos al siguiente estado Por aprobar <porAprobar>
    And pasamos al siguiente estado aprobada <aprobada>
    And pasamos al siguiente estado generar poliza <PolizaGenerada>
    Then valido que la poliza este en estado <generado>
    And validamos que la poliza en acsele en estado cotizada <cotizada>
    And Validamos que los movimientos este es estadoOk <transferenciaOK>

    Examples:
      | rol        | canal            | grupo    | producto         | moneda       | planes                             | sumaAseguradaMN | sumaAseguradaMA | sumaAseguradaIP |TipoDocumento | NumeroDocumento |tipoDOC|numDOC      |ultimaRemuneracion|porAprobar | aprobada       | PolizaGenerada | generado |cotizada | transferenciaOK|
      | DIRECTO    | SEGUROS DIRECTOS | VIDA LEY | Vida Ley Cesantes| NUEVOS SOLES | [171489] - Plan Cesantes Nueva Ley |     10000       |        50000    |  50000          |DNI           | 70055294        |  RUC  |20549805401 |     8000         |POR APROBAR|    APROBADA    | GENERAR PÓLIZA  | Activo   | Emitida | TRANSFERIDO OK|




