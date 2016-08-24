package com.yuan.android.youkumenu;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Angel angel on 2016/8/17.
 */
public class Tools {
    public static void hideView(ViewGroup view) {
        hideView(view,0);
    }

    public static void showView(ViewGroup view) {
        showView(view,0);
    }

    public static void hideView(ViewGroup view, int startOffset) {
        RotateAnimation ra = new RotateAnimation(0,180,view.getWidth()/2,view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);//停留的状态
        ra.setStartOffset(startOffset);//延迟播放动画
        view.startAnimation(ra);
        //设置孩子不能点击
        for(int i = 0;i<view.getChildCount();i++){
            View children = view.getChildAt(i);
            children.setEnabled(false);
        }
    }


    public static void showView(ViewGroup view, int startOffset) {
        RotateAnimation ra = new RotateAnimation(180,360,view.getWidth()/2,view.getHeight());
        ra.setDuration(500);
        ra.setFillAfter(true);
        ra.setStartOffset(startOffset);
        view.startAnimation(ra);

        for(int i = 0;i<view.getChildCount();i++){
            View children = view.getChildAt(i);
            children.setEnabled(true);
        }
    }
}
