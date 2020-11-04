package com.datacvg.sempmobile.widget;

import android.content.Context;
import android.view.View;

import com.datacvg.sempmobile.R;
import com.datacvg.sempmobile.baseandroid.utils.DisplayUtils;
import com.datacvg.sempmobile.baseandroid.utils.PLog;

import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.List;


/**
 * FileName: TitleNavigator
 * Author: 曹伟
 * Date: 2019/10/22 13:56
 * Description:订单标题指示器(只改变文字和底部指示器)
 */

public class TitleNavigator extends CommonNavigator {
    private int mPadding = DisplayUtils.dp2px(12);
    private List<String> items ;
    private Context mContext ;
    private OnTabSelectedListener mOnTabSelectedListener;
    private NavigatorAdapter adapter ;

    public TitleNavigator(Context context,List<String> titles) {
        super(context);
        mContext = context ;
        setAdjustMode(false);
        items = titles;
        adapter = new NavigatorAdapter();
        setAdapter(adapter);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener listener) {
        mOnTabSelectedListener = listener;
    }

    public class NavigatorAdapter extends CommonNavigatorAdapter {

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public IPagerTitleView getTitleView(Context context, int index) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView
                    = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView
                    .setNormalColor(mContext.getResources().getColor(R.color.c_333333));
            colorTransitionPagerTitleView
                    .setSelectedColor(mContext.getResources().getColor(R.color.c_FF3333));
            colorTransitionPagerTitleView
                    .setPadding(mPadding,0,mPadding,0);
            colorTransitionPagerTitleView.setText(items.get(index));
            colorTransitionPagerTitleView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnTabSelectedListener != null){
                        mOnTabSelectedListener.onTabSelected(index);
                    }
                }
            });
            return colorTransitionPagerTitleView;
        }

        @Override
        public IPagerIndicator getIndicator(Context context) {
            LinePagerIndicator indicator = new LinePagerIndicator(context);
            indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
            indicator.setColors(mContext.getResources().getColor(R.color.c_FF3333));
            indicator.setLineHeight(mContext.getResources().getDimension(R.dimen.H4));
            return indicator;
        }
    }

    /**
     * tab选中监听
     */
    public interface OnTabSelectedListener {
        void onTabSelected(int position);
    }
}