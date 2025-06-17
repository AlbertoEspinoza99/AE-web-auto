Feature: renovacion poliza vida ley cesante

  @Scenario23
  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Mantenimiento Póliza"
    And Hacemos la busqueda general sin criterios de la poliza provisional <poliza>
    And renovamos condiciones de la poliza del producto <producto> con estadoInicial <estadoInicial>
    And pasamos al siguiente estado Por aprobar <porAprobar>
      #And pasamos al siguiente estado aprobada <aprobada>
    And pasamos al siguiente estado generar poliza <PolizaGenerada>
    Then valido que la poliza con su  numero de cotizacion y con estado <estado>

    Examples:
    |    poliza    |     producto     | estadoInicial |porAprobar | aprobada       | PolizaGenerada |  estado |
    | 431962910124 | Vida Ley Cesantes|    Activo     |POR APROBAR|    APROBADA    | GENERAR PÓLIZA |  Activo  |
