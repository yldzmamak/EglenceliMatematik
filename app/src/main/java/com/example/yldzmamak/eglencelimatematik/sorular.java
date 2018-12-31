package com.example.yldzmamak.eglencelimatematik;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class sorular extends AppCompatActivity implements View.OnClickListener {
    Integer a,b;
    ImageView isaret,sayi1,sayi2;
    Button btn1, btn2, btn3, btn4, btnSayi,puan;
    TextView timerValue;
    String islem;
    int cevap,sayi=0;
    int number ;
    int n = 0;
    int min = 0;
    int max = 9;
    int sayibir;
    int sayiiki;
    CountDownTimer countDownTimer;
    private AdView mAdView;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(sorular.this, Islemler.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorular);

        MobileAds.initialize(this, "ca-app-pub-5507053716111047~3491574210");

        mAdView = (AdView) findViewById(R.id.adView_sorular); //Reklamın layoutda tanımladığımız idsini alıyoruz ve load ediyoruz.
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btnSayi = (Button) findViewById(R.id.sayi);
        puan = (Button) findViewById(R.id.puan);

        isaret = (ImageView) findViewById(R.id.islem);
        sayi1 = (ImageView) findViewById(R.id.sayi1);
        sayi2 = (ImageView) findViewById(R.id.sayi2);

        timerValue = (TextView) findViewById(R.id.zaman);

        Intent i = getIntent();
        islem = i.getStringExtra("islem");

        islem(islem);
    }
    int sonuc=0;
    @Override
    public void onClick(View view) {
        Handler handler = new Handler();
        switch (view.getId()) {
            case R.id.btn1:
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                if(cevap == Integer.parseInt( btn1.getText().toString())){
                    sonuc++;
                    btn1.setBackgroundColor(getResources().getColor(R.color.dogru));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);

                } else {
                    btn1.setBackgroundColor(getResources().getColor(R.color.yanlis));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);
                }
                break;

            case R.id.btn2:
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                if(cevap == Integer.parseInt( btn2.getText().toString())){
                    sonuc++;
                    btn2.setBackgroundColor(getResources().getColor(R.color.dogru));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);

                }else {
                    btn2.setBackgroundColor(getResources().getColor(R.color.yanlis));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);
                }
                break;

            case R.id.btn3:
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                if(cevap == Integer.parseInt( btn3.getText().toString())){
                    sonuc++;
                    btn3.setBackgroundColor(getResources().getColor(R.color.dogru));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);

                } else {
                    btn3.setBackgroundColor(getResources().getColor(R.color.yanlis));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);
                }
                break;

            case R.id.btn4:
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                if(cevap == Integer.parseInt( btn4.getText().toString())){
                    sonuc++;
                    btn4.setBackgroundColor(getResources().getColor(R.color.dogru));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);

                } else {
                    btn4.setBackgroundColor(getResources().getColor(R.color.yanlis));
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            islem(islem);
                        }
                    }, 2000);
                }
                break;

            default:
                break;
        }

    }

    public void toplama(){

        isaret.setImageResource(R.drawable.arti);
        min = 0;
        max = 9;
        n=0;

        sayibir = new Random().nextInt((max - min) + 1) + min;
        sayiiki = new Random().nextInt((max - min) + 1) + min;

        cevap = sayibir+sayiiki;
        int [] cevaplar={cevap-1,cevap,cevap+1,cevap+2};

        switch (sayibir){
            case 0: a = R.drawable.sayi0;break;
            case 1: a = R.drawable.sayi1;break;
            case 2: a = R.drawable.sayi2;break;
            case 3: a = R.drawable.sayi3;break;
            case 4: a = R.drawable.sayi4;break;
            case 5: a = R.drawable.sayi5;break;
            case 6: a = R.drawable.sayi6;break;
            case 7: a = R.drawable.sayi7;break;
            case 8: a = R.drawable.sayi8;break;
            case 9: a = R.drawable.sayi9;break;
        }
        sayi1.setImageResource(a);

        switch (sayiiki){
            case 0: b = R.drawable.sayi0;break;
            case 1: b = R.drawable.sayi1;break;
            case 2: b = R.drawable.sayi2;break;
            case 3: b = R.drawable.sayi3;break;
            case 4: b = R.drawable.sayi4;break;
            case 5: b = R.drawable.sayi5;break;
            case 6: b = R.drawable.sayi6;break;
            case 7: b = R.drawable.sayi7;break;
            case 8: b = R.drawable.sayi8;break;
            case 9: b = R.drawable.sayi9;break;
        }
        sayi2.setImageResource(b);
        //listis = false;
        List< Integer > numbersToplam = new ArrayList< >();
        while (n < 4) {
            boolean listis = false;

            Random rand = new Random();
            number = rand.nextInt(cevaplar.length);
            for (int k = 0; k <= 3; k++) {
                if (numbersToplam.contains(number)) {
                    listis = true;
                    break;
                }
                if (!listis) {
                    numbersToplam.add(number);
                    n += 1;
                }
            }

        }

        btn1.setText(String.valueOf(cevaplar[numbersToplam.get(0)]));
        btn2.setText(String.valueOf(cevaplar[numbersToplam.get(1)]));
        btn3.setText(String.valueOf(cevaplar[numbersToplam.get(2)]));
        btn4.setText(String.valueOf(cevaplar[numbersToplam.get(3)]));

       btn1.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
       btn2.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
       btn3.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
       btn4.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
    }

    public void cikarma(){

        isaret.setImageResource(R.drawable.eksi);
        min = 0;
        max = 9;
        n=0;

        sayibir = new Random().nextInt((max - min) + 1) + min;
        sayiiki = new Random().nextInt((max - sayibir) + 1) + sayibir;

        cevap = sayiiki-sayibir;
        int [] cevaplarCikarma={cevap-1,cevap,cevap+1,cevap+2};

        switch (sayiiki){
            case 0: a = R.drawable.sayi0;break;
            case 1: a = R.drawable.sayi1;break;
            case 2: a = R.drawable.sayi2;break;
            case 3: a = R.drawable.sayi3;break;
            case 4: a = R.drawable.sayi4;break;
            case 5: a = R.drawable.sayi5;break;
            case 6: a = R.drawable.sayi6;break;
            case 7: a = R.drawable.sayi7;break;
            case 8: a = R.drawable.sayi8;break;
            case 9: a = R.drawable.sayi9;break;
        }
        sayi1.setImageResource(a);

        switch (sayibir){
            case 0: b = R.drawable.sayi0;break;
            case 1: b = R.drawable.sayi1;break;
            case 2: b = R.drawable.sayi2;break;
            case 3: b = R.drawable.sayi3;break;
            case 4: b = R.drawable.sayi4;break;
            case 5: b = R.drawable.sayi5;break;
            case 6: b = R.drawable.sayi6;break;
            case 7: b = R.drawable.sayi7;break;
            case 8: b = R.drawable.sayi8;break;
            case 9: b = R.drawable.sayi9;break;
        }
        sayi2.setImageResource(b);
        List< Integer > numbersCikarma = new ArrayList< >();
        //listis = false;
        while (n < 4) {
            boolean listis = false;
            Random rand = new Random();
            number = rand.nextInt(cevaplarCikarma.length);
            for (int k = 0; k <= 3; k++) {
                if (numbersCikarma.contains(number)) {
                    listis = true;
                    break;
                }
                if (!listis) {
                    numbersCikarma.add(number);
                    n += 1;
                }
            }
        }
        btn1.setText(String.valueOf(cevaplarCikarma[numbersCikarma.get(0)]));
        btn2.setText(String.valueOf(cevaplarCikarma[numbersCikarma.get(1)]));
        btn3.setText(String.valueOf(cevaplarCikarma[numbersCikarma.get(2)]));
        btn4.setText(String.valueOf(cevaplarCikarma[numbersCikarma.get(3)]));

        btn1.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn2.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn3.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn4.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
    }

    private void carpma() {

        isaret.setImageResource(R.drawable.carpma);
        min = 0;
        max = 9;
        n=0;

        sayibir = new Random().nextInt((max - min) + 1) + min;
        sayiiki = new Random().nextInt((max - min) + 1) + min;

        cevap = sayiiki*sayibir;
        int [] cevaplarCarpma={cevap-1,cevap,cevap+1,cevap+2};

        switch (sayibir){
            case 0: a = R.drawable.sayi0;break;
            case 1: a = R.drawable.sayi1;break;
            case 2: a = R.drawable.sayi2;break;
            case 3: a = R.drawable.sayi3;break;
            case 4: a = R.drawable.sayi4;break;
            case 5: a = R.drawable.sayi5;break;
            case 6: a = R.drawable.sayi6;break;
            case 7: a = R.drawable.sayi7;break;
            case 8: a = R.drawable.sayi8;break;
            case 9: a = R.drawable.sayi9;break;
        }
        sayi1.setImageResource(a);

        switch (sayiiki){
            case 0: b = R.drawable.sayi0;break;
            case 1: b = R.drawable.sayi1;break;
            case 2: b = R.drawable.sayi2;break;
            case 3: b = R.drawable.sayi3;break;
            case 4: b = R.drawable.sayi4;break;
            case 5: b = R.drawable.sayi5;break;
            case 6: b = R.drawable.sayi6;break;
            case 7: b = R.drawable.sayi7;break;
            case 8: b = R.drawable.sayi8;break;
            case 9: b = R.drawable.sayi9;break;
        }
        sayi2.setImageResource(b);
        List< Integer > numbersCarpma = new ArrayList< >();
        //listis = false;
        while (n < 4) {
            boolean listis = false;
            Random rand = new Random();
            number = rand.nextInt(cevaplarCarpma.length);
            for (int k = 0; k <= 3; k++) {
                if (numbersCarpma.contains(number)) {
                    listis = true;
                    break;
                }
                if (!listis) {
                    numbersCarpma.add(number);
                    n += 1;
                }
            }
        }
        btn1.setText(String.valueOf(cevaplarCarpma[numbersCarpma.get(0)]));
        btn2.setText(String.valueOf(cevaplarCarpma[numbersCarpma.get(1)]));
        btn3.setText(String.valueOf(cevaplarCarpma[numbersCarpma.get(2)]));
        btn4.setText(String.valueOf(cevaplarCarpma[numbersCarpma.get(3)]));

        btn1.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn2.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn3.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn4.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
    }

    public void bolme(){

        isaret.setImageResource(R.drawable.bolme);
        min = 1;
        max = 20;
        n=0;

        sayibir = new Random().nextInt((max - min) + 1) + min;
        List< Integer > sayi = new ArrayList< >();
        // int sayi[] = new int[6];
        int deger=0;
        for (int k = 1; k <= sayibir; k++)
        {
            if(sayibir % k == 0)
            {
                sayi.add(k);

            }
        }

        deger = new Random().nextInt(sayi.size());
        sayiiki = sayi.get(deger);
        cevap = sayibir/sayiiki;
        int [] cevaplarBolme={cevap-1,cevap,cevap+1,cevap+2};

        switch (sayibir){
            case 0: a = R.drawable.sayi0;break;
            case 1: a = R.drawable.sayi1;break;
            case 2: a = R.drawable.sayi2;break;
            case 3: a = R.drawable.sayi3;break;
            case 4: a = R.drawable.sayi4;break;
            case 5: a = R.drawable.sayi5;break;
            case 6: a = R.drawable.sayi6;break;
            case 7: a = R.drawable.sayi7;break;
            case 8: a = R.drawable.sayi8;break;
            case 9: a = R.drawable.sayi9;break;
            case 10: a = R.drawable.sayi10;break;
            case 11: a = R.drawable.sayi11;break;
            case 12: a = R.drawable.sayi12;break;
            case 13: a = R.drawable.sayi13;break;
            case 14: a = R.drawable.sayi14;break;
            case 15: a = R.drawable.sayi15;break;
            case 16: a = R.drawable.sayi16;break;
            case 17: a = R.drawable.sayi17;break;
            case 18: a = R.drawable.sayi18;break;
            case 19: a = R.drawable.sayi19;break;
            case 20: a = R.drawable.sayi20;break;

        }
        sayi1.setImageResource(a);

        switch (sayiiki){
            case 0: b = R.drawable.sayi0;break;
            case 1: b = R.drawable.sayi1;break;
            case 2: b = R.drawable.sayi2;break;
            case 3: b = R.drawable.sayi3;break;
            case 4: b = R.drawable.sayi4;break;
            case 5: b = R.drawable.sayi5;break;
            case 6: b = R.drawable.sayi6;break;
            case 7: b = R.drawable.sayi7;break;
            case 8: b = R.drawable.sayi8;break;
            case 9: b = R.drawable.sayi9;break;
            case 10: b = R.drawable.sayi10;break;
            case 11: b = R.drawable.sayi11;break;
            case 12: b = R.drawable.sayi12;break;
            case 13: b = R.drawable.sayi13;break;
            case 14: b = R.drawable.sayi14;break;
            case 15: b = R.drawable.sayi15;break;
            case 16: b = R.drawable.sayi16;break;
            case 17: b = R.drawable.sayi17;break;
            case 18: b = R.drawable.sayi18;break;
            case 19: b = R.drawable.sayi19;break;
            case 20: b = R.drawable.sayi20;break;
        }
        sayi2.setImageResource(b);
        List< Integer > numbersBolme = new ArrayList< >();
        //listis = false;
        while (n < 4) {
            boolean listis = false;
            Random rand = new Random();
            number = rand.nextInt(cevaplarBolme.length);
            for (int k = 0; k <= 3; k++) {
                if (numbersBolme.contains(number)) {
                    listis = true;
                    break;
                }
                if (!listis) {
                    numbersBolme.add(number);
                    n += 1;
                }
            }
        }
        btn1.setText(String.valueOf(cevaplarBolme[numbersBolme.get(0)]));
        btn2.setText(String.valueOf(cevaplarBolme[numbersBolme.get(1)]));
        btn3.setText(String.valueOf(cevaplarBolme[numbersBolme.get(2)]));
        btn4.setText(String.valueOf(cevaplarBolme[numbersBolme.get(3)]));

        btn1.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn2.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn3.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
        btn4.setBackground(getResources().getDrawable(R.drawable.satir_arkaplan));
    }

    public void islem(final String islem){
        btn1.setClickable(true);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(true);
        Handler handler = new Handler();
        sayi++;
        if(sayi == 21){
            sonuc=sonuc*5;
            puan.setVisibility(View.VISIBLE);
            puan.setText(String.valueOf(sonuc));
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_animation);
            puan.startAnimation(animation);

            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(sorular.this, Islemler.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);

        }else {
            if(countDownTimer!=null){
                countDownTimer.cancel();
            }
            countDownTimer = new CountDownTimer(16000, 1000) {
                public void onTick(long millisUntilFinished) {

                    timerValue.setText(String.valueOf(millisUntilFinished / 1000));
                    //here you can have your logic to set text to edittext
                }

                public void onFinish() {
                    cancel();
                    islem(islem);
                }
            }.start();

            btnSayi.setText(sayi + "/20");
            switch (islem) {
                case "+":
                    toplama();
                    break;

                case "-":
                    cikarma();
                    break;

                case "*":
                    carpma();
                    break;

                case "/":
                    bolme();
                    break;
            }
        }
    }
}


