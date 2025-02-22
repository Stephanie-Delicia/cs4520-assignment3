package com.cs4520.assignment3

import com.cs4520.assignment3.databinding.FragmentMvpBinding

class MVPPresenter (private var mainView: FragmentMvpBinding,
                    private val model: MVPContract.Contract.Model) : MVPContract.Contract.Presenter {
    override fun onAddButtonClick(num1: Double?, num2: Double?): Double? {
        return if (isValidAddSubtractOrMultiply(num1, num2)) {
            val res = num1!! + num2!!
            val s = "Result: $res"
            mainView.resultMvp.text = s // set result
            model.setResult(res)
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            res
        } else {
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            null
        }

    }

    override fun onSubtractButtonClick(num1: Double?, num2: Double?): Double? {
        return if (isValidAddSubtractOrMultiply(num1, num2)) {
            val res = num1!! - num2!!
            val s = "Result: $res"
            mainView.resultMvp.text = s // set result
            model.setResult(res)
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            res
        } else {
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            null
        }
    }

    override fun onMultiplyButtonClick(num1: Double?, num2: Double?): Double? {
        return if (isValidAddSubtractOrMultiply(num1, num2)) {
            val res = num1!! * num2!!
            val s = "Result: $res"
            mainView.resultMvp.text = s // set result
            model.setResult(res)
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            res
        } else {
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            null
        }
    }

    override fun onDivideButtonClick(num1: Double?, num2: Double?): Double? {
        return if (isValidDivide(num1, num2)) {
            val res = num1!! / num2!!
            val s = "Result: $res"
            mainView.resultMvp.text = s // set result
            model.setResult(res)
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            res
        } else {
            mainView.num1Mvp.text.clear()
            mainView.num2Mvp.text.clear()
            null
        }
    }

    private fun isValidAddSubtractOrMultiply(num1: Double?, num2: Double?): Boolean {
        return (num1 != null) and (num2 != null)
    }
    private fun isValidDivide(num1: Double?, num2: Double?): Boolean {
        return (num1 != null) and (num2 != null) and (num2 != 0.0)
    }

}