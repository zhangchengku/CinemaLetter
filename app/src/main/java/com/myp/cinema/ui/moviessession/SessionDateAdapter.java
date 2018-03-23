package com.myp.cinema.ui.moviessession;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.entity.MoviesSessionBO;
import com.myp.cinema.entity.SessionBO;
import com.myp.cinema.util.TimeUtils;

import java.util.List;

/**
 * Created by wuliang on 2017/7/21.
 * <p>
 * 场次上的时间适配器
 */

public class SessionDateAdapter extends RecyclerView.Adapter<SessionDateAdapter.ViewHolder> {


    Context context;
    List<SessionBO.ScreenPlanListBo> sessionBOs;

    private int distion = 0;  //当前默认选中项


    public SessionDateAdapter(Context context, List<SessionBO.ScreenPlanListBo> sessionBOs) {
        this.context = context;
        this.sessionBOs = sessionBOs;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_date_session, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String date = sessionBOs.get(position).getDate();
        if (distion == position) {
            holder.dateText.setBackgroundResource(R.drawable.session_text_check);
            holder.dateText.setTextColor(Color.parseColor("#ffffff"));
        } else {
            holder.dateText.setBackgroundResource(R.drawable.session_text_nocheck);
            holder.dateText.setTextColor(Color.parseColor("#666666"));
        }
        holder.dateText.setText(TimeUtils.string2WeekAll(date));
        holder.dateText.setTag(position);
        holder.dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distion = (int) v.getTag();
                notifyDataSetChanged();
                if (onItemClick != null) {
                    onItemClick.getMovieSession((int) v.getTag(), date, sessionBOs.get((int) v.getTag()).getList());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sessionBOs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView dateText;

        public ViewHolder(View itemView) {
            super(itemView);
            dateText = (TextView) itemView.findViewById(R.id.date_text);
        }
    }


    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {

        void getMovieSession(int position, String date, List<MoviesSessionBO> list);
    }

}
