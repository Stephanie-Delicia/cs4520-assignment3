package com.cs4520.assignment3

class MVVMModel {
    var num1 : Double? = null
    var num2 : Double? = null
    var res : Double? = null

    // getter and setter methods
    // for email variable
    fun geResultField(): Double? {
        return res
    }

    fun setResultField(r: Double?) {
        res = r
    }

    // getter and setter methods
    // for email variable
    fun getNum1Field(): Double? {
        return num1
    }

    fun setNum1Field(n1: Double?) {
        num1 = n1
    }

    // getter and setter methods
    // for email variable
    fun getNum2Field(): Double? {
        return num2
    }

    fun setNum2Field(n2: Double?) {
        num2 = n2
    }

}