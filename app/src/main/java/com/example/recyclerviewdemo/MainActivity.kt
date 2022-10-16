package com.example.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val fruitList = listOf<Fruit>(
        Fruit("망고","과일가게 주인"),
        Fruit("바나나","납품업체 사장"),
        Fruit("사과", "농장 주인"),
        Fruit("자몽","무역업체"),
        Fruit("파인애플","이마트"),
        Fruit("토마토","홈플러스"),
        Fruit("오렌지","롯데마트")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.setBackgroundColor(Color.YELLOW)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecyclerViewAdapter(fruitList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(
            this@MainActivity,"공급자 : ${fruit.supplier}", Toast.LENGTH_SHORT
        ).show()
    }
}