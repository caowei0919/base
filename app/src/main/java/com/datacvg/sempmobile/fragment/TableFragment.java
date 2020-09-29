package com.datacvg.sempmobile.fragment;

import android.os.Bundle;
import android.view.View;

import com.datacvg.sempmobile.R;
import com.datacvg.sempmobile.baseandroid.utils.StatusBarUtil;
import com.datacvg.sempmobile.presenter.TablePresenter;
import com.datacvg.sempmobile.view.TableView;

/**
 * @Author : T-Bag (茶包)
 * @Time : 2020-09-29
 * @Description : 主题报表
 */
public class TableFragment extends BaseFragment<TableView, TablePresenter> implements TableView {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_table;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void setupView(View rootView) {
        StatusBarUtil.setStatusBarColor(getActivity()
                ,mContext.getResources().getColor(R.color.c_FFFFFF));
    }

    @Override
    protected void setupData(Bundle savedInstanceState) {

    }
}
