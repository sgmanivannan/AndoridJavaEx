package com.example.andoridjavaex.mvpexample.quotexexample;

public interface MVPQuotesContract {

    interface View {
        void showProgress();
        void hideProgress();
        void showQuote(String quote);
    }

    interface Presenter {

        void onGenerateQuoteButtonClick();

        void onDestroy();

    }

    interface MVPGetQuoteInteractor {
        interface onFinishedListener {
            void onFinished(String text);
        }

        void getNextQuote(onFinishedListener onFinishedListener);
    }
}
