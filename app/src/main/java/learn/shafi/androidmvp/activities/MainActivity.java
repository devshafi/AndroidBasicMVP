package learn.shafi.androidmvp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import learn.shafi.androidmvp.R;
import learn.shafi.androidmvp.model.LoginPresenterImpl;
import learn.shafi.androidmvp.presenter.LoginPresenter;
import learn.shafi.androidmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginView {

    EditText usernameET,passwordET;
    Button submitBT;

    LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        submitBT = findViewById(R.id.submitBT);

        loginPresenter = new LoginPresenterImpl(this);
        submitBT.setOnClickListener(this);


    }

    // overridig interface method

    @Override
    public void onClick(View view) {

        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        loginPresenter.performLogin(username,password);
    }

    @Override
    public void loginValidations() {

        Toast.makeText(this, "Some fileds may be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {

        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginError() {

        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }
}
