Feature: Renovar poliza vida Grupo

  @Scenario11
  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Mantenimiento Póliza"
    And Hacemos la busqueda general sin criterios de la poliza provisional <poliza>
    And renovamos vigencia la poliza del producto <producto> con estadoInicial <estadoInicial> y colocamos el tipo de vigencia <vigencia>
    And registramos la planilla de asegurados del producto <producto> con estado <estadoPoliza> y colocamos en el numero de tramite <numeroTramite> y en el excel colocamos el tipoProducto <tipoProducto>
    Then validamos que el estadoTransferencia <estadoTransferencia> del TipoMovimiento <TipoMovimiento> de la pestana del historial de movimientos
    Examples:
    |   poliza     |  producto        | estadoInicial | vigencia|estadoPoliza | numeroTramite|tipoProducto | estadoTransferencia | TipoMovimiento |
    | 431563079691 |  Vida Ley Activos|    Activo     |  MENSUAL|Generado     |     3269     |    VL       | TRANSFERIDO OK      |   RENOVACION   |

   # producto : Vida Ley Activos , Vida Grupo
   # tipoProducto :  VG , VL
