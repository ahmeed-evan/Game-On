package com.innovertech.gameon.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.innovertech.gameon.R;
import com.innovertech.gameon.model.CricketMatchHistory.CricketMatchHistoryData;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CricketMatchHistoryAdapter extends RecyclerView.Adapter<CricketMatchHistoryAdapter.MatchHistoryViewHolder> {

    private Context context;
    private List<CricketMatchHistoryData> cricketMatchHistoryData;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public CricketMatchHistoryAdapter(Context context, List<CricketMatchHistoryData> cricketMatchHistoryData, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.context = context;
        this.cricketMatchHistoryData = cricketMatchHistoryData;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public MatchHistoryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MatchHistoryViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.list_item_layout_match_history, null), onRecyclerItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MatchHistoryViewHolder holder, int position) {
        CricketMatchHistoryData historyData= cricketMatchHistoryData.get(position);
        holder.matchNameTV.setText(historyData.getTeam1()+" VS "+historyData.getTeam2());
        Glide.with(context).load(historyData.getBoardFlag1()).override(90,100).into(holder.teamOneIV);
        Glide.with(context).load(historyData.getBoardFlag2()).override(90,100).into(holder.teamTwoIV);
    }

    @Override
    public int getItemCount() {
        return cricketMatchHistoryData.size();
    }

    public class MatchHistoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.matchNameTV)
        TextView matchNameTV;
        @BindView(R.id.teamOneIV)
        ImageView teamOneIV;
        @BindView(R.id.teamTwoIV)
        ImageView teamTwoIV;
        @BindView(R.id.seeResultTextTV)
        TextView seeResultTextTV;

        public MatchHistoryViewHolder(@NonNull @NotNull View itemView, OnRecyclerItemClickListener onRecyclerItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecyclerItemClickListener.onOptionItemCLicked(getAdapterPosition());
                }
            });
        }
    }
}
