package com.cs4520.assignment3

class MVPContract {
    interface Contract {
        interface View {
        }

        interface Model {
            fun setResult(num : Double?)
            fun setNum1(num : Double?)
            fun setNum2(num : Double?)

            fun getNum1() : Double?
            fun getNum2() : Double?
            fun getResult() : Double?
        }

        interface Presenter {
            // method to be called when
            // the button is clicked
            fun onAddButtonClick(num1 : Double?, num2 : Double?) : Double?
            fun onSubtractButtonClick(num1 : Double?, num2 : Double?) : Double?
            fun onMultiplyButtonClick(num1 : Double?, num2 : Double?) : Double?
            fun onDivideButtonClick(num1 : Double?, num2 : Double?) : Double?

        }
    }
}