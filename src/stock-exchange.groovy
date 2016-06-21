import groovy.json.JsonSlurper
import static groovy.json.JsonOutput.*

class stock {
    static void main(args) {
        Scanner sc = new Scanner(System.in)
        println("Please enter the Stock Symbol of the company: ")
        def StockSymbol = sc.nextLine()

        String baseURL = "https://www.quandl.com/api/v3/datasets/WIKI/"
        String key = "/data.json?rows=1&api_key=hV8h2ynfGwaBkkX1QvNM"
        def stockString = baseURL + StockSymbol + key
        def stockURL = new URL(stockString)
        def stock = new JsonSlurper().parseText(stockURL.text)

        println prettyPrint(toJson(stock))
        println("The current price of $StockSymbol = " + stock.dataset_data.data[0][2])

    }
}