package com.innovertech.gameon.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.innovertech.gameon.R;
import com.innovertech.gameon.model.Squad.Squad;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TeamTwoAdapter extends RecyclerView.Adapter<TeamTwoAdapter.CreateTeamViewHolder> {
    private Context context;
    private List<Squad> teamPlayerList;
    private OnTeamTwoItemClickListener onTeamTwoItemClickListener;


    public TeamTwoAdapter(Context context, List<Squad> teamPlayerList, OnTeamTwoItemClickListener onTeamTwoItemClickListener) {
        this.context = context;
        this.teamPlayerList = teamPlayerList;
        this.onTeamTwoItemClickListener = onTeamTwoItemClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public CreateTeamViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CreateTeamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_team2_players, null), onTeamTwoItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CreateTeamViewHolder holder, int position) {
        Squad squad = teamPlayerList.get(holder.getAdapterPosition());
        Glide.with(context).load(squad.getFlag()).override(42, 42).into(holder.countryFlagImageIV);
        holder.playerName.setText(squad.getName());
    }

    @Override
    public int getItemCount() {
        return teamPlayerList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class CreateTeamViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.countryFlagImageIV)
        ImageView countryFlagImageIV;
        @BindView(R.id.playerName)
        TextView playerName;
        @BindView(R.id.selectPlayerCard)
        CardView selectPlayerCard;


        public CreateTeamViewHolder(@NonNull @NotNull View itemView, OnTeamTwoItemClickListener onTeamTwoItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onTeamTwoItemClickListener.onTeamTwoItemClicked(itemView.findViewById(R.id.playerLayout),getAdapterPosition());
                }
            });
        }

    }

    public interface OnTeamTwoItemClickListener {
        void onTeamTwoItemClicked(View view,int position);
    }
}
