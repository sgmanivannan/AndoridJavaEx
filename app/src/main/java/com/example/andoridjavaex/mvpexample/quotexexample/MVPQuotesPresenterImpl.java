package com.example.andoridjavaex.mvpexample.quotexexample;

import java.util.Arrays;
import java.util.List;

public class MVPQuotesPresenterImpl implements MVPQuotesContract.Presenter, MVPQuotesContract.MVPGetQuoteInteractor.onFinishedListener {
    private MVPQuotesContract.View mView;
    MVPQuotesContract.MVPGetQuoteInteractor mMVPGetQuoteInteractor;

    public MVPQuotesPresenterImpl(MVPQuotesContract.View view, MVPQuotesContract.MVPGetQuoteInteractor MVPGetQuoteInteractor) {
        mView = view;
        mMVPGetQuoteInteractor = MVPGetQuoteInteractor;
    }

    @Override
    public void onGenerateQuoteButtonClick() {
        if(mView != null) {
            mView.showProgress();
        }
        mMVPGetQuoteInteractor.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onFinished(String text) {
        if(mView != null) {
            mView.showQuote(text);
            mView.hideProgress();
        }
    }
}
