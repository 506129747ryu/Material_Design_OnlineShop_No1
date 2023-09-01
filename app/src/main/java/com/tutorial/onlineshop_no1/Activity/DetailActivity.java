package com.tutorial.onlineshop_no1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.tutorial.onlineshop_no1.Domain.PopularDomain;
import com.tutorial.onlineshop_no1.Hepler.ManagementCart;
import com.tutorial.onlineshop_no1.R;

public class DetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, reviewTxt, scoreTxt;
    private ImageView picItem, backBtn;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        reviewTxt.setText(""+object.getReview());
        scoreTxt.setText(object.getScore()+"");

        addToCartBtn.setOnClickListener(view -> {
            object.setNumberinCart(numberOrder);
            managementCart.insertFood(object);
        });

        backBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    private void initView() {
        addToCartBtn =  findViewById(R.id.addToCartBtn);
        feeTxt = findViewById(R.id.priceTxt);
        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        picItem = findViewById(R.id.itemPic);
        reviewTxt = findViewById(R.id.reviewTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        backBtn = findViewById(R.id.backBtn);

    }
}
