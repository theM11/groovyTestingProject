import helpers.TestDataReader
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.platform.launcher.listeners.LoggingListener

import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger


class UserTests {

    @BeforeAll
    static void init(){
        def logger = Logger.getLogger(LoggingListener.name)
        logger.level = Level.FINE
        logger.addHandler(new ConsoleHandler(level: Level.FINE))
        TestDataReader reader = new TestDataReader()
    }


    @Test
    def createUser(def name, def job) {
        def post = new URL("https://reqres.in/api/users/").openConnection()
        def message = "{ \"name\":$name, \"job\": $job }"
        post.setRequestMethod("POST")
        post.setRequestProperty("Content-Type", "application/json")
        post.setRequestProperty("body", message)
        responseCodePrint(post.responseCode)
        post.getInputStream().text
    }

    @Test
    def updateUser(def id, def updatedName, def updatedJob) {
        def updateUser = new URL("https://reqres.in/api/users/$id").openConnection()
        def testMessage = "{ \"name\":$updatedName, \"job\": $updatedJob }"
        updateUser.setRequestMethod("PUT")
        updateUser.setRequestProperty("body", testMessage)
        updateUser.setRequestProperty("Content-Type", "application/json")
        responseCodePrint(updateUser.responseCode)
        updateUser.getInputStream().text
    }

    @Test
    def getUser(def id) {
        def get = new URL("https://reqres.in/api/users/$id").openConnection()
        get.setRequestMethod("GET")
        responseCodePrint(get.responseCode)
        get.getInputStream().text
    }

    def responseCodePrint(def inputResponseCode) {
        println("response code $inputResponseCode")
    }
}
