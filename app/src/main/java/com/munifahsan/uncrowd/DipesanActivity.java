package com.munifahsan.uncrowd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DipesanActivity extends AppCompatActivity {

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
                mJumlah.setText("572/1000");
                break;
            case 1:
                mImage.setImageResource(R.drawable.image_dp_mall_semarang);
                mNama.setText("DP Mall Semarang");
                mJumlah.setText( "666/1000");
                break;
            case 2:
                mImage.setImageResource(R.drawable.image_paragon_mall_semarang);
                mNama.setText("Paragon Mall Semarang");
                mJumlah.setText("758/1000");
                break;
            case 3:
                mImage.setImageResource(R.drawable.image_mall_ciputra);
                mNama.setText("Mall ciputra");
                mJumlah.setText("583/1000");
                break;
        }
    }

    @OnClick(R.id.button_batal)
    public void batal(){
        finish();
    }
}