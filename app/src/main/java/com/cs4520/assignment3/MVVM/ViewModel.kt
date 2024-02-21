package com.cs4520.assignment3.MVVM

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.cs4520.assignment3.BR


class ViewModel : BaseObservable() {
    // creating object of Model class
    private var model: Model? = null

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

    // constructor of ViewModel class
    //constructor() {
//
        // instantiating object of
        // model class
 //       model = Model(0.0, 0.0)
  //  }

    // getter and setter methods
    // for email variable
    @Bindable
    fun getNum1(): Double? {
        return model?.getNum1Field()
    }
    fun setNum1(num: Double) {
        model?.setNum1Field(num)
        notifyPropertyChanged(BR.num1)
    }

    // getter and setter methods
    // for email variable
    @Bindable
    fun getNum2(): Double? {
        return model?.getNum2Field()
    }
    fun setNum2(num: Double) {
        model?.setNum2Field(num)
        notifyPropertyChanged(BR.num2)
    }

    fun onAddSubtractOrMultiplyButtonClicked() {
        if (isValidAddSubtractOrMultiply())
            setToastMessage(successMessage) else setToastMessage(errorMessage)
    }
    fun onDivideButtonClicked() {
        if (isValidDivide())
            setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    fun isValidAddSubtractOrMultiply(): Boolean {
        return (getNum1() != null) and (getNum2() != null)
    }
    fun isValidDivide(): Boolean {
        return (getNum1() != null) and (getNum2() != null) and (getNum2() != 0.0)
    }

}