@Scenario3
Feature: pre emitir poliza worksite

  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Solicitudes Unificado" --> "Generación de Solicitud - Unificada"
    And rellenamos la seccion datos generales canal <canal>,vendedor <vendedor>
    And rellenamos la seccion datos de solicitud <solicitud>,nroSolicitud <nroSolicitud>,nroLote <nroLote>,nroRegistro <nroRegistro>,RazonSocial <RazonSocial>,Dependencia <dependencia>,MesDeproducción <mesProducción>
    And rellenamos la seccion titular dni <dni>,codEmpleado <codEmpleado>
    And rellenamos la seccion Selecproducto <Selecproducto>,plan <plan>,tipoPlan <tipoPlan>,Fraccionamiento <Fraccionamiento>
    And rellenamos la seccion asegurados Nrodni <Nrodni>
    Then se mostrará el mensaje La solicitud xx se encuentra Pre-Emitida la solicitud de póliza de Worksite quedará como Pre-emitida

    Examples:
    | canal           |             vendedor                  | solicitud | nroSolicitud | nroLote | nroRegistro  | RazonSocial | dependencia | mesProducción |    dni   | codEmpleado | Selecproducto      |            plan            | tipoPlan |      Fraccionamiento                |  Nrodni |
    | SEGUROS DIRECTOS|768848382 - SAOA MOSCHETTI GEULIO KACOB| Unificada |   66696865   |  45689  |  456289      | 20131370301 |     1       |   Junio 2025  | 71755943 |  635        | PROTECCION FAMILIAR| [277477] - PIS PLUS PRICING|  PF-R    | WORKSITE MENSUAL P. NAT. S/. SIN IGV| 12345678|

