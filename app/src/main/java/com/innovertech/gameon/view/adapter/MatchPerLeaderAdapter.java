package com.innovertech.gameon.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.innovertech.gameon.R;
import com.innovertech.gameon.model.MatchPerLeader.MatchPerLeaderBoard;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MatchPerLeaderAdapter extends RecyclerView.Adapter<MatchPerLeaderAdapter.MatchPerLeadersViewHolder> {
    private Context context;
    private List<MatchPerLeaderBoard> matchPerLeaders;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public MatchPerLeaderAdapter(Context context,
                                 List<MatchPerLeaderBoard> matchPerLeaders,
                                 OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.context = context;
        this.matchPerLeaders = matchPerLeaders;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    @NonNull
    @Override
    public MatchPerLeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MatchPerLeadersViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_match_per_leader, null), onRecyclerItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchPerLeadersViewHolder holder, int position) {
        MatchPerLeaderBoard matchPerLeaderBoard = matchPerLeaders.get(position);
        holder.rankingTV.setText(String.valueOf(matchPerLeaderBoard.getRank()));
        holder.rankerNameTV.setText(matchPerLeaderBoard.getName());
        holder.rankerPointTV.setText(matchPerLeaderBoard.getPoint());
    }

    @Override
    public int getItemCount() {
        return matchPerLeaders.size();
    }

    public class MatchPerLeadersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.matchPerRankingTV)
        TextView rankingTV;
        @BindView(R.id.matchPerRankerNameTV)
        TextView rankerNameTV;
        @BindView(R.id.matchPerRankerPointTV)
        TextView rankerPointTV;
        @BindView(R.id.seeDetailIV)
        ImageView seeDetailIV;


        public MatchPerLeadersViewHolder(@NonNull View itemView,
                                         OnRecyclerItemClickListener onRecyclerItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.seeDetailIV)
        void seeDetailsClicked() {
            onRecyclerItemClickListener.onOptionItemCLicked(getAdapterPosition());
        }

    }
}
