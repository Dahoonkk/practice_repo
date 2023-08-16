package com.practice.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.practice.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 뷰모델 가져오기
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = mainViewModel

        /*// 관찰하여 데이터 값이 변경되면 호출
        // this와 라이프사이클을 공유함(LiveData는 자동으로 Observer 상태를 관리함)
        mainViewModel.currentNumber.observe(this, Observer {
            Log.d("Check", "현재 값 : $it")
            binding.numberText.text = it.toString()
        })
        mainViewModel.currentNumber2.observe(this, Observer {
            binding.numberText2.text = it.toString()
        })*/

        binding.lifecycleOwner = this
    }
}