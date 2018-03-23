package com.myp.cinema.ui.moviessession;

import android.view.View;

import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

/**
 * Created by wuliang on 2017/6/16.
 */

public class ScaleTransformer implements GalleryLayoutManager.ItemTransformer {

    @Override
    public void transformItem(GalleryLayoutManager layoutManager, View item, float fraction) {
        item.setPivotX(item.getWidth() / 1.5f);
        item.setPivotY(item.getHeight() / 1.5f);
        float scale = 1 - 0.15f * Math.abs(fraction);
        item.setScaleX(scale);
        item.setScaleY(scale);
    }
}