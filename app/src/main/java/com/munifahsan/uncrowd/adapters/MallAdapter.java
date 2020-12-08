package com.munifahsan.uncrowd.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.munifahsan.uncrowd.models.MallModel;
import com.munifahsan.uncrowd.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.Holder> {

    private ArrayList<MallModel> mData;

    public MallAdapter(ArrayList<MallModel> mData) {
        this.mData = mData;
    }

    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public MallAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mall, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MallAdapter.Holder holder, int position) {
        holder.mImage.setImageResource(mData.get(position).getImage());
        holder.mTitle.setText(mData.get(position).getTitle());
        holder.mDesc.setText(mData.get(position).getDesc());
        holder.mJumlah.setText(mData.get(position).getJumlah());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imageView_thumbnailMall)
        ImageView mImage;
        @BindView(R.id.textView_mall_title)
        TextView mTitle;
        @BindView(R.id.textView_mall_desc)
        TextView mDesc;
        @BindView(R.id.textView_mall_jumlah)
        TextView mJumlah;
        @BindView(R.id.rel_item)
        RelativeLayout mRel;

        public Holder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            mRel.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }
    }
}
