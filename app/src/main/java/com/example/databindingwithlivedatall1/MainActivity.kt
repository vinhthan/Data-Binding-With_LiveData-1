package com.example.databindingwithlivedatall1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.databindingwithlivedatall1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lắng nghe LiveData
        //Hàm lắng nghe LiveData nên được viết ở UI Thread vì chỉ
        // UI thread mới có thể update giao diện thôi các bạn nhé
        val mainViewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewmodel = mainViewModel
        }

        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            txvChangeEdt.text = edt.text.toString()

            btnShowEdt.setOnClickListener {
                txvShowEdt.text = edt.text.toString()
            }

        })


    }
}
