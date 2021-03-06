package com.datacvg.dimp.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.datacvg.dimp.R;
import com.datacvg.dimp.adapter.TableAdapter;
import com.datacvg.dimp.baseandroid.config.Constants;
import com.datacvg.dimp.baseandroid.utils.Base64Utils;
import com.datacvg.dimp.baseandroid.utils.LanguageUtils;
import com.datacvg.dimp.baseandroid.utils.PLog;
import com.datacvg.dimp.baseandroid.utils.StatusBarUtil;
import com.datacvg.dimp.baseandroid.utils.ToastUtils;
import com.datacvg.dimp.bean.ReportBean;
import com.datacvg.dimp.bean.TableBean;
import com.datacvg.dimp.bean.TableListBean;
import com.datacvg.dimp.presenter.TableFolderPresenter;
import com.datacvg.dimp.view.TableFolderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author : T-Bag (茶包)
 * @Time : 2020-11-09
 * @Description : 报表文件夹页面
 */
public class TableFolderActivity extends BaseActivity<TableFolderView, TableFolderPresenter>
        implements TableFolderView ,TableAdapter.OnItemClickListener{
    @BindView(R.id.tv_title)
    TextView tvTitle ;
    @BindView(R.id.recycler_table)
    RecyclerView recyclerTable ;

    private List<TableBean> tableBeans = new ArrayList<>();
    private TableAdapter adapter ;
    private TableBean rootBean ;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_table_folder;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setupView() {
        StatusBarUtil.setStatusBarColor(mContext,resources.getColor(R.color.c_FFFFFF));
    }

    @Override
    protected void setupData(Bundle savedInstanceState) {
        rootBean = (TableBean) getIntent().getSerializableExtra(Constants.EXTRA_DATA_FOR_BEAN);
        if(rootBean == null){
            finish();
            return;
        }
        tvTitle.setText(LanguageUtils.isZh(mContext)
                ? rootBean.getRes_clname() : rootBean.getRes_flname());
        getTableList();
        adapter = new TableAdapter(mContext,tableBeans,this);
        recyclerTable.setLayoutManager(new GridLayoutManager(mContext,2));
        recyclerTable.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view
                    , @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                //不是第一个的格子都设一个左边和底部的间距
                outRect.left = (int) resources.getDimension(R.dimen.W25);
                if (parent.getChildLayoutPosition(view) % 2 ==0) {
                    outRect.left = 0;
                }
            }
        });
        recyclerTable.setAdapter(adapter);
    }

    /**
     * 查询报表列表
     */
    private void getTableList() {
        getPresenter().getTableList(Constants.TABLE_TYPE);
    }

    /**
     * 获取报表列表成功
     * @param tableBeans
     */
    @Override
    public void getTableSuccess(TableListBean tableBeans) {
        for (TableBean childBean : tableBeans){
            if(childBean.getRes_parentid().equals(rootBean.getRes_id())){
                this.tableBeans.add(childBean);
            }
        }

        adapter.notifyDataSetChanged();
        for (TableBean bean : this.tableBeans){
            getPresenter().getImageRes(bean.getRes_id());
        }
        PLog.e("tableBeans size is " + this.tableBeans.size());
    }

    @Override
    public void getImageResSuccess(String res_id, String resdata) {
        for (TableBean bean : tableBeans){
            if(bean.getRes_id().equals(res_id)){
                bean.setImageRes(Base64Utils.decode(resdata.split("base64,")[1]));
                adapter.notifyDataSetChanged();
                return;
            }
        }

    }

    /**
     * 单个点击监听
     * @param tableBean
     * CUSTOMJUMP  MODEL   CUSTOMRPT  powerbi   powerbi_install   TABLEAU   CX   BO_DASHBOARD
     */
    @Override
    public void onItemClick(TableBean tableBean) {
        switch (tableBean.getRes_showtype()){
            case "FOLDER" :
                Intent intent = new Intent(mContext, TableFolderActivity.class);
                intent.putExtra(Constants.EXTRA_DATA_FOR_BEAN,tableBean);
                mContext.startActivity(intent);
                break;
            case "MODEL" :
            case "CUSTOMJUMP" :
            case "CUSTOMRPT" :
            case "powerbi" :
            case "powerbi_install" :
            case "TABLEAU" :
            case "BO_DASHBOARD" :
                Intent tableIntent = new Intent(mContext, TableDetailActivity.class);
                tableIntent.putExtra(Constants
                        .EXTRA_DATA_FOR_BEAN,tableBean);
                mContext.startActivity(tableIntent);
                break;

            case "CX" :
                PLog.e("jump to CX");
                break;

            default:
                ToastUtils.showLongToast(resources
                        .getString(R.string.the_current_version_is_not_supported));
                break;
        }
    }

    @OnClick({R.id.img_left})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.img_left :
                    finish();
                break;
        }
    }
}
