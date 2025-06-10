Feature: inclusion de certidicado vida grupo

  @Scenario12
  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Mantenimiento Póliza"
    And Hacemos la busqueda general sin criterios de la poliza provisional <poliza>
    And registramos la planilla de asegurados para inclusion y/o exclusion certificado del producto <producto> con estado <estadoPoliza> y colocamos en el numero de tramite <numeroTramite>, el tipoProductoDes <tipoProductoDes> y en el excel colocamos el tipoProducto <tipoProducto>
    Then validamos que el estadoTransferencia <estadoTransferencia> del TipoMovimiento <TipoMovimiento> de la pestana del historial de movimientos
    Examples:
      |   poliza     |  producto        |estadoPoliza | numeroTramite| tipoProductoDes |tipoProducto | estadoTransferencia | TipoMovimiento              |
      | 431563079199 | Vida Ley Activos |Activo       |     3269     |  INCLUSÍON      |  VL         | PENDIENTE           |   INCLUSION DE ASEGURADOS   |


    # producto : Vida Ley Activos , Vida Grupo
    # tipoProducto :  VG , VL
    # estadoPoliza : Generado , Activo
    # tipoProductoDes : INCLUSÍON , EXCLUSIÓN
    # estadoTransferencia : TRANSFERIDO OK  , EN TRANSFERENCIA , PENDIENTE
    # TipoMovimiento :  RENOVACION , INCLUSION DE ASEGURADOS
