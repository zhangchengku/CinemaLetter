package com.myp.cinema.ui.signin;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myp.cinema.R;

/**
 * Created by wuliang on 2017/5/24.
 * <p>
 * 签到日历的适配器
 */

public class SignGridAdapter extends BaseAdapter {


    private Context context;

    private SpecialCalendar sp;

    String[] b;

    public SignGridAdapter(Context context) {
        this.context = context;
        sp = new SpecialCalendar();
    }


    public void getStrings(int year, int moth, int day) {
        data = 0;
        int start = sp.getWeekdayOfMonth(year, moth);
        int size = sp.getDaysOfMonth(sp.isLeapYear(year), moth);
        int num_index = 0;
        if (size >= 30 && start >= 5) {
            b = initString();
        } else {
            b = initFiveString();
        }
        for (int i = 0; i < b.length; i++) {
            if (i >= start && num_index < size) {
                num_index++;
                if (num_index == day) {
                    b[i] = "2";
                } else {
                    b[i] = "1";
                }
            }
        }
    }


    /**
     * 6行的日历
     *
     * @return
     */
    private String[] initString() {
        String[] b = new String[]{
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0"
        };
        return b;
    }


    /**
     * 5行的日历
     *
     * @return
     */
    private String[] initFiveString() {
        String[] b = new String[]{
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0"
        };
        return b;
    }


    @Override
    public int getCount() {
        return b.length;
    }

    @Override
    public Object getItem(int position) {
        return b[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    int data = 0;   //记录日期

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sign_in, null);
            holder = new ViewHolder();
            holder.date = (TextView) convertView.findViewById(R.id.date_month);
            holder.qiandao_img = (ImageView) convertView.findViewById(R.id.qiandao_img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        switch (b[position]) {
            case "0":
                holder.date.setVisibility(View.GONE);
                holder.qiandao_img.setVisibility(View.GONE);
                break;
            case "1":
                holder.date.setVisibility(View.VISIBLE);
                holder.qiandao_img.setVisibility(View.GONE);
                holder.date.setTextColor(Color.parseColor("#666666"));
                if (position == 0 && data == 1) {   //防止gridview下标为0时莫名其妙的获取两次view
                    holder.date.setText(data + "");
                    break;
                }
                data++;
                holder.date.setText(data + "");
                break;
            case "2":
                holder.date.setVisibility(View.VISIBLE);
                holder.date.setTextColor(Color.parseColor("#e7271d"));
                holder.qiandao_img.setVisibility(View.VISIBLE);
                if (position == 0 && data == 1) {
                    holder.date.setText(data + "");
                    break;
                }
                data++;
                holder.date.setText(data + "");
                break;
        }
        return convertView;
    }


    class ViewHolder {
        TextView date;
        ImageView qiandao_img;
    }


}
