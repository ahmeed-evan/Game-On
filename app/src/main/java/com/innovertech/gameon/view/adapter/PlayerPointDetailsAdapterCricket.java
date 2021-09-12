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
import com.innovertech.gameon.model.PointHistoryDetails.PlayerPoint;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerPointDetailsAdapterCricket extends RecyclerView.Adapter<PlayerPointDetailsAdapterCricket.PointDetailsViewHolder> {

    private Context context;
    private List<PlayerPoint> playerPointDetailsList;

    public PlayerPointDetailsAdapterCricket(Context context, List<PlayerPoint> playerPointDetailsList) {
        this.playerPointDetailsList = playerPointDetailsList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public PointDetailsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new PointDetailsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_point_details, null));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PointDetailsViewHolder holder, int position) {
        PlayerPoint playerPoint = playerPointDetailsList.get(position);
        holder.playerName.setText(playerPoint.getPlayerName());
        holder.playerPointTv.setText(playerPoint.getPoint());
        Glide.with(context).load(playerPoint.getFlag()).override(32, 32).into(holder.flagIV);
        if (playerPoint.getCaptain()) {
            holder.captainTickIV.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return playerPointDetailsList.size();
    }

    class PointDetailsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.playerName)
        TextView playerName;
        @BindView(R.id.playerPointTv)
        TextView playerPointTv;
        @BindView(R.id.captainTickIV)
        ImageView captainTickIV;
        @BindView(R.id.flagIV)
        ImageView flagIV;

        public PointDetailsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}