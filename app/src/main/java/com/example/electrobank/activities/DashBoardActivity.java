package com.example.electrobank.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.electrobank.R;
import com.example.electrobank.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends AppCompatActivity {
    ActivityDashBoardBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.depositBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, DepositActivity.class));
        });
        mBinding.withdrawBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, WithdrawActivity.class));
        });
        mBinding.sendBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, SendMoneyActivity.class));
        });

        mBinding.logoutBtn.setOnClickListener(v -> {

        });

    }
}