package com.innovertech.gameon.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.innovertech.gameon.R;
import com.innovertech.gameon.model.Leaderboard;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.LeaderboardViewHolder> {

    private List<Leaderboard> leaderBoardList;
    private Context context;

    public LeaderBoardAdapter(List<Leaderboard> leaderBoardList, Context context) {
        this.leaderBoardList = leaderBoardList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new LeaderboardViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_leaderboard, null));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LeaderboardViewHolder holder, int position) {

        Leaderboard leaderboard = leaderBoardList.get(position);

        holder.rankingTV.setText(String.valueOf(leaderboard.getRank()));
        holder.rankerNameTV.setText(leaderboard.getName());
        holder.rankerPointTV.setText(leaderboard.getPoint());
    }

    @Override
    public int getItemCount() {
        return leaderBoardList.size();
    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rankingTV)
        TextView rankingTV;
        @BindView(R.id.rankerNameTV)
        TextView rankerNameTV;
        @BindView(R.id.rankerPointTV)
        TextView rankerPointTV;

        public LeaderboardViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
