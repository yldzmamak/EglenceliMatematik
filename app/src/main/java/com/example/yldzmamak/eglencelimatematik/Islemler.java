package com.example.yldzmamak.eglencelimatematik;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Islemler extends AppCompatActivity  {

    ImageView btnToplama,btnCikarma,btnCarpma,btnBolme;
    String islem="" ;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islemler);

        MobileAds.initialize(this, "ca-app-pub-5507053716111047~3491574210");

        mAdView = (AdView) findViewById(R.id.adView_islemler); //Reklamın layoutda tanımladığımız idsini alıyoruz ve load ediyoruz.
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btnToplama = (ImageView) findViewById(R.id.btnToplama);
        btnCikarma = (ImageView) findViewById(R.id.btnCikarma);
        btnCarpma = (ImageView) findViewById(R.id.btnCarpma);
        btnBolme = (ImageView) findViewById(R.id.btnBolme);

        btnToplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem ="+";
                Intent intent = new Intent(Islemler.this, sorular.class);
                intent.putExtra("islem", islem);
                startActivity(intent);
                finish();
            }
        });
        btnCikarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem ="-";
                Intent intent = new Intent(Islemler.this, sorular.class);
                intent.putExtra("islem", islem);
                startActivity(intent);
                finish();
            }
        });
        btnCarpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem ="*";
                Intent intent = new Intent(Islemler.this, sorular.class);
                intent.putExtra("islem", islem);
                startActivity(intent);
                finish();
            }
        });
        btnBolme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                islem ="/";
                Intent intent = new Intent(Islemler.this, sorular.class);
                intent.putExtra("islem", islem);
                startActivity(intent);
                finish();
            }
        });

    }

}
