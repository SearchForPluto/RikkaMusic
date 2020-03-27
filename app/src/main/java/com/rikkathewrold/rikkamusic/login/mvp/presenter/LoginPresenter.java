package com.rikkathewrold.rikkamusic.login.mvp.presenter;


import com.rikkathewrold.rikkamusic.login.bean.LoginBean;
import com.rikkathewrold.rikkamusic.login.mvp.contract.LoginContract;
import com.rikkathewrold.rikkamusic.login.mvp.model.LoginModel;
import com.rikkathewrold.rikkamusic.util.LogUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";

    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        this.mModel = new LoginModel();
    }

    @Override
    public void login(String phone, String password) {
        LogUtil.d(TAG, "login");
        mModel.login(phone, password)
                .subscribeOn(Schedulers.io())//在IO线程执行
                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribe(new Observer<LoginBean>() {//订阅  创建观察者
                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtil.d(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        LogUtil.d(TAG, "onNext : " + bean);
                        mView.onLoginSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(TAG, "onError : " + e.toString());
                        mView.onLoginFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.d(TAG, "onComplete!");
                    }
                });
    }
}
