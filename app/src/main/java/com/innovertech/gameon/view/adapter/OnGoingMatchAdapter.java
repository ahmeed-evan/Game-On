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
import com.innovertech.gameon.model.Match.MatchData;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnGoingMatchAdapter extends RecyclerView.Adapter<OnGoingMatchAdapter.OnGoingMatchViewHolder> {

    private final List<MatchData> matchDataList;
    private final Context context;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public OnGoingMatchAdapter(List<MatchData> matchDataList, Context context, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.matchDataList = matchDataList;
        this.context = context;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public OnGoingMatchViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new OnGoingMatchViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_on_going_match, null), onRecyclerItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OnGoingMatchViewHolder holder, int position) {
        MatchData matchData = matchDataList.get(position);
        holder.matchNameTV.setText(matchData.getTeam1() + " VS " + matchData.getTeam2());
        if (matchData.getPlayed().equals("1")) {
            holder.matchTimeTV.setText("Already Participated");
        }
        Glide.with(context).load(matchData.getBoardFlag1()).override(90, 100).into(holder.teamOneIV);
        Glide.with(context).load(matchData.getBoardFlag2()).override(90, 100).into(holder.teamTwoIV);
    }

    @Override
    public int getItemCount() {
        return matchDataList.size();
    }

    public class OnGoingMatchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.matchNameTV)
        TextView matchNameTV;
        @BindView(R.id.teamOneIV)
        ImageView teamOneIV;
        @BindView(R.id.teamTwoIV)
        ImageView teamTwoIV;
        @BindView(R.id.matchTimeTV)
        TextView matchTimeTV;


        public OnGoingMatchViewHolder(@NonNull @NotNull View itemView, OnRecyclerItemClickListener onRecyclerItemClickListener) {
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
