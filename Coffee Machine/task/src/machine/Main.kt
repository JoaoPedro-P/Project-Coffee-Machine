class MachineCoffee() {

    companion object {
        var water = 400
        var milk = 540
        var coffee = 120
        var cups = 9
        var money = 550
    }

    fun choice(input: String) {
        when (input) {
            "remaining" -> show()
            "buy" -> {
                val inputChoice: String
                println("What do you want to buy? 1 - espresso, 2 - latte," +
                        " 3 - cappuccino, back - to main menu: > ${
                            readLine()!!.also {
                                inputChoice = it
                            }
                        }"
                )
                if (inputChoice != "back") {
                    buy(inputChoice)
                }
            }
            "fill" -> {
                val inputWater: Int
                val inputMilk: Int
                val inputCoffee: Int
                val inputCups: Int

                println("Write how many ml of water do you want to add:" +
                        " > ${readLine()!!.toInt().also { inputWater = it }}"
                )
                println("Write how many ml of milk do you want to add:" +
                        " > ${readLine()!!.toInt().also { inputMilk = it }}"
                )
                println("Write how many grams of coffee beans do you want to add: " +
                        "> ${readLine()!!.toInt().also { inputCoffee = it }}"
                )
                println("Write how many disposable cups of coffee do you want to add: " +
                        "> ${readLine()!!.toInt().also { inputCups = it }}"
                )

                fill(inputWater, inputMilk, inputCoffee, inputCups)
            }
            "take" -> take()
        }
        main()
    }
}

fun show () {
    println("The coffee machine has: ")
    println("${MachineCoffee.water} of water")
    println("${MachineCoffee.milk} of milk")
    println("${MachineCoffee.coffee} of coffee beans")
    println("${MachineCoffee.cups} of disposable cups")
    println("$${MachineCoffee.money} of money")
}

fun fill(fillWater: Int, fillMilk: Int,
         fillCoffee: Int, fillCups: Int) {
    MachineCoffee.water += fillWater
    MachineCoffee.milk += fillMilk
    MachineCoffee.coffee += fillCoffee
    MachineCoffee.cups += fillCups

}

fun buy (type: String) {
    when (type) {
        "1" -> {
            if (MachineCoffee.water >= 250 && MachineCoffee.coffee >= 16 && MachineCoffee.cups >= 1){
                MachineCoffee.water -= 250
                MachineCoffee.coffee -= 16
                MachineCoffee.cups -= 1
                MachineCoffee.money += 4
                println("I have enough resources, making you a coffee!")
            } else {
                when {
                    MachineCoffee.water < 250 -> println("Sorry, not enough water!")
                    MachineCoffee.coffee < 16 -> println("Sorry, not enough coffee!")
                    MachineCoffee.cups < 1 -> println("Sorry, not enough cups!")
                }
            }
        }
        "2" -> {
            if (MachineCoffee.water >= 350 && MachineCoffee.milk >= 75 && MachineCoffee.coffee >= 20 && MachineCoffee.cups >= 1){
                MachineCoffee.water -= 350
                MachineCoffee.milk -= 75
                MachineCoffee.coffee -=20
                MachineCoffee.cups -= 1
                MachineCoffee.money += 7
                println("I have enough resources, making you a coffee!")
            } else {
                when {
                    MachineCoffee.water < 350 -> println("Sorry, not enough water!")
                    MachineCoffee.milk < 75 -> println("Sorry, not enough milk!")
                    MachineCoffee.coffee < 20 -> println("Sorry, not enough coffee!")
                    MachineCoffee.cups < 1 -> println("Sorry, not enough cups!")
                }
            }
        }
        "3" -> {
            if (MachineCoffee.water >= 200 && MachineCoffee.milk >= 100 && MachineCoffee.coffee >= 12 && MachineCoffee.cups >= 1) {
                MachineCoffee.water -= 200
                MachineCoffee.milk -= 100
                MachineCoffee.coffee -= 12
                MachineCoffee.cups -= 1
                MachineCoffee.money += 6
                println("I have enough resources, making you a coffee!")
            } else {
                when {
                    MachineCoffee.water < 200 -> println("Sorry, not enough water!")
                    MachineCoffee.milk < 100 -> println("Sorry, not enough milk!")
                    MachineCoffee.coffee < 12 -> println("Sorry, not enough coffee!")
                    MachineCoffee.cups < 1 -> println("Sorry, not enough cups!")
                }
            }
        }
    }
}

fun take () {
    println("I gave you $${MachineCoffee.money}")
    MachineCoffee.money = 0
}

fun main() {
    var choice: String

    val machineCoffee = MachineCoffee()
    println("Write action (buy, fill, take, remaining, exit): > ${readLine()!!.also { choice = it }}")
    if (choice != "exit") machineCoffee.choice(choice)
}