package com.example.electrobank.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.electrobank.R;
import com.example.electrobank.databinding.ActivitySendMoneyBinding;

public class SendMoneyActivity extends AppCompatActivity {

    ActivitySendMoneyBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySendMoneyBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


    }
}