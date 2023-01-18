package helpers

import groovy.json.JsonSlurper


class TestDataReader {
    // choose data source - on constructor
    File file
    def fileContent
    def testSuite
    def testName
    def testKey
    def testData

    /**
     * opens file
     */

    // only inits file path, different data sources should be in different methods
    TestDataReader() {
        file = new File("src/main/resources/Data/restTestData.json")
        fileContent = new JsonSlurper().parseText(file.text)
        testName = fileContent.testSuiteName.testName
        testSuite = fileContent.testSuiteName
        testKey = fileContent.reportingTo
        testData = fileContent.testData
    }

    def readXMLDataSource(def dataSource){

    }
}
