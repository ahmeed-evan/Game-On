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
import com.innovertech.gameon.model.Squad.Squad;
import com.innovertech.gameon.view.interfaces.OnRecyclerItemClickListenerWithView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CaptainSelectorAdapter extends RecyclerView.Adapter<CaptainSelectorAdapter.CaptainSelectorViewHolder> {

    private List<Squad> squadList;
    private Context context;
    private OnRecyclerItemClickListenerWithView onRecyclerItemClickListenerWithView;
    private int lastItemPosition = -1;

    public CaptainSelectorAdapter(List<Squad> squadList, Context context, OnRecyclerItemClickListenerWithView onRecyclerItemClickListenerWithView) {
        this.squadList = squadList;
        this.context = context;
        this.onRecyclerItemClickListenerWithView = onRecyclerItemClickListenerWithView;
    }

    @NonNull
    @NotNull
    @Override
    public CaptainSelectorViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CaptainSelectorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_captain_selector, null), onRecyclerItemClickListenerWithView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CaptainSelectorViewHolder holder, int position) {
        Squad squad = squadList.get(position);
        holder.playerInfoTV.setText(squad.getName());
        if (position == lastItemPosition) {
            holder.selectorIV.setVisibility(View.VISIBLE);
        }
        Glide.with(context).load(squad.getFlag()).override(32, 32).into(holder.flagIV);
    }

    @Override
    public int getItemCount() {
        return squadList.size();
    }

    public class CaptainSelectorViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.playerInfoTV)
        TextView playerInfoTV;
        @BindView(R.id.selectorIV)
        ImageView selectorIV;
        @BindView(R.id.flagIV)
        ImageView flagIV;

        public CaptainSelectorViewHolder(@NonNull @NotNull View itemView, OnRecyclerItemClickListenerWithView onRecyclerItemClickListenerWithView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int copyOfLastCheckedPosition = lastItemPosition;
                    lastItemPosition = getAdapterPosition();
                    notifyItemChanged(copyOfLastCheckedPosition);
                    notifyItemChanged(lastItemPosition);
                    onRecyclerItemClickListenerWithView.onItemClicked(getAdapterPosition(), selectorIV);
                }
            });
        }
    }
}
