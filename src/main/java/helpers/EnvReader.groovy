package helpers
import groovy.json.JsonSlurper


class EnvReader {
    def envPath = "src/main/resources/Data/env.json"
    File envFile
    def parsedEnvFile

    EnvReader(){
        envFile = new File(envPath)
        parsedEnvFile = new JsonSlurper().parseText(envFile.text)
    }
}
