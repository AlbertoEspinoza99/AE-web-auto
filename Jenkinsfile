currentBuild.displayName = ESCENARIO + " - #" + currentBuild.number

import java.text.SimpleDateFormat
import groovy.json.JsonSlurper
import java.io.File
import groovy.json.JsonOutput

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()
def resultados = []
def canalExtraido = ""
def ambiente = ""

def secrets = [
        [path: 'AutoRimac/modernizacion-cores-sas-web-rimac-scp', engineVersion: 2, secretValues: [
                [envVar: 'username', vaultKey: 'username'],
                [envVar: 'password', vaultKey: 'password'],
        ]
        ]
]

def configuration = [vaultUrl: 'http://localhost:8200', vaultCredentialId: 'VaultCredential', engineVersion: 2]

pipeline {

    agent any

    environment {

        CORREO_OK = 'xt10638@rimac.com.pe,jislap@choucairtesting.com,luis.peralta@rimac.com.pe'
        CORREO_FALLA = 'xt10638@rimac.com.pe,jislap@choucairtesting.com,luis.peralta@rimac.com.pe'

        ES_ESCENARIO = "${ESCENARIO}"
        //CANAL = ES_ESCENARIO.substring(5)
    }

    tools {
            maven 'M3'
            jdk 'jdk11'
//         maven 'M3'
//         jdk 'jdk8.221'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
        disableConcurrentBuilds()
    }

    stages {

        stage('Build') {
            steps {
                bat("mvn clean")
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                withVault([configuration: configuration, vaultSecrets: secrets]) {
                    script {
                        try {
                            echo "Obteniendo credenciales de Vault..."


                            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE', message: 'Test Suite had a failure') {
                                echo "mvn test -Dtags=${ESCENARIO}  -Denvironment=${ambiente}"
                                bat "mvn test -Dtags=${ESCENARIO} "
                            }
                        }
                        catch (ex) {
                            echo 'Finalizo ejecucion con fallos...'
                            error('Failed')
                        }
                    }
                }
            }
        }


        stage('Reporte') {
            steps {
                script {
                    try {
                        bat("mvn serenity:aggregate")
                        echo 'Ejecucion de pruebas sin errores...'
                        bat("echo ${defTimestamp}")
                        publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/site/serenity", reportFiles: 'index.html', reportName: 'Evidencias de Prueba WEB', reportTitles: 'Reporte de Pruebas WEB'])
                        echo 'Reporte realizado con exito'
                    }
                    catch (ex) {
                        echo 'Reporte realizado con Fallos'
                        error('Failed')
                    }
                }
            }
        }

        stage('Extraccion Resultado WEB') {
            steps {
                script {
                    try {
                        bat("echo ${defTimestamp}")
                        bat("echo ${WORKSPACE}")
                        File fl = new File("${WORKSPACE}/target/site/result.json")
                        println("${WORKSPACE}/target/site/result.json")
                        def jsonSlurper = new JsonSlurper()
                        def obj = jsonSlurper.parseText(fl.text)
                        //         println("Archivo: ${obj}")
                        def json_str = JsonOutput.toJson(obj)
                        println("Archivo: ${json_str}")
                        //json_str.each { println it }
                        echo 'Se extrae reporte'

                        def parsedJson = new groovy.json.JsonSlurper().parseText(json_str)
                        def noPassed = 0
                        def ids = []
                        parsedJson.each { item ->
                            item.elements.each { element ->
                                element.steps.each { step ->
                                    if (step.result.status != "passed") {
                                        noPassed = noPassed + 1
                                    }
                                }
                            }
                        }


                        // Suponiendo que "parsedJson" contiene la estructura JSON que proporcionaste

                        // Lista para almacenar los resultados de los escenarios
                        //def resultados = []

                        // Iterar sobre cada elemento en el JSON
                        parsedJson.each { feature ->
                            feature.elements.each { scenario ->
                                def estadoFinal = "PASSED" // Por defecto, asumimos que el escenario es exitoso

                                // Iterar sobre las etapas (steps) del escenario
                                scenario.steps.each { step ->
                                    if (step.result.status != "passed") {
                                        estadoFinal = "FAILED" // Si alguna etapa falla, el escenario también falla
                                    }
                                }

                                if (scenario.type != "background") { //Excluimos a los antecedentes o background
                                    // Agregar el nombre del escenario y su estado final a la lista de resultados
                                    resultados.add([ESCENARIO: "WEB - " + scenario.name, RESULTADO: estadoFinal])
                                }
                            }
                        }

                        // Imprimir los resultados
                        resultados.each { resultado ->
                            println "Escenario: ${resultado.ESCENARIO}, Resultado: ${resultado.RESULTADO}"
                        }


                        echo 'Total'
                        println noPassed

                        if (noPassed > 0) {
                            error('Failed')
                        }


                    } catch (Exception e) {
                        println("Exception: ${e}")
                        echo 'Archivo no existe o se encontraron errores de ejecucion'
                        error('Failed')
                    }
                }
            }
        }
    }


    post {
        always {
            // Recopilar información de resultados
            script {
                def nombresEscenarios = []
                def estados = []

                resultados.each { resultado ->
                    nombresEscenarios.add(resultado.ESCENARIO)
                    estados.add(resultado.RESULTADO)
                }


                // Construir el cuerpo del correo
                def cuerpoCorreo =
                        """
                    <!DOCTYPE html>
                        <html>
                            <head>
                                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                                <title>Resultados de Pruebas</title>

                                <style>
                                        .contenedor {
                                           display: flex;
                                           align-items: center;
                                        }
                                        .texto-previo {
                                            position: absolute;
                                            top: 50%;
                                            left: 0;
                                            transform: translateY(-50%);
                                            padding: 5px;
                                            z-index: 1;
                                        }
                                        .imagen {
                                            margin-right: 20px;
                                        }
                                </style>
                            </head>
                              <body>
                                      <p style="font-size:16px;margin:0 0 20px 0;font-family:Arial,sans-serif;">Buen d&iacute;a:</p>
                                         </div>
                                         <div>
                                      <p style="margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;">Se detalla el estado de las pruebas de regresi&oacute;n: </p>

                      <table border="1" cellpadding="5">
                                                <thead>
                                                    <tr style="text-align:center;">
                                                        <th>Escenario</th>
                                                        <th>Resultado</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                    """

                // Agregar cada resultado como una fila en la tabla
                nombresEscenarios.eachWithIndex { nombre, index ->
                    def color = estados[index] == 'PASSED' ? 'darkgreen' : 'darkred' // Color verde oscuro si es PASSED, rojo oscuro si no
                    cuerpoCorreo +=
                            """
                           <tr>
                               <td>${nombre}</td>
                               <td style="color:${color};">${estados[index]}</td>
                           </tr>
                        """
                }

                // Cerrar la tabla y el cuerpo del correo
                cuerpoCorreo +=
                        """
                        </tbody>
                            </table>
                            <br>
                                <strong> Rimac - </strong>
                                    <b> Nombre Pipeline :  REGRESI&Oacute;N MODERNIZACION DE CORES -  Ejecuci&oacute;n N&uacute;mero: ${BUILD_NUMBER} </b>
                                        <br>

                                            <div class="contenedor">
                                                <span class="texto-previo">Reporte de la Ejecuci&oacute;n WEB: </span>
                                                <a href="http://01-089213.rimac.com.pe:8300/job/RegresionModernizacionCores-sas-web-rimac-scp/${BUILD_NUMBER}/Evidencias_20de_20Prueba_20WEB/">
                                                    <img class="imagen" src="https://serenity-bdd.info/wp-content/uploads/2021/07/serenity-bdd.png" alt="logo Serenity" width="127" height="27">
                                                </a>
                                            </div>
                                            <br>

                                            <br>
                                            <div class="contenedor">
                                                <span class="texto-previo">Descargar reporte WEB aqu&iacute; : </span>
                                                <a href="http://01-089213.rimac.com.pe:8300/job/RegresionModernizacionCores-sas-web-rimac-scp/${BUILD_NUMBER}/Evidencias_20de_20Prueba_20WEB/*zip*/Evidencias_20de_20Prueba_20WEB.zip">
                                                    <img class="imagen" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROwyObe2ujgVWcHJnU67GNG-f02c9ipgPMZBidUmlYEg&s" alt="logo ZIP" width="41" height="49">
                                                </a>
                                            </div>
                                            <br>
                                            <hr>

                                            <p style="margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;">Saludos, Equipo Rimac.</p>
                                        <div style="padding:5px 5px 5px 5px;width:2%;">
                                            <img src="https://files.rimac.com/ProteccionTarjeta/Poliza/FilesEmail/rimac_logo.png" alt="" width="86"/>
                                        </div>

                        </body>
                    </html>
                    """

                echo "Culmina Correctamente.... se enviara correo"
                emailext body: cuerpoCorreo,
                        subject: "RESUMEN DE PRUEBAS: REGRESION SAS TEST - ${canalExtraido} - ${defTimestamp}",
                        mimeType: 'text/html', to: "${currentBuild.result == 'SUCCESS' ? CORREO_OK : CORREO_FALLA}"

            }
        }
    }

}