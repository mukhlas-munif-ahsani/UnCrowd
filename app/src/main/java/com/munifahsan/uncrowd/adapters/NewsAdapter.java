package com.munifahsan.uncrowd.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.munifahsan.uncrowd.R;
import com.munifahsan.uncrowd.models.MallModel;
import com.munifahsan.uncrowd.models.NewsModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder> {

    private ArrayList<NewsModel> mData;

    public NewsAdapter(ArrayList<NewsModel> mData) {
        this.mData = mData;
    }

    public void addCardItem(NewsModel item) {
        mData.add(item);
    }

    @NonNull
    @Override
    public NewsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.Holder holder, int position) {
        holder.mImage.setImageResource(mData.get(position).getImage());
        holder.mTitle.setText(mData.get(position).getTitle());
        holder.mJumlah.setText(mData.get(position).getJumlah());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView_thumbnailMall)
        ImageView mImage;
        @BindView(R.id.textView_mall_title)
        TextView mTitle;
        @BindView(R.id.textView_mall_jumlah)
        TextView mJumlah;

        public Holder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }
}
