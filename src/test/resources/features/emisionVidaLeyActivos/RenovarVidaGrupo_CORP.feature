Feature: Renovar poliza

  @Scenario11
  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Mantenimiento Póliza"
    And Hacemos la busqueda general sin criterios de la poliza provisional <poliza>
    And renovamos vigencia la poliza del producto <producto> con estadoInicial <estadoInicial>
    And registramos la planilla de asegurados del producto <producto> con estado <estadoPoliza>
    Then validamos que el estadoTransferencia <estadoTransferencia> del TipoMovimiento <TipoMovimiento> de la pestana del historial de movimientos
    Examples:
    |   poliza     |  producto  | estadoInicial | estadoPoliza | estadoTransferencia | TipoMovimiento |
    | 431863079730 |  Vida Grupo|    Activo     |    Generado  |      TRANSFERIDO OK |   RENOVACION   |


