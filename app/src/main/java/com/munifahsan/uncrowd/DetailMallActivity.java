package com.munifahsan.uncrowd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailMallActivity extends AppCompatActivity {

    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.nama_mall)
    TextView mNama;
    @BindView(R.id.alamat_mall)
    TextView mAlamat;
    @BindView(R.id.jumlah_mall)
    TextView mJumlah;

    int posisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mall);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        posisi = intent.getIntExtra("posisi", 0);

        switch (posisi){
            case 0:
                mImage.setImageResource(R.drawable.image_java_mall_semarang);
                mNama.setText("Java Malll Semarang");
                mAlamat.setText("Jl. MT Haryono No. 992-994");
                mJumlah.setText("572/1000");
                break;
            case 1:
                mImage.setImageResource(R.drawable.image_dp_mall_semarang);
                mNama.setText("DP Mall Semarang");
                mAlamat.setText("Jl. Pemuda No.150");
                mJumlah.setText( "666/1000");
                break;
            case 2:
                mImage.setImageResource(R.drawable.image_paragon_mall_semarang);
                mNama.setText("Paragon Mall Semarang");
                mAlamat.setText("Jl. Pemuda No.115");
                mJumlah.setText("758/1000");
                break;
            case 3:
                mImage.setImageResource(R.drawable.image_mall_ciputra);
                mNama.setText("Mall ciputra");
                mAlamat.setText("jl. Simpang lima No.1");
                mJumlah.setText("583/1000");
                break;
        }
    }

    @OnClick(R.id.button_pesan)
    public void pesan(){
        Intent intent = new Intent(this, DipesanActivity.class);
        intent.putExtra("posisi", posisi);
        startActivity(intent);
        finish();
    }

}