package com.personal.mvpdemo.main;

import com.personal.mvpdemo.R;
import com.personal.mvpdemo.base.BaseActivity;
import com.personal.mvpdemo.base.BasePresenter;

public class MainActivity extends BaseActivity implements MainContract.View{

    @Override
    public void initView() {

    }

    @Override
    public BasePresenter initPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {

    }
}
