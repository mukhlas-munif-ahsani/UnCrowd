package com.munifahsan.uncrowd;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.munifahsan.uncrowd.adapters.MallAdapter;
import com.munifahsan.uncrowd.adapters.NewsAdapter;
import com.munifahsan.uncrowd.models.MallModel;
import com.munifahsan.uncrowd.models.NewsModel;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BerandaFragment extends Fragment {

    @BindView(R.id.recyclerView_mall)
    RecyclerView mRvMal;
    @BindView(R.id.recyclerView_berita)
    RecyclerView mRvNews;

    @BindView(R.id.timer_beranda)
    TextView mTimer;

    MallAdapter mallAdapter;
    NewsAdapter newsAdapter;
    private LinearLayoutManager mLayoutManager;

    data data;

    private static BerandaFragment instance;

    public static BerandaFragment getInstance() {
        return instance;
    }

    public BerandaFragment() {
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
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        ButterKnife.bind(this, view);

        instance = this;

        showMall();
        showNews();

        return view;
    }

    public void showMall() {
        ArrayList<MallModel> modelArrayList = new ArrayList<>();
        modelArrayList.add(new MallModel(R.drawable.image_java_mall_semarang, "Java Mall Semarang", "Jl. MT Haryono No. 992-994", "572/1000"));
        modelArrayList.add(new MallModel(R.drawable.image_dp_mall_semarang, "DP Mall Semarang", "Jl. Pemuda No.150", "666/1000"));
        modelArrayList.add(new MallModel(R.drawable.image_paragon_mall_semarang, "Paragon Mall Semarang", "Jl. Pemuda No.115", "758/1000"));
        modelArrayList.add(new MallModel(R.drawable.image_mall_ciputra, "Mall ciputra", "jl. Simpang lima No.1", "583/1000"));

        mallAdapter = new MallAdapter(modelArrayList);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRvMal.setHasFixedSize(true);
        mRvMal.setLayoutManager(mLayoutManager);
        mRvMal.setAdapter(mallAdapter);

        mallAdapter.setOnItemClickListener(new MallAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), DetailMallActivity.class);
                Log.d("posisi", String.valueOf(position));
                intent.putExtra("posisi", position);
                startActivity(intent);
            }
        });
    }

    public void showNews() {
        ArrayList<NewsModel> modelArrayList = new ArrayList<>();
        modelArrayList.add(new NewsModel(R.drawable.covid, "COVID - 19 di indonesia semakin meningkat", ""));
        modelArrayList.add(new NewsModel(R.drawable.covidan, "Penanganan COVID di indonesia", ""));

        newsAdapter = new NewsAdapter(modelArrayList);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRvNews.setHasFixedSize(true);
        mRvNews.setLayoutManager(mLayoutManager);
        mRvNews.setAdapter(newsAdapter);
    }

    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    public void showTimer(){
        new CountDownTimer(10800000, 1000) {

            @Override
            public void onTick(long l) {
                @SuppressLint("DefaultLocale") String hms = String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(l),
                        TimeUnit.MILLISECONDS.toMinutes(l) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(l)),
                        TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));

                mTimer.setText(hms);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

}