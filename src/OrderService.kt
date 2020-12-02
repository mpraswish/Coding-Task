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
}

fun main(args:Array<String>) {

    var orders=args
    var orderService=OrderService()
    orderService.PlaceOrder(orders)
}
