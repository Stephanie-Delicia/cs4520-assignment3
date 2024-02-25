package com.cs4520.assignment3

import android.util.Log
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
        Log.i("setToastMessage", "ViewModel")
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getResult(): Double? {
        return model.geResultField()
    }

    fun setResultField(res: Double?) {
        model.setResultField(res)
        // notifyPropertyChanged(BR.result)
    }

    // getter and setter methods
    // for email variable
    @Bindable
    fun getNum1(): Double? {
        return model.getNum1Field()
    }
    fun setNum1(num: String?) {
        if ((num != null) and (num != "")) {
            if (num != null) {
                model.setNum1Field(num.toDouble())
            }
            // notifyPropertyChanged(BR.num1)
        } else { model.setNum1Field(null)}
    }

    // getter and setter methods
    // for email variable
    @Bindable
    fun getNum2(): Double? {
        return model.getNum2Field()
    }
    fun setNum2(num: String?) {
        if ((num != null) and (num != "")) {
            if (num != null) {
                model.setNum2Field(num.toDouble())
            }
            // notifyPropertyChanged(BR.num2)
        } else { model.setNum2Field(null)}
    }

    fun onAddClicked() {
        if (isValidAddSubtractOrMultiply()) {
            setToastMessage(successMessage)
            var result = performOperation(Operation.ADD, model.num1, model.num2)
            model.setResultField(result)
        } else {
            setToastMessage(errorMessage)
        }
    }

    fun onSubtractClicked() {
        if (isValidAddSubtractOrMultiply()) {
            setToastMessage(successMessage)
            var result = performOperation(Operation.SUBTRACT, model.num1, model.num2)
            model.setResultField(result)
        } else {
            setToastMessage(errorMessage)
        }
    }

    fun onMultiplyClicked() {
        if (isValidAddSubtractOrMultiply()) {
            setToastMessage(successMessage)
            var result = performOperation(Operation.MULTIPLY, model.num1, model.num2)
            model.setResultField(result)
        } else {
            setToastMessage(errorMessage)
        }
    }

    fun onDivideClicked() {
        if (isValidDivide()) {
            setToastMessage(successMessage)
            var result = performOperation(Operation.DIVIDE, model.num1, model.num2)
            model.setResultField(result)
        } else {
            setToastMessage(errorMessage)
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
public fun performOperation(op : Operation, num1 : Double?, num2 : Double?) : Double? {
    if ((num1 != null) and (num2 != null)) {
        if (op == Operation.ADD) {
            return num1!! + num2!!
        }
        else if (op == Operation.SUBTRACT) {
            return num1!! - num2!!
        }
        else if (op == Operation.MULTIPLY) {
            return num1!! * num2!!
        }
        else {
            return num1!! / num2!!
        }
    } else {return null}
}