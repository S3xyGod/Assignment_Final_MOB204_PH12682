package com.s3xygod.activity.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.s3xygod.activity.Adapter.HoaDonAdapter;
import com.s3xygod.activity.DangkiActivity;
import com.s3xygod.activity.HoaDonActivity;
import com.s3xygod.activity.Passmanager.DoiMK;
import com.s3xygod.activity.R;
import com.s3xygod.activity.SQlite.SQLHoaDon;
import com.s3xygod.activity.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class ListInvoice extends AppCompatActivity {

    ListView listView;
    List<HoaDon> hoaDonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_invoice);
        listView = findViewById(R.id.lvListInvoice);
        hoaDonList = new ArrayList<>();
        SQLHoaDon sql = new SQLHoaDon(ListInvoice.this);
        hoaDonList = sql.getall();
        HoaDonAdapter hoaDonAdapter = new HoaDonAdapter(hoaDonList);
        listView.setAdapter(hoaDonAdapter);
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
                Toast.makeText(this,"Bạn chọn thêm hóa đơn",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ListInvoice.this, HoaDonActivity.class);
                startActivity(i);
                break;
            case R.id.menuchange:
                Toast.makeText(this,"Bạn chọn thay đổi mật khẩu",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ListInvoice.this, DoiMK.class);
                startActivity(it);
                break;
            case R.id.menulog:
                Toast.makeText(this,"Bạn chọn đăng xuất",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListInvoice.this, DangkiActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}