package com.cs4520.assignment3

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class ViewModel : BaseObservable() {
    // creating object of Model class
    private var model: Model = Model()

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
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getResult(): Double {
        return model.geResultField()
    }

    fun setResultField(res: Double) {
        model.setResultField(res)
        notifyPropertyChanged(BR.result)

    }

    // getter and setter methods
    // for email variable
    @Bindable
    fun getNum1(): Double {
        return model.getNum1Field()
    }
    fun setNum1(num: Double) {
        model.setNum1Field(num)
        notifyPropertyChanged(BR.num1)
    }

    // getter and setter methods
    // for email variable
    @Bindable
    fun getNum2(): Double? {
        return model.getNum2Field()
    }
    fun setNum2(num: Double) {
        model.setNum2Field(num)
        notifyPropertyChanged(BR.num2)
    }

    fun onOperationButtonClicked(op : Operation) {
        if (op == Operation.ADD ||
            op == Operation.SUBTRACT ||
            op == Operation.MULTIPLY) {
            if (isValidAddSubtractOrMultiply()) {
                setToastMessage(successMessage)
                var result = performOperation(op, model.num1, model.num2)
                model.setResultField(result)
            } else {
                setToastMessage(errorMessage)
            }
        } else if (op == Operation.DIVIDE) { // is the divide operation
            if (isValidDivide()) {
                var result = performOperation(op, model.num1, model.num2)
                model.setResultField(result)
                setToastMessage(successMessage)
            } else {
                setToastMessage(errorMessage)
            }
        }

    }

    fun isValidAddSubtractOrMultiply(): Boolean {
        return (getNum1() != null) and (getNum2() != null)
    }
    fun isValidDivide(): Boolean {
        return (getNum1() != null) and (getNum2() != null) and (getNum2() != 0.0)
    }

}

enum class Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}
public fun performOperation(op : Operation, num1 : Double, num2 : Double) : Double {
    if (op == Operation.ADD) {
        return num1 + num2
    }
    else if (op == Operation.SUBTRACT) {
        return num1 + num2
    }
    else if (op == Operation.MULTIPLY) {
        return num1 * num2
    }
    else {
        return num1 / num2
    }
}