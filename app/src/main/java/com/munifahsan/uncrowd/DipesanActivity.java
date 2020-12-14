package com.munifahsan.uncrowd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DipesanActivity extends AppCompatActivity {

    @BindView(R.id.imageView_qr)
    ImageView mQrImage;
    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.nama_mall)
    TextView mNama;
    @BindView(R.id.jumlah_mall)
    TextView mJumlah;

    int posisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dipesan);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        posisi = intent.getIntExtra("posisi", 0);

        switch (posisi){
            case 0:
                mImage.setImageResource(R.drawable.image_java_mall_semarang);
                mNama.setText("Java Malll Semarang");
                mJumlah.setText("573/1000");
                break;
            case 1:
                mImage.setImageResource(R.drawable.image_dp_mall_semarang);
                mNama.setText("DP Mall Semarang");
                mJumlah.setText( "667/1000");
                break;
            case 2:
                mImage.setImageResource(R.drawable.image_paragon_mall_semarang);
                mNama.setText("Paragon Mall Semarang");
                mJumlah.setText("759/1000");
                break;
            case 3:
                mImage.setImageResource(R.drawable.image_mall_ciputra);
                mNama.setText("Mall ciputra");
                mJumlah.setText("584/1000");
                break;
        }

        loadQrCode("UnCrowd App 2020");
    }

    public void loadQrCode(String data) {
        QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 800);
        qrgEncoder.setColorBlack(this.getResources().getColor(R.color.black));
        qrgEncoder.setColorWhite(this.getResources().getColor(R.color.white));
        try {
            Bitmap bitmap = qrgEncoder.getBitmap();
            mQrImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.v("QR Eror", e.toString());
        }
    }

    @OnClick(R.id.button_batal)
    public void batal(){
        finish();
    }
}