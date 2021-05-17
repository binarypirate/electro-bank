package com.example.electrobank.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.example.electrobank.databinding.ActivityLogInBinding;
import com.example.electrobank.model.User;
import com.example.electrobank.model.UserDetails;
import com.example.electrobank.utils.BankDataBase;

public class LogInActivity extends AppCompatActivity {
    ActivityLogInBinding mBinding;
    BankDataBase mBankDataBase;
    UserDetails mUserDetails;
    User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.signUpBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        mBinding.loginBtn.setOnClickListener(v -> {
            String email = mBinding.emailEditTxt.getText().toString().trim();
            String password = mBinding.paswordEditText.getText().toString().trim();

           if (email.isEmpty()){
               mBinding.emailEditTxt.setError("Enter your Email");
           }else if (!(email.contains("@"))){
            mBinding.emailEditTxt.setError("Invalid Email");
            }else if (!(email.contains(".com"))){
               mBinding.emailEditTxt.setError("Invalid Email");
           } else if (password.isEmpty()){
               mBinding.paswordEditText.setError("Enter your Password");
           }else if (password.length() < 6) {
               mBinding.paswordEditText.setError("Invalid Password");
           }
               if (email.matches(String.valueOf(mBankDataBase.getUserDetails(email)))){
                   Log.d("Check", "Hello" + mUserDetails.email);
           }
//               if (email.equals(mBankDataBase.getUserDetails(mUserDetails.getId().toString()))){
//                   Toast.makeText(this, "Email Correct", Toast.LENGTH_SHORT).show();
//               }

//              if (email.equals(mBankDataBase.getUserDetails(email))){
//                  Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
//              }
//              if (.equals(mBankDataBase.getUserDetails(mUserDetails.email))){
//                  Toast.makeText(this, "Passed", Toast.LENGTH_SHORT).show();
//              }
//               Intent intent = new Intent(LogInActivity.this, DashBoardActivity.class);
//               startActivity(intent);
//            Toast.makeText(this, mUser.email, Toast.LENGTH_SHORT).show();
        });
    }
}