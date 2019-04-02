package com.personal.mvpdemo.main;

import com.personal.mvpdemo.base.BasePresenter;

/**
 * 类名称：MainPresenterImpl
 * 类描述：
 *
 * @version: 2.0.3
 * @author: CuiLongFei
 * @since: 2019/3/27 16:13
 */
public class MainPresenterImpl extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenterImpl() {
        model = new MainModelImpl();
    }

    @Override
    public void login(String username, String password) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(username, password)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
