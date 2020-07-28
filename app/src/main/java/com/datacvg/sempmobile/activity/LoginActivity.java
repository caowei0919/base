package com.datacvg.sempmobile.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.datacvg.sempmobile.R;
import com.datacvg.sempmobile.baseandroid.utils.AndroidUtils;
import com.datacvg.sempmobile.baseandroid.utils.StatusBarUtil;
import com.datacvg.sempmobile.baseandroid.utils.ToastUtils;
import com.datacvg.sempmobile.baseandroid.widget.CVGOKCancelWithTitle;
import com.datacvg.sempmobile.presenter.LoginPresenter;
import com.datacvg.sempmobile.view.LoginView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * @Author : T-Bag (茶包)
 * @Time : 2020-07-24
 * @Description : 登录页面
 */
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    private String companyCode = "" ;
    private String userName = "" ;
    private String password = "" ;

    @BindView(R.id.ed_code)
    EditText edCode ;

    @BindView(R.id.ed_userName)
    EditText edUserName ;

    @BindView(R.id.ed_pwd)
    EditText edPwd ;

    @BindView(R.id.cb_rememberUser)
    CheckBox cbRememberUser ;

    @BindView(R.id.cb_userVPN)
    CheckBox cbUserVPN ;

    @BindView(R.id.btn_login)
    Button btnLogin ;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    /**
     * 企业码输入监听
     */
    @OnTextChanged(value = R.id.ed_code,callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onCodeTextChange(Editable editable){
        companyCode = editable.toString().trim();
    }

    /**
     * 用户名输入监听
     */
    @OnTextChanged(value = R.id.ed_userName,callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onUserNameTextChange(Editable editable){
        userName = editable.toString().trim();
    }

    /**
     * 密码输入监听
     */
    @OnTextChanged(value = R.id.ed_pwd,callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onPwdTextChange(Editable editable){
        password = editable.toString().trim();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void setupView() {
        StatusBarUtil.setStatusBarColor(mContext
                ,mContext.getResources().getColor(R.color.c_24334F));
    }

    @Override
    protected void setupData(Bundle savedInstanceState) {

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_login :
                if(!AndroidUtils.isNetworkAvailable()){
                    ToastUtils.showLongToast(R.string.please_check_the_network);
                    return;
                }
                if(TextUtils.isEmpty(userName)){
                    ToastUtils.showLongToast(mContext.getResources()
                            .getString(R.string.please_enter_the_user_name));
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    ToastUtils.showLongToast(mContext.getResources()
                            .getString(R.string.please_enter_your_password));
                    return;
                }
                if(cbUserVPN.isChecked()){

                }else {
                    getPresenter().login(companyCode,userName,password);
                }
                break;
        }
    }

    /**
     * 更新应用
     * @param updateUrl 下载链接
     */
    @Override
    public void onUpdateVersion(String updateUrl) {
        CVGOKCancelWithTitle dialogOKCancel = new CVGOKCancelWithTitle(mContext);
        dialogOKCancel.setMessage(mContext.getResources().getString(R.string.cancel));
        dialogOKCancel.getPositiveButton().setText(mContext.getResources().getString(R.string.confirm));
        dialogOKCancel.setOnClickPositiveButtonListener(view -> {
            ToastUtils.showLongToast("确认");
        });
        dialogOKCancel.setOnClickListenerNegativeBtn(view -> {
            ToastUtils.showLongToast("取消");
        });
        dialogOKCancel.show();
    }
}
