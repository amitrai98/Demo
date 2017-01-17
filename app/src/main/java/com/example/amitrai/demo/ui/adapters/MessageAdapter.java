package com.example.amitrai.demo.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amitrai.demo.R;
import com.example.amitrai.demo.ui.Utility.AppUtils;
import com.example.amitrai.demo.ui.modals.MessageModal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by amitrai on 17/1/17.
 * see more at www.github.com/amitrai98
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MHolder>{

    private List<MessageModal> list_messages;
    private AppUtils utils;

    public MessageAdapter(List<MessageModal> list_messages){
        this.list_messages= list_messages;
        utils = new AppUtils();

    }

    @Override
    public MHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MHolder(view);
    }

    @Override
    public void onBindViewHolder(MHolder holder, int position) {
        MessageModal modal = list_messages.get(position);
        if (modal != null && !modal.getMessage().isEmpty()){
            holder.txt_message.setText(modal.getMessage());
        }if (modal != null && modal.getDate() != null){
            holder.txt_date.setText(utils.getTimeAgo(modal.getDate()));
        }

        long now = System.currentTimeMillis();
        long difference = now - modal.getDate().getTime();
        DateUtils.formatElapsedTime(difference);

        long differenceInHours = difference / DateUtils.HOUR_IN_MILLIS;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm");
        Date testDate = null;
        try {
            DateFormat destDf = new SimpleDateFormat("dd-MM-yyyy");
            String dateStr = destDf.format(modal.getDate());
            if (differenceInHours>24){
                holder.txt_prev_date.setText(""+dateStr);
                holder.txt_prev_date.setVisibility(View.VISIBLE);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        String formatted = DateUtils.formatElapsedTime(differenceInHours);
        Log.e(TAG, formatted);
    }

    @Override
    public int getItemCount() {
        return list_messages.size();
    }

    public class MHolder extends RecyclerView.ViewHolder{
        TextView txt_message, txt_date, txt_prev_date;
        public MHolder(View itemView) {
            super(itemView);
            txt_message = (TextView) itemView.findViewById(R.id.txt_message);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_prev_date = (TextView) itemView.findViewById(R.id.txt_prev_date);
        }
    }
}
