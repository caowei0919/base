package com.datacvg.dimp.widget;

import android.content.Context;
import android.view.View;

import com.datacvg.dimp.R;
import com.datacvg.dimp.baseandroid.utils.DisplayUtils;
import com.datacvg.dimp.bean.IndexDetailListBean;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.List;


/**
 * FileName: TitleNavigator
 * Date: 2019/10/22 13:56
 * Description:订单标题指示器(只改变文字和底部指示器)
 * @author 曹伟
 */

public class IndexTitleNavigator extends CommonNavigator {
    private int mPadding = DisplayUtils.dp2px(12);
    private List<IndexDetailListBean> items ;
    private Context mContext ;
    private OnTabSelectedListener mOnTabSelectedListener;
    private NavigatorAdapter adapter ;

    public IndexTitleNavigator(Context context, List<IndexDetailListBean> titles) {
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
            colorTransitionPagerTitleView.getPaint().setFakeBoldText(true);
            colorTransitionPagerTitleView.setTextSize(16);
            colorTransitionPagerTitleView
                    .setNormalColor(mContext.getResources().getColor(R.color.c_808080));
            colorTransitionPagerTitleView
                    .setSelectedColor(mContext.getResources().getColor(R.color.c_da3a16));
            colorTransitionPagerTitleView
                    .setPadding(mPadding,0,mPadding,0);
            colorTransitionPagerTitleView.setText(items.get(index).getName());
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
            indicator.setColors(mContext.getResources().getColor(R.color.c_da3a16));
            indicator.setLineHeight(mContext.getResources().getDimension(R.dimen.H4));
            return indicator;
        }
    }

    /**
     * tab选中监听
     */
    public interface OnTabSelectedListener {
        /**
         * 选中标签回调
         * @param position 标签位置
         */
        void onTabSelected(int position);
    }
}
