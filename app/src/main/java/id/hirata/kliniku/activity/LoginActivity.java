package id.hirata.kliniku.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.hirata.kliniku.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private TextView tvLupaPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnMoveActivity = findViewById(R.id.btn_login);
        btnMoveActivity.setOnClickListener(this);
        tvLupaPassword = findViewById(R.id.tv_lupapassword);
        tvLupaPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent moveIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.tv_lupapassword:
                moveIntent = new Intent(LoginActivity.this, LupaPasswordActivity.class);
                startActivity(moveIntent);
                break;
        }
    }
}
