package com.munifahsan.uncrowd;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import butterknife.BindView;
import butterknife.ButterKnife;

public class QrFragment extends Fragment {


    @BindView(R.id.imageView_qr)
    ImageView mQrImage;
    @BindView(R.id.textView_timer)
    TextView mTimer;
    @BindView(R.id.cardContentExist)
    CardView mContent;
    @BindView(R.id.cardContentNotExist)
    CardView mNoContent;

    private static QrFragment instance;

    public static QrFragment getInstance(){
        return instance;
    }

    public QrFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qr, container, false);

        ButterKnife.bind(this, view);
        instance = this;

        new CountDownTimer(600000, 1000){

            @Override
            public void onTick(long l) {
                @SuppressLint("DefaultLocale")   String hms = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                mTimer.setText(hms);
            }

            @Override
            public void onFinish() {

            }
        }.start();

        loadQrCode("Ardi Haryono");
        return view;
    }

    public void loadQrCode(String data) {
        QRGEncoder qrgEncoder = new QRGEncoder(data, null, QRGContents.Type.TEXT, 800);
        qrgEncoder.setColorBlack(getActivity().getResources().getColor(R.color.black));
        qrgEncoder.setColorWhite(getActivity().getResources().getColor(R.color.white));
        try {
            Bitmap bitmap = qrgEncoder.getBitmap();
            mQrImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.v("QR Eror", e.toString());
        }
    }

    public void showContent(){
        mContent.setVisibility(View.VISIBLE);
        mNoContent.setVisibility(View.GONE);
    }

}