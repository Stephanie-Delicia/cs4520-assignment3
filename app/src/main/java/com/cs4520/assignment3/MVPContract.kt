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
            // nested interface to be
//            interface OnFinishedListener {
//                // function to be called
//                // once the Handler of Model class
//                // completes its execution
//                fun onFinished(string: String?)
//            }

            // fun getNextCourse(onFinishedListener: OnFinishedListener?)
        }

        interface Presenter {
            // method to be called when
            // the button is clicked
            fun onAddButtonClick(num1 : Double?, num2 : Double?) : Double?
            fun onSubtractButtonClick(num1 : Double?, num2 : Double?) : Double?
            fun onMultiplyButtonClick(num1 : Double?, num2 : Double?) : Double?
            fun onDivideButtonClick(num1 : Double?, num2 : Double?) : Double?

            // method to destroy
            // lifecycle of MainActivity
            // fun onDestroy()
        }
    }
}