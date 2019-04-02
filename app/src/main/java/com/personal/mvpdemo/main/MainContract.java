package com.personal.mvpdemo.main;

import com.personal.mvpdemo.base.BaseView;

/**
 * 类名称：MainContract
 * 类描述：整合 main功能的model、view、presenter
 *
 * @version: 2.0.3
 * @author: CuiLongFei
 * @since: 2019/3/27 16:13
 */
public interface MainContract {

    interface Model { // 添加网络请求
        Flowable<BaseObjectBean<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView {// UI相关

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    interface Presenter {//

        void login(String username, String password);
    }
}
