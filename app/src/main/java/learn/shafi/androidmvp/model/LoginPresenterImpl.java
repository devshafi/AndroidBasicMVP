package learn.shafi.androidmvp.model;

import android.text.TextUtils;

import learn.shafi.androidmvp.presenter.LoginPresenter;
import learn.shafi.androidmvp.view.LoginView;

/**
 * Created by frshafi on 2/3/18.
 */

public class LoginPresenterImpl  implements LoginPresenter {

    LoginView loginView;


    public LoginPresenterImpl(LoginView loginView){

        this.loginView = loginView;
    }


    @Override
    public void performLogin(String username, String password) {

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){

            loginView.loginValidations();

        }else if(username.equals("Shafi") && password.equals("12345")){
            loginView.loginSuccess();

        }else loginView.loginError();
    }
}
