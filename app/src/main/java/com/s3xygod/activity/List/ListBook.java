package com.s3xygod.activity.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.s3xygod.activity.Adapter.QuanLiSachAdapter;
import com.s3xygod.activity.DangkiActivity;
import com.s3xygod.activity.Passmanager.DoiMK;
import com.s3xygod.activity.R;
import com.s3xygod.activity.SQlite.SQLSach;
import com.s3xygod.activity.SachActivity;
import com.s3xygod.activity.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class ListBook extends AppCompatActivity {
    ListView listView;
    List<Sach> sachList;
    QuanLiSachAdapter sachAdapter;
    SQLSach sqlSach;
    EditText txtTg;
    ImageButton search;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        txtTg = findViewById(R.id.editTG);
        search = findViewById(R.id.btnSearchTG);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String tGia = txtTg.getText().toString();
//                SQLSach sqlSach = new SQLSach(getApplicationContext());
//                Sach sach = sqlSach.timKiem(tGia);
//                if (sach.idsach.equals("@")){
//                    AlertDialog.Builder b = new AlertDialog.Builder(context);
//                    b.setTitle("Thông tin tìm kiếm");
//                    b.setMessage("Không tìm thấy tác giả này, vui lòng kiểm tra lại !!!");
//                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.cancel();
//                        }
//                    });
//                    AlertDialog alertDialog = b.create();
//                    alertDialog.show();
//                }else {
//                    AlertDialog.Builder b = new AlertDialog.Builder(context);
//                    b.setTitle("Thông tin tìm kiếm");
//                    b.setMessage("\nID: "+sach.idsach+"\nTên sách: "+sach.tensach+"\nThể loại: "+sach.tlsach+"\nTác giả: "+sach.tacgia+"\nNXB: "+sach.nhaxuatban+"\nĐơn giá: "+sach.dongia+"\nSố lượng: "+sach.soluong+"\nKhuyến mãi: "+sach.khuyenmai);
//                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.cancel();
//                        }
//                    });
//                    AlertDialog alertDialog = b.create();
//                    alertDialog.show();
//                }
                List<Sach> lstTK = new ArrayList<>();
                sqlSach = new SQLSach(getApplicationContext());
                lstTK = sqlSach.getBookBySL(txtTg.getText().toString());
                sachAdapter = new QuanLiSachAdapter(lstTK);
                listView.setAdapter(sachAdapter);
            }
        });
        listView = findViewById(R.id.lvListSach);
        sachList =new ArrayList<>();
        sqlSach = new SQLSach(getApplicationContext());
        sachList = sqlSach.getall();
        sachAdapter = new QuanLiSachAdapter(sachList);
        listView.setAdapter(sachAdapter);
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
                Intent i = new Intent(ListBook.this, SachActivity.class);
                startActivity(i);
                break;
            case R.id.menuchange:
                Toast.makeText(this,"Bạn chọn thay đổi mật khẩu",Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ListBook.this, DoiMK.class);
                startActivity(it);
                break;
            case R.id.menulog:
                Toast.makeText(this,"Bạn chọn đăng xuất",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListBook.this, DangkiActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}