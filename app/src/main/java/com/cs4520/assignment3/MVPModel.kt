package com.cs4520.assignment3

class MVPModel : MVPContract.Contract.Model {
    private var num1 : Double? = null
    private var num2 : Double? = null
    private var res : Double? = null

    // getter and setter methods
    override fun getResult(): Double? {
        return res
    }

    override fun setResult(num: Double?) {
        res = num
    }

    // getter and setter methods
    override fun getNum1(): Double? {
        return num1
    }

    override fun setNum1(num: Double?) {
        num1 = num
    }

    // getter and setter methods
    override fun getNum2(): Double? {
        return num2
    }

    override fun setNum2(num: Double?) {
        num2 = num
    }

}