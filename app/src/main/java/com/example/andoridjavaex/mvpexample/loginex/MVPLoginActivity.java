package com.example.andoridjavaex.mvpexample.loginex;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.andoridjavaex.R;
import com.example.andoridjavaex.databinding.ActivityMvploginBinding;
import com.example.andoridjavaex.mvpexample.loginex.contract.MVPLoginPresenter;
import com.example.andoridjavaex.mvpexample.loginex.contract.MVPLoginView;

public class MVPLoginActivity extends AppCompatActivity implements MVPLoginView {
    ActivityMvploginBinding mBinding;

    MVPLoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvplogin);
        mPresenter = new MVPLoginPresenterImpl(this);

        mBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.handleLogin(mBinding.userName.getText().toString() , mBinding.password.getText().toString());
            }
        });
    }

    @Override
    public void showLoginValidationError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
