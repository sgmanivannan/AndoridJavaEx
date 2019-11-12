package com.example.andoridjavaex.mvpexample.quotexexample;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MVPGetQuoteInteractorImpl implements MVPQuotesContract.MVPGetQuoteInteractor {
    private List<String> arrayList = Arrays.asList(
            "முளையில் கிள்ளாதது முற்றினால், கோடாலிகொண்டு வெட்ட வேண்டும் .",
            "கேட்டதெல்லாம் நம்பாதே? நம்பியதெல்லாம் சொல்லாதே?",
            "சொல்வல்லவனை வெல்லல் அரிது.",
            "எளியவன் பெண்டாட்டி எல்லோருக்கும் மைத்துனி.",
            "இந்தக் கூழுக்கா இருபத்தெட்டு நாமம்!",
            "நுணலும் தன் வாயால் கெடும்.",
            "கட்டிக்கொடுத்த சோறும் கற்றுக்கொடுத்த சொல்லும் எத்தனை நாள் நிற்கும்.",
            "கொடுக்கிறவனைக் கண்டால் வாங்குகிறவனுக்கு இளக்காரம்.",
            "உழக்கு மிளகு கொடுப்பானேன் , ஒளிந்திருந்து மிளகு சாரு குடிப்பானேன் ?",
            "கழுதைக்குப் பரதேசம் குட்டிச்சுவர்."
    );

    @Override
    public void getNextQuote(final onFinishedListener onFinishedListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListener.onFinished(arrayList.get(new Random().nextInt(arrayList.size())));
            }
        }, 1200);
    }
}
