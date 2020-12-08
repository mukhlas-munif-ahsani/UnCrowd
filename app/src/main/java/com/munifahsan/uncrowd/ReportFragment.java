package com.munifahsan.uncrowd;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

public class ReportFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;

    @BindView(R.id.editText_nama)
    EditText mNama;
    @BindView(R.id.editText_keterangan)
    EditText mKeterangan;

    @BindView(R.id.imageView_lapor)
    ImageView mImage;

    Handler handler = new Handler();

    boolean is = false;

    public ReportFragment() {
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
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            is = true;
            //hideTextPhoto();
            Glide.with(this).load(data.getData()).into(mImage);
        }
    }

    public void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @OnClick(R.id.imageView_lapor)
    public void image() {
        openFileChooser();
    }

    @OnClick(R.id.button_lapor)
    public void lapor() {
        if (is){
            if (!mNama.getText().toString().trim().isEmpty()) {
                if (!mKeterangan.getText().toString().trim().isEmpty()) {

//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
                            showMessage("Terkirim");
//                        }
//                    }, 2000);

                } else {
                    showMessage("Kterangna belum diisi !!");
                }

            } else {
                showMessage("Nama belum diisi !!");
            }
        } else {
            showMessage("Gambar belum dipilih");
        }

    }

    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
}