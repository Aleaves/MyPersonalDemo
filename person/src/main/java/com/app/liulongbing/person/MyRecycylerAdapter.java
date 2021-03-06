package com.app.liulongbing.person;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liulongbing on 17/1/14.
 */

public class MyRecycylerAdapter extends RecyclerView.Adapter<MyRecycylerAdapter.ViewHolder>{

    private List<PersonItem> lists =null;
    private Context mContext;

    public MyRecycylerAdapter(Context context, List<PersonItem> lists) {
        mContext =context;
        this.lists =lists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_personal,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PersonItem personItem = lists.get(position);
        holder.mTitle.setText(personItem.getTitle());
        holder.mDesc.setText(personItem.getDesc());
        holder.mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext,personItem.getCls()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle;
        TextView mDesc;
        LinearLayout mItem;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            mItem = (LinearLayout) itemView.findViewById(R.id.ll_person_item);
        }
    }


}
