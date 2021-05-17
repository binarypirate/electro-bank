package com.example.electrobank.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.electrobank.R;
import com.example.electrobank.databinding.ActivityRegisterBinding;
import com.example.electrobank.model.UserDetails;
import com.example.electrobank.utils.BankDataBase;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding mBinding;
    BankDataBase mBankDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBankDataBase = BankDataBase.buildWith(openOrCreateDatabase(BankDataBase.ELECTRO_BANK_DB, MODE_PRIVATE, null));


        mBinding.loginTxt.setOnClickListener(v -> {
           Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
           startActivity(intent);
       });

        mBinding.registerBtn.setOnClickListener(v -> {
            String firstName = mBinding.firstNameEditText.getText().toString().trim();
            String lastName = mBinding.lastNameEditTxt.getText().toString().trim();
            String email = mBinding.emailEditText.getText().toString().trim();
            String password = mBinding.paswordEdittxt.getText().toString().trim();

            if (firstName.isEmpty()){
                mBinding.firstNameEditText.setError("Enter first name");
            }else if (lastName.isEmpty()){
                mBinding.lastNameEditTxt.setError("Enter your Last Name");
            }else if (email.isEmpty()){
                mBinding.emailEditText.setError("Enter your Email Address");
            }else if (!(email.contains("@"))){
                mBinding.emailEditText.setError("Invalid Email Address");
            }else if ( !(email.contains(".com"))){
                mBinding.emailEditText.setError("Invalid Email Address");
            }
            else if (password.length() < 6){
                mBinding.paswordEdittxt.setError("Invalid! Minimum Length is 6");
            }else {
                mBankDataBase.saveBankData(new UserDetails(firstName, lastName, email, password));
                Toast.makeText(this, "DataBase created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, UserDetailsActivity.class));
                finish();
            }
        });
    }
}