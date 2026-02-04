package com.example.lib

class User(var name: String, var age: Int) {

    fun updateName(newName: String) {
        name = newName.trim()
    }

    fun haveBirthday() {
        age++
    }

    override fun toString(): String {
        return "User: $name ($age)"
    }
}

class Account(var user: User, var _balance: Float) {
    var fee = 29f
    var balance = _balance
        set(value) {
            if (value >= 0) {
                field = value
            }
        }

    fun deposit(amount: Float) {
        if(amount <= 0) {
            println("Error only deposit positive amount")
        } else {
            balance += amount
        }
    }

    fun canWithdraw(amount: Float): Boolean {
        return amount <= balance
    }

    fun withdraw(amount: Float) {
        if(canWithdraw(amount)) {
            balance = balance - amount
        }
    }

    fun monthlyFee() {

        balance -= fee
    }

    override fun toString(): String {
        return "Account of ${user.name} has balance $balance"
    }
}

fun main() {
    /*
    val ageFromUser = getAgeFromUser();
    val canUserVote = canVote(ageFromUser);
    ¨


    val benjaminsSamusungPhone = Mobile("Samsung", 5000f);
    println(benjaminsSamusungPhone)
    println(benjaminsSamusungPhone.getDiscount())

    val persIphone = Mobile("Apple", 10000f)
    println(persIphone)
*/

    val user = User(" Alice ", 20)
    val account = Account(user, 100f)

    account.deposit(-50f)
    println(account)
}

/*
fun calculateAverage() {
    val myList = listOf(7, 4, 9, 13, 15)
        ...
}
¨
 */



fun getAgeFromUser (): Int {
    print("Enter your age: ")
    val ageInput = readLine()!!  // https://www.youtube.com/watch?v=XkBYH9vLs50
    val ageInt = ageInput.toInt()

    return ageInt;
}

fun canVote(age: Int): Boolean {
    return age >= 18;
}