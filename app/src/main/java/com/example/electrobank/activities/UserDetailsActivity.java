package com.example.electrobank.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.electrobank.R;
import com.example.electrobank.databinding.ActivityUserDetailsBinding;
import com.example.electrobank.model.UserDetails;
import com.example.electrobank.utils.BankDataBase;

import java.util.UUID;

public class UserDetailsActivity extends AppCompatActivity {

    ActivityUserDetailsBinding mBinding;
    BankDataBase mBankDataBase;
    UserDetails mUserDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= ActivityUserDetailsBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBankDataBase = BankDataBase.buildWith(openOrCreateDatabase(BankDataBase.ELECTRO_BANK_DB, MODE_PRIVATE, null));

//        mBinding.userNameText.setText(mBankDataBase.getBankUserData().get(Integer.parseInt(mUserDetails.getFirstName())));
        mBinding.loginBtb.setOnClickListener(v -> {
            startActivity(new Intent(this,LogInActivity.class));
            finish();
        });
        String myId = UUID.randomUUID().toString();
        mBinding.accountNum.setText(myId);


    }

}