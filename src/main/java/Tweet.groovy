import groovy.transform.ToString

@ToString
class Tweet {
    def bird
    def volume

    Tweet(){
        println("tweet, tweet")
    }
    Tweet(def bird, def volume){
        println("$bird tweets $volume")
    }
}