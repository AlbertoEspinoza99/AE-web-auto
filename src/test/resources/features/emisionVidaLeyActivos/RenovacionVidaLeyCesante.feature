Feature: renovacion poliza vida ley cesante

  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Acuerdos" --> "Transacciones" --> "Emisión Vida Ley" --> "Mantenimiento Póliza"
    And Hacemos la busqueda general sin criterios de la poliza provisional <poliza>
    And renovamos condiciones de la poliza del producto <producto> con estadoInicial <estadoInicial> y colocamos el tipo de vigencia <vigencia>

    Examples:
    |    poliza    |     producto     | estadoInicial |  vigencia |
    | 431963081740 | Vida Ley Cesantes|    Activo     |   MENSUAL |
