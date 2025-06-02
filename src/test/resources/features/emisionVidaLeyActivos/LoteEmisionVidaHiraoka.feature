@Scenario01
Feature: generar el lote de emision

  Scenario Outline:
    Given ingreso a la aplicacion web de SAS
    When estoy logeado e ingreso en la opción "Tramas" --> "Transacciones" --> "Lote" --> "Monitor de Lotes"
    And rellenamos los datos de busqueda CanalNegocio <CanalNegocio>,Producto <Producto>
    Examples:
    |  CanalNegocio  |     Producto     |
    |     CNT        |  Vida IH Fintech |