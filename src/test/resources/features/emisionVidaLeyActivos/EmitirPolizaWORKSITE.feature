@Scenacio04
Feature: emision poliza worsite

  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Solicitudes Unificado" --> "Emitir Pólizas Worksite - Unificada"
    And hacemos la busqueda de solicitudes: solicitud <solicitud>,NroSolicitud <NroSolicitud>

    Examples:
    |solicitud   |NroSolicitud  |
    |  Unificada | 156          |