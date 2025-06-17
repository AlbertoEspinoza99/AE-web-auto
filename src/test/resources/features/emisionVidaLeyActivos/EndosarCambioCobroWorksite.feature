Feature: Endoso medio de cobro worksite

  @Scenario05
  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Póliza" --> "Mantenimiento Póliza"
    And Hacemos la busqueda general sin criterios de la poliza provisional <poliza>
    And seleccionamos el producto <producto> con estado <estadoInicial> y nos dirigimos a editar certificado y realizamos el siguiente endoso <endoso>
    And realizamos el endoso cambio de la forma de pago <formaDePago>
    And activamos la poliza del producto <producto> con estado <estadoModificado>
    Then validamos que la poliza del <producto> este en estado <estadoFinal>

    Examples:
      |    poliza      |     producto         |  estadoInicial  |        endoso           |    formaDePago       |  estadoModificado|    estadoFinal  |
      | 10231300142030 | PROTECCION ACCIDENTAL|      Activo     |Endoso de Datos Generales|    Directo           |    Modificado    |     Modificado |

