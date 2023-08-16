package com.practice.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 데이터의 변경사항을 알려주는 라이브 데이터를 가지는 뷰모델
class MainViewModel : ViewModel() {

   // 변경가능한 Mutable 타입의 LiveData
    private val _currentNumber = MutableLiveData<Int>()
    private val _currentNumber2 = MutableLiveData<Int>()

    // 무결성을 위한 Getter
    val currentNumber : LiveData<Int>
        get() = _currentNumber
    val currentNumber2 : LiveData<Int>
        get() = _currentNumber2

    // 초기화
    init {
        _currentNumber.value= 0
        _currentNumber2.value = 0
    }

    // Setter
    fun updateValue(type: Int) {
        when(type) {
            1 ->
                _currentNumber.value = _currentNumber.value?.plus(1)
            2 ->
                _currentNumber.value = _currentNumber.value?.minus(1)
        }
    }

    fun setValue() {
        _currentNumber2.value = _currentNumber.value
    }
}