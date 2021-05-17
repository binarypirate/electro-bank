package com.example.electrobank.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.electrobank.R;
import com.example.electrobank.databinding.ActivityDepositBinding;

public class DepositActivity extends AppCompatActivity {

    ActivityDepositBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDepositBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }
}