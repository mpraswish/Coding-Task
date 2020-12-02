class MailServices
{
    var Heading:String=""
    var Content:String=""
    fun SendNotification(message:String,heading:String)
    {
        println(" Heading: "+heading)
        println(" Content: "+message)
    }
}

class OrderService {
    var totalApple:Int=500
    var totalOrange:Int=500
    var AppleCount:Int=0
    var OrangeCount:Int=0
    var AppleCost:Int=60
    var OrangeCost:Int=25

    fun PlaceOrder(orders:Array<String>)
    {

        if(orders.isEmpty()==true)
        {
            println("Empty order cannot be place")
            return
        }

        for(element in orders)
        {
            if(element.toLowerCase()=="apple")
            {
                this.AppleCount++
            }
            if(element.toLowerCase()=="apple")
            {
                this.OrangeCount++
            }

        }
        this.ProcessOrder(orders);



    }

    fun CalculatePrice(AppleCount:Int,OrangeCount:Int):Double
    {
        var Price:Double =(AppleCount*this.AppleCost+OrangeCount*this.OrangeCost).toDouble()/100

        return Price
    }


    fun ProcessOrder(orders:Array<String>)
     { //checking the condition if apple and orange is in stock
        if(this.AppleCount>this.totalApple|| this.OrangeCount>this.totalOrange)
        {
            var mailService=MailServices()
            mailService.SendNotification("Order Failed","Sorry")
            return
        }

        this.CalculatePrice(this.AppleCount,this.OrangeCount)
        var Price:Double=this.CalculatePrice(this.AppleCount,this.OrangeCount)
        var notificationHeader:String=" Your Order has been Placed Successfully"
        var orderDetail:String=" Apples : Qty= "+this.AppleCount+"\n"+ "Oranges : Qty= "+this.OrangeCount
        var mailService=MailServices()
        mailService.SendNotification(notificationHeader,orderDetail)
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
