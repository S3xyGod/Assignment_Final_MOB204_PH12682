package com.s3xygod.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.s3xygod.activity.List.ListBook;
import com.s3xygod.activity.SQlite.SQLSach;
import com.s3xygod.activity.SQlite.SQLTheLoai;
import com.s3xygod.activity.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class SachActivity extends AppCompatActivity {
    Button btThem, btHienThi, btHuy;
    EditText id, tensach, tacgia, nhaxuatban, dongia, soluong, km;
    Spinner theloai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        btThem = findViewById(R.id.btnThem);
        btHienThi = findViewById(R.id.btnShow);
        id = findViewById(R.id.edtIDSach);
        theloai = findViewById(R.id.edtTheLoai);
        tensach = findViewById(R.id.edtTenSach);
        tacgia = findViewById(R.id.edtTacGia);
        nhaxuatban = findViewById(R.id.edtNhaXuatBan);
        dongia = findViewById(R.id.edtDonGia);
        soluong = findViewById(R.id.edtSoLuong);
        btHuy = findViewById(R.id.btnCanCel);
        km = findViewById(R.id.txt_km);

        List<String> thel= new ArrayList<String>();
        SQLTheLoai sqlTheLoai = new SQLTheLoai(getApplicationContext());
        thel = sqlTheLoai.getallStrTL();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,thel);
        theloai.setAdapter(adapter);
        theloai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                  Toast.makeText(SachActivity.this, theloai.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> adapterView) {

                                              }
                                          });
        btHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SachActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID Sách", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tensach.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống tên sách", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (tacgia.length()==0){
                    Toast.makeText(getApplicationContext(), "Không được để trống tác giả", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (nhaxuatban.length() == 0) {
                    Toast.makeText(getApplicationContext(), "không được để trống nhà xuất bản", Toast.LENGTH_SHORT).show();
                    return;
                }
               if(dongia.length()==0) {
                   Toast.makeText(getApplicationContext(), "không được để trống đơn giá", Toast.LENGTH_SHORT).show();
                   return;
               }
                if(soluong.length()==0) {
                    Toast.makeText(getApplicationContext(), "không được để trống số lượng", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    SQLSach sqlSach = new SQLSach(SachActivity.this);
                    Sach sach  = new Sach(id.getText().toString(), theloai.getSelectedItem().toString(), tensach.getText().toString(), tacgia.getText().toString(),nhaxuatban.getText().toString(),dongia.getText().toString(),soluong.getText().toString(), km.getText().toString());
                    sqlSach.addSach(sach);
                    Intent it = new Intent(SachActivity.this, ListBook.class);
                    startActivity(it);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SachActivity.this, ListBook.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
