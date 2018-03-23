package com.myp.cinema.ui.main.home.nextmovies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.entity.DirectorBO;
import com.myp.cinema.entity.MoviesByCidBO;
import com.myp.cinema.entity.MoviesSoonBO;
import com.myp.cinema.ui.moviessession.SessionActivity;
import com.myp.cinema.util.StringUtils;
import com.myp.cinema.util.TimeUtils;
import com.myp.cinema.widget.expandlist.adapter.IDockingAdapterDataSource;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wuliang on 2016/11/21.
 * <p>
 * 悬浮标题栏的expandListview
 */
public class DemoDockingAdapterDataSource implements IDockingAdapterDataSource {
    private Context mContext;

    private List<MoviesSoonBO> moviesSoonBOs;

    public DemoDockingAdapterDataSource(Context context, List<MoviesSoonBO> moviesSoonBOs) {
        mContext = context;
        this.moviesSoonBOs = moviesSoonBOs;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (groupPosition < 0 || moviesSoonBOs == null) {
            return null;
        }
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.next_movies_header, parent, false);
        }
        TextView date = (TextView) convertView.findViewById(R.id.date_month);
        TextView week = (TextView) convertView.findViewById(R.id.date_week);
        date.setText(TimeUtils.string2MonAndDay(moviesSoonBOs.get(groupPosition).getDate()));
        week.setText(TimeUtils.string2Week2(moviesSoonBOs.get(groupPosition).getDate()));
        return convertView;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        List<MoviesByCidBO> moviesByCidBOs = moviesSoonBOs.get(groupPosition).getMovieList();
        if (moviesByCidBOs == null || childPosition < 0 || childPosition > moviesByCidBOs.size()) {
            return null;
        }
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_nextmovies_list_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final MoviesByCidBO moviesByCidBO = moviesByCidBOs.get(childPosition);
        holder.moviesName.setText(moviesByCidBO.getMovieName());
        holder.moiveMessage.setText(moviesByCidBO.getSummary());
        holder.movieClass.setText(moviesByCidBO.getMovieType());
        if (StringUtils.isEmpty(moviesByCidBO.getPicture())) {
            holder.moviesImg.setImageResource(R.color.act_bg01);
        } else {
            Picasso.with(mContext).load(moviesByCidBO.getPicture()).into(holder.moviesImg);
        }
        switch (moviesByCidBO.getMovieDimensional()) {
            case "2D":
                holder.movieType.setImageResource(R.drawable.img_2d);
                break;
            case "3D":
                holder.movieType.setImageResource(R.drawable.img_3d);
                break;
            default:
                holder.movieType.setImageResource(R.drawable.img_3dmax);
                break;
        }
        if ("0".equals(moviesByCidBO.getSell())) {
            holder.moviePresell.setVisibility(View.GONE);
        } else if ("1".equals(moviesByCidBO.getSell())) {
            holder.moviePresell.setVisibility(View.VISIBLE);
        }
        holder.moviePresell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("movies", moviesByCidBO);
                Intent intent = new Intent(mContext, SessionActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        List<DirectorBO> list = moviesByCidBO.getDxActors();
        StringBuffer buffer = new StringBuffer();
        int size = list.size() <= 3 ? list.size() : 3;  //取最多3个名字
        for (int i = 0; i < size; i++) {
            buffer.append(list.get(i).getName() + "  ");
        }
        holder.moviePerson.setText(buffer.toString());
        return convertView;
    }


    class ViewHolder {
        TextView moviesName;
        ImageView moviesImg;
        ImageView movieType;
        TextView moiveMessage;
        TextView movieClass;
        TextView moviePerson;
        Button moviePresell;

        public ViewHolder(View view) {
            moviesName = (TextView) view.findViewById(R.id.movies_name);
            moviesImg = (ImageView) view.findViewById(R.id.movie_img);
            movieType = (ImageView) view.findViewById(R.id.movie_type);
            moiveMessage = (TextView) view.findViewById(R.id.moive_message);
            movieClass = (TextView) view.findViewById(R.id.movie_class);
            moviePerson = (TextView) view.findViewById(R.id.movie_person);
            moviePresell = (Button) view.findViewById(R.id.movie_presell);
        }
    }


    public int getGroupCount() {
        return moviesSoonBOs.size();
    }

    public int getChildCount(int groupPosition) {
        if (moviesSoonBOs.get(groupPosition) != null) {
            return moviesSoonBOs.get(groupPosition).getMovieList().size();
        }

        return 0;
    }

    public MoviesSoonBO getGroup(int groupPosition) {
        if (moviesSoonBOs.get(groupPosition) != null) {
            return moviesSoonBOs.get(groupPosition);
        }

        return null;
    }

    public List<MoviesByCidBO> getChild(int groupPosition, int childPosition) {
        if (moviesSoonBOs.get(groupPosition) != null) {
            List<MoviesByCidBO> group = moviesSoonBOs.get(groupPosition).getMovieList();
            if (childPosition >= 0 && childPosition < group.size()) {
                return group;
            }
        }

        return null;
    }

    // Helper method to add group
//    public DemoDockingAdapterDataSource addGroup(String group) {
//        if (!mGroups.containsValue(group)) {
//            mCurrentGroup++;
//            mGroups.put(mCurrentGroup, group);
//            mGroupData.put(mCurrentGroup, new ArrayList<String>());
//        }
//
//        return this;
//    }
//
//    // Helper method to add child into one group
//    public DemoDockingAdapterDataSource addChild(String child) {
//        if (mGroupData.get(mCurrentGroup) != null) {
//            mGroupData.get(mCurrentGroup).add(child);
//        }
//
//        return this;
//    }
}
