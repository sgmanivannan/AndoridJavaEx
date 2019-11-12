package com.example.andoridjavaex.mvpexample.quotexexample;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.andoridjavaex.R;
import com.example.andoridjavaex.databinding.ActivityMvpquotesBinding;

public class MVPQuotesActivity extends AppCompatActivity implements MVPQuotesContract.View{
    ActivityMvpquotesBinding mBinding;
    MVPQuotesContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvpquotes);

        mPresenter = new MVPQuotesPresenterImpl(this, new MVPGetQuoteInteractorImpl());

        mBinding.generateQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onGenerateQuoteButtonClick();
            }
        });


    }

    @Override
    public void showProgress() {
        mBinding.progressBar.setVisibility(View.VISIBLE);
        mBinding.quotesValue.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mBinding.progressBar.setVisibility(View.GONE);
        mBinding.quotesValue.setVisibility(View.VISIBLE);
    }

    @Override
    public void showQuote(String quote) {
        mBinding.quotesValue.setText(quote);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }
}
