package com.example.andoridjavaex.mvpexample.loginex.contract;

public interface MVPLoginView {
    void showLoginValidationError(String message);
    void showLoginSuccess();
    void showLoginFail(String message);
}
