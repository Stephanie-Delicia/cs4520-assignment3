package com.cs4520.assignment3

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class ViewModel : BaseObservable() {
    // creating object of Model class
    private var model: MVVMModel = MVVMModel()

    // string variables for
    // toast messages
    private val successMessage = "Successful operation."
    private val errorMessage = "Invalid operation."

    @Bindable
    // toast message
    private var toastMessage: String? = null

    // getter and setter methods
    // for toast message
    fun getToastMessage(): String? {
        return toastMessage
    }

    private fun setToastMessage(toastMessage: String) {
        Log.i("setToastMessage", "ViewModel")
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getResult(): Double? {
        return model.geResultField()
    }

    private fun setResultField(res: Double?) {
        model.setResultField(res)
    }

    @Bindable
    fun getNum1(): Double? {
        return model.getNum1Field()
    }
    fun setNum1(num: String?) {
        if ((num != null) and (num != "")) {
            if (num != null) {
                model.setNum1Field(num.toDouble())
            }
        } else { model.setNum1Field(null)}
    }

    @Bindable
    fun getNum2(): Double? {
        return model.getNum2Field()
    }
    fun setNum2(num: String?) {
        if ((num != null) and (num != "")) {
            if (num != null) {
                model.setNum2Field(num.toDouble())
            }
        } else { model.setNum2Field(null)}
    }

    fun onAddClicked() {
        if (isValidAddSubtractOrMultiply()) {
            setToastMessage(successMessage)
            val result = performOperation(Operation.ADD, getNum1(), getNum2())
            setResultField(result)
        } else {
            setToastMessage(errorMessage)
        }
    }

    fun onSubtractClicked() {
        if (isValidAddSubtractOrMultiply()) {
            setToastMessage(successMessage)
            val result = performOperation(Operation.SUBTRACT, getNum1(), getNum2())
            setResultField(result)
        } else {
            setToastMessage(errorMessage)
        }
    }

    fun onMultiplyClicked() {
        if (isValidAddSubtractOrMultiply()) {
            setToastMessage(successMessage)
            val result = performOperation(Operation.MULTIPLY, getNum1(), getNum2())
            setResultField(result)
        } else {
            setToastMessage(errorMessage)
        }
    }

    fun onDivideClicked() {
        if (isValidDivide()) {
            setToastMessage(successMessage)
            val result = performOperation(Operation.DIVIDE, getNum1(), getNum2())
            setResultField(result)
        } else {
            setToastMessage(errorMessage)
        }
    }
    private fun isValidAddSubtractOrMultiply(): Boolean {
        return (getNum1() != null) and (getNum2() != null)
    }
    private fun isValidDivide(): Boolean {
        return (getNum1() != null) and (getNum2() != null) and (getNum2() != 0.0)
    }
}

enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}
fun performOperation(op : Operation, num1 : Double?, num2 : Double?) : Double? {
    return if ((num1 != null) and (num2 != null)) {
        when (op) {
            Operation.ADD -> {
                num1!! + num2!!
            }
            Operation.SUBTRACT -> {
                num1!! - num2!!
            }
            Operation.MULTIPLY -> {
                num1!! * num2!!
            }
            else -> {
                num1!! / num2!!
            }
        }
    } else {
        null
    }
}