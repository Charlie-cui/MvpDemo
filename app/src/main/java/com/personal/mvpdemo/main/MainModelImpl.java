package com.personal.mvpdemo.main;

/**
 * 类名称：MainModelImpl
 * 类描述：
 *
 * @version: 2.0.3
 * @author: CuiLongFei
 * @since: 2019/3/27 16:13
 */
public class MainModelImpl implements MainContract.Model {

    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username, password);
    }
}
