

import groovy.json.JsonSlurper
import groovy.test.*

def jsonSlurper = new JsonSlurper()

def response = createUser("the oneeeee", "The One from Matrix")
println(response)
getUser("1")

def createUser(def name, def job) {
    def post = new URL("https://reqres.in/api/users/").openConnection()
    def message = "{ \"name\":$name, \"job\": $job }"
    post.setRequestMethod("POST")
    post.setRequestProperty("Content-Type", "application/json")
    post.setRequestProperty("body", message)
    responseCodePrint(post.responseCode)
    post.getInputStream().text
}

def updateUser(def id, def updatedName, def updatedJob) {
    def updateUser = new URL("https://reqres.in/api/users/$id").openConnection()
    def testMessage = "{ \"name\":$updatedName, \"job\": $updatedJob }"
    updateUser.setRequestMethod("PUT")
    updateUser.setRequestProperty("body", testMessage)
    updateUser.setRequestProperty("Content-Type", "application/json")
    responseCodePrint(updateUser.responseCode)
    updateUser.getInputStream().text
}

def getUser(def id) {
    def get = new URL("https://reqres.in/api/users/$id").openConnection()
    get.setRequestMethod("GET")
    responseCodePrint(get.responseCode)
    get.getInputStream().text
}

def responseCodePrint(def inputResponseCode) {
    println("response code $inputResponseCode")
}