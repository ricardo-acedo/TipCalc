package com.android.acedori.tipcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.acedori.tipcalc.R;
import com.android.acedori.tipcalc.models.TipRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by acedori on 09/06/2016.
 */
public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {
    private List<TipRecord> dataSet;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public TipAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.dataSet = new ArrayList<TipRecord>();
        this.context = context;

        this.onItemClickListener = onItemClickListener;
    }

    public TipAdapter(Context context, List<TipRecord> dataSet, OnItemClickListener onItemClickListener) {
        this.dataSet = dataSet;
        this.context = context;

        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TipRecord element = dataSet.get(position);
        String strTip = String.format(context.getString(R.string.global_message_tip), element.getTip());

        holder.txtContent.setText(strTip);
        holder.txtDateRow.setText(element.getDateFormatted());
        holder.setOnItemClickListener(element, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void add(TipRecord record) {
        dataSet.add(0, record);
        notifyDataSetChanged();
    }

    public void clear(){
        dataSet.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtContent)
        TextView txtContent;
        @Bind(R.id.txtDateRow)
        TextView txtDateRow;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setOnItemClickListener(final TipRecord element, final OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(element);
                }
            });
        }
    }
}
