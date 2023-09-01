package com.tutorial.onlineshop_no1.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorial.onlineshop_no1.Adapter.PopularListAdapter
import com.tutorial.onlineshop_no1.Domain.PopularDomain
import com.tutorial.onlineshop_no1.R

class MainActivity : AppCompatActivity() {
     private lateinit var adapterPupolar: RecyclerView.Adapter<*>
     private lateinit var recylerViewPupolar: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerview()
        bottom_navigation()
    }

    private fun bottom_navigation() {
        val homeBtn = findViewById<LinearLayout>(R.id.homeBtn)
        val cartbtn = findViewById<LinearLayout>(R.id.cartBtn)

        homeBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        cartbtn.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }

    private fun initRecyclerview() {
        val items = ArrayList<PopularDomain>();
        items.add(PopularDomain("MacBok Pro 13 M2 chip", "新しいM2チップにより、13インチMacBook Proがこれまで以上に万能に。おなじみのコンパクトボディに、最大20時間使えるバッテリー1と、進化したパフォーマンスを持続させるアクティブクーリングシステムを搭載。あざやかなRetinaディスプレイ、FaceTime HDカメラ、スタジオ品質のマイクも魅力です。Appleが作った中で、最もポータブルなプロ向けノートブックを紹介します。", "pic1", 15, 4.0, 500))
        items.add(PopularDomain("Ps-5 Digital", "Experience lightning-fast loading with an ultra-high speed SSD, deeper immersion with support for haptic feedback, adaptive triggers, and 3D audio, and an all-new generation of incredible PlayStation® games.\n" +
                "\n" +
                "PS5™ Digital Edition is an all-digital version of the PS5™ console with no disc drive. Sign into your account for PlayStation™Network and go to PlayStation™Store to buy and download games.", "pic2", 10, 4.5, 450))
        items.add(PopularDomain("iPhone14", "iPhone 14 Plusは、21%大きいスクリーンを持っています。超ビッグなのに、驚くほど軽量です。\n" +
                "\n" +
                "どちらのモデルも、あざやかなSuper Retina XDRディスプレイを搭載。OLEDテクノロジーが明るい白と真の黒を再現します。", "pic3", 13, 4.2, 800))

        recylerViewPupolar = findViewById(R.id.view1)
        recylerViewPupolar.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)

        adapterPupolar = PopularListAdapter(items)
        recylerViewPupolar.adapter = adapterPupolar
    }
}
