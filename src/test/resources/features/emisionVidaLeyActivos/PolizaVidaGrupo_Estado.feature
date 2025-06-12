@Scenario14y15
Feature: generacion poliza vida grupo_estado


  Background:
    Given ingreso a la aplicacion web de SAS

  @Scenario14
  Scenario Outline:  generar cotizacion
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Registrar Cotización"
    And en la sección datos de cabecera se ingrese rol <rol> , Canal <canal> , Grupo <grupo>, Producto <producto>, Moneda <moneda>
    And seleccion de plan y coberturas <planes>,sumaAseguradaMN <sumaAseguradaMN>,sumaAseguradaMA <sumaAseguradaMA>,sumaAseguradaIP <sumaAseguradaIP>
    And registro un cliente con Tipo de Documento TipoDocumento <TipoDocumento>, NumeroDeDocumento <NumeroDocumento>
    And registramos los datos particulares y ingresamos tipoVigencia <tipoVigencia>,PrimaMinEmision <PrimaMinEmision>,PrimaMinEndoso <PrimaMinEndoso>,SueldoAsegurable <SueldoAsegurable>,segmento <segmento>
    And registro de riesgos y rellenamos el formulario TipoRiesgo <TipoRiesgo> , NumeroAsegurado <NumeroAsegurado> , MontoPlanillaMensual <MontoPlanillaMensual>
    And pasamos al siguiente estado Por aprobar <porAprobar>
    And pasamos al siguiente estado aprobada <aprobada>
    And pasamos al siguiente estado generar poliza <PolizaGenerada>
    Then valido que la poliza este en estado <generado>
    And validamos que la poliza en acsele en estado cotizada <cotizada>

    Examples:
      | rol        | canal            | grupo    | producto         | moneda       | planes                 | sumaAseguradaMN | sumaAseguradaMA | sumaAseguradaIP |TipoDocumento | NumeroDocumento | tipoVigencia | PrimaMinEmision|PrimaMinEndoso | SueldoAsegurable |segmento |TipoRiesgo | NumeroAsegurado | MontoPlanillaMensual | porAprobar | aprobada       | PolizaGenerada | generado |cotizada |
      | CORREDORES | SEGUROS DIRECTOS | VIDA LEY | Vida Grupo       | NUEVOS SOLES | [171474] - Plan Básico |     100000      |        50000    |  25000          |RUC           | 20288916528     | MENSUAL      |       1000     |   1000        |       1000       |ESTADO   |Empleados  | 1               | 2000                 | POR APROBAR|    APROBADA    | GENERAR PÓLIZA | Generado | Emitida |

  @Scenario15
  Scenario Outline: emision poliza
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Mantenimiento Póliza"
    And Nos dirigimos a la opcion de Mantenimiento Poliza y consultamos la poliza
    And agregamos una sucursal tramite <tramite>,tipoProducto <tipoProducto>
    Then validamos que la poliza este en estado transferida <transferidad>
    And validamos que la poliza en acsele en estado cotizada <cotizada>

    Examples:
      |tramite| transferidad   | cotizada | tipoProducto|
      | 153   | TRANSFERIDO OK | Emitida |    VG       |

