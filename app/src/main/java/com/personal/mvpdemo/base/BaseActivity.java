package com.personal.mvpdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.personal.mvpdemo.utils.RxLifecycleUtils;
import com.uber.autodispose.AutoDisposeConverter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder unbinder;
    protected BasePresenter mPresenter;

    protected Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutId());
        mContext = this;
        unbinder = ButterKnife.bind(this);

        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

//        lifecycle.addObserver(mPresenter);

        initView();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 获取Presenter实例，子类实现
     */
    public abstract BasePresenter initPresenter();

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr() {

    }

    @Override
    public Context getContext() {
        return mContext;
    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
     */
    public <T> AutoDisposeConverter<T> bindLifecycle() {
        return RxLifecycleUtils.bindLifecycle(this);
    }
}
