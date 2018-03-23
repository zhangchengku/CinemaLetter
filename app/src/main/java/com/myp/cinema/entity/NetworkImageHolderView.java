package com.myp.cinema.entity;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.myp.cinema.R;

/**
 * Created by Administrator on 2018/2/11.
 */
public class NetworkImageHolderView implements Holder<Integer> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
       imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        imageView.setImageResource(R.drawable.zhanwei2);
        Glide.with(context).load(data).placeholder(R.drawable.zhanwei2).into(imageView);
    }
}
