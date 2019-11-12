package com.example.andoridjavaex.mvpexample.loginex;

import android.text.TextUtils;

import com.example.andoridjavaex.mvpexample.loginex.contract.MVPLoginPresenter;
import com.example.andoridjavaex.mvpexample.loginex.contract.MVPLoginView;

public class MVPLoginPresenterImpl implements MVPLoginPresenter {

    MVPLoginView mMVPLoginView;

    public MVPLoginPresenterImpl(MVPLoginView MVPLoginView) {
        mMVPLoginView = MVPLoginView;
    }

    @Override
    public void handleLogin(String userName, String password) {
        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            mMVPLoginView.showLoginValidationError("User Name OR Password cannot be Empty");
        } else {
            if(userName.equals("admin") && password.equals("admin")) {
                mMVPLoginView.showLoginSuccess();
            } else {
                mMVPLoginView.showLoginFail("Invalid Username OR Password");
            }
        }
    }
}
