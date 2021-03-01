package com.s3xygod.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DangNhapActivity extends AppCompatActivity {
    private TextView user, password;
    private String id, pass, acc="", mk="";
    private CheckBox remember;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        user = findViewById(R.id.txt_id);
        password = findViewById(R.id.txt_pass);
        remember = findViewById(R.id.cb_remember);
        SharedPreferences sp =getSharedPreferences("idSave", MODE_PRIVATE);
        Boolean stt = sp.getBoolean("Save", false);
        if(stt == true){
            acc = sp.getString("accSave", "");
            mk = sp.getString("mkSave", "");
            user.setText(acc);
            password.setText(mk);
            remember.setChecked(true);
        }else{
            user.setText("");
            password.setText("");
            remember.setChecked(false);
        }
    }

    public void moveSingUp(View view) {
//        Intent intent = new Intent(this, DangkiActivity.class);
//        startActivity(intent);
        Toast.makeText(this, "Vì lý do bảo mật vui lòng liên hệ cán bộ quản lý nhà sách để được cấp tài khoản đăng nhập. Thank you !", Toast.LENGTH_LONG).show();
    }

    public void singIn(View view) {
        id = user.getText().toString();
        pass = password.getText().toString();
        if(id.equalsIgnoreCase("admin")  && pass.equals("admin") ||
                id.equalsIgnoreCase("manager") && pass.equals("manager") ||
                id.equalsIgnoreCase("user") && pass.equals("user")){
            if(remember.isChecked()){
                SharedPreferences sp = getSharedPreferences("idSave", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("accSave", id);
                editor.putString("mkSave", pass);
                editor.putBoolean("Save", true);
                editor.commit();
            }else {
                SharedPreferences sp = getSharedPreferences("idSave", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("Save", false);
                editor.commit();
            }
            Toast.makeText(context, "Chào mừng "+id+" !", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(DangNhapActivity.this, TrangChuActivity.class);
            intent.putExtra("sayHi", id);
            startActivity(intent);
        }else{
            Toast.makeText(context, "Sai tên tài khoản hoặc mật khẩu.\n " +
                    "\t\t\t\tVui lòng kiểm tra lại !", Toast.LENGTH_LONG).show();
        }

    }

    public void Cancel(View view) {
        Intent i = new Intent(DangNhapActivity.this,DangkiActivity.class);
        startActivity(i);
    }
}