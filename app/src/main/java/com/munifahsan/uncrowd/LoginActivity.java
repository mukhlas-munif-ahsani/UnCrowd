package com.munifahsan.uncrowd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.textInputEmail)
    TextInputLayout mEmailLay;
    @BindView(R.id.editTextEmail)
    TextInputEditText mEmail;

    @BindView(R.id.textInputPass)
    TextInputLayout mPassLay;
    @BindView(R.id.editTextPass)
    TextInputEditText mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

         /*
        Change status bar color
         */
        Window window = this.getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));

    }

    @OnClick(R.id.textView_belum_memiliki_akun)
    public void navigateToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.button_login)
    public void navigateToMain() {

        if (!mEmail.getText().toString().trim().isEmpty()) {

            if (!mPass.getText().toString().trim().isEmpty()) {

                if (mEmail.getText().toString().equals("simulasi@uncrowd.com") && mPass.getText().toString().equals("simulasiuncrowd") ||
                        mEmail.getText().toString().equals("shallaziz@students.undip.ac.id") && mPass.getText().toString().equals("simulasiuncrowd") ||
                        mEmail.getText().toString().equals("ubbidahagusn@students.undip.ac.id") && mPass.getText().toString().equals("simulasiuncrowd") ||
                        mEmail.getText().toString().equals("cherlipermata@students.undip.ac.id") && mPass.getText().toString().equals("simulasiuncrowd")) {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    mEmailLay.setError("Email atau Password tidak valid");
                    mPassLay.setError("Email atau Password tidak valid");
                }

            } else {
                mPassLay.setError("Password tidak boleh kosong");
            }

        } else {
            mEmailLay.setError("Email tidak boloh kosong");
        }
    }
}