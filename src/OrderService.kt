class OrderService {
    var AppleCount:Int=0
    var OrangeCount:Int=0
    var AppleCost:Int=60
    var OrangeCost:Int=25

    fun PlaceOrder(orders:Array<String>)
    {
        for(element in orders)
        {
            if(element.toUpperCase()=="APPLE")
            {
                this.AppleCount++
            }
            if(element.toUpperCase()=="ORANGE")
            {
                this.OrangeCount++
            }

        }

        this.CalculatePrice(this.AppleCount,this.OrangeCount)

    }

    fun CalculatePrice(AppleCount:Int,OrangeCount:Int)
    {
        println("$"+(AppleCount*this.AppleCost+OrangeCount*this.OrangeCost).toDouble()/100)
    }


    fun GetOfferDetail()
    {
        println("Buy one get one free on Apples")
        println("3 for the price of 2 on Oranges")
    }

    fun ApplySimpleOffer(AppleCount:Int,OrangeCount:Int)
    {
        var offeredApples=this.AppleCount*2
        var offeredOranges=this.OrangeCount + this.OrangeCount/2
        println("Offered Apple is  : "+offeredApples)
        println("Offered Orange is  : "+offeredOranges)
    }
}

fun main(args:Array<String>) {

    var orders=args
    var orderService=OrderService()
    orderService.PlaceOrder(orders)
}
