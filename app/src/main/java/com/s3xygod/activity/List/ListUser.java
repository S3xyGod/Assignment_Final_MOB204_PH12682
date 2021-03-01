package com.s3xygod.activity.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.s3xygod.activity.Adapter.NguoiDungAdapter;
import com.s3xygod.activity.DangkiActivity;
import com.s3xygod.activity.NguoiDungActivity;
import com.s3xygod.activity.Passmanager.DoiMK;
import com.s3xygod.activity.R;
import com.s3xygod.activity.SQlite.SQLNguoiDung;
import com.s3xygod.activity.function.UpdateUser;
import com.s3xygod.activity.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListUser extends AppCompatActivity {
ListView listView;
List<NguoiDung> nguoiDungList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        listView = findViewById(R.id.lvListUser);
        nguoiDungList =new ArrayList<>();
       SQLNguoiDung sql = new SQLNguoiDung(ListUser.this);
        nguoiDungList = sql.getall();
        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);
        listView.setAdapter(nguoiDungAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.menuadd:
                Toast.makeText(this,"Bạn chọn thêm sách",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ListUser.this, NguoiDungActivity.class);
                startActivity(i);
                break;
            case R.id.menuchange:
                Toast.makeText(this,"Bạn chọn thay đổi mật khẩu",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ListUser.this, DoiMK.class);
                startActivity(it);
                break;
            case R.id.menulog:
                Toast.makeText(this,"Bạn chọn đăng xuất",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListUser.this, DangkiActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void capNhat(View view){
        Intent i = new Intent(ListUser.this, UpdateUser.class);
        startActivity(i);
    }
}