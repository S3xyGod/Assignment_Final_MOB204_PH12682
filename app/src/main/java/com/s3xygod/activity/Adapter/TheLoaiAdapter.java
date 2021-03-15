package com.s3xygod.activity.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.activity.R;
import com.s3xygod.activity.SQlite.SQLTheLoai;
import com.s3xygod.activity.model.TheLoai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    List<TheLoai> theLoaiList;
    public TheLoaiAdapter(List<TheLoai> theLoaiList){
        this.theLoaiList = theLoaiList;
    }
    @Override
    public int getCount() {
        return theLoaiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hienthitheloai,viewGroup,false);
        TextView idTheLoai = view.findViewById(R.id.idtheloai);
        TextView nameTheLoai = view.findViewById(R.id.tentheloai);
        TextView vitri = view.findViewById(R.id.vitri);
        TextView mota = view.findViewById(R.id.mota);
        TextView Ncc = view.findViewById(R.id.txtNcc);
        TheLoai theLoai = theLoaiList.get(i);
        idTheLoai.setText("Mã thể loại: "+theLoai.id);
        nameTheLoai.setText("Tên thể loại: "+theLoai.ten);
        vitri.setText("Vị trí: "+theLoai.vitri);
        mota.setText("Mô tả: "+theLoai.mota);
        Ncc.setText("Nhà cung cấp: "+theLoai.ncc);
        char x = theLoai.ten.toString().charAt(0);
//        if (x == 'N' || x == 'n'){
//            idTheLoai.setTextColor(Color.parseColor("#00FF0A"));
//            nameTheLoai.setTextColor(Color.parseColor("#00FF0A"));
//            vitri.setTextColor(Color.parseColor("#00FF0A"));
//            mota.setTextColor(Color.parseColor("#00FF0A"));
//            Ncc.setTextColor(Color.parseColor("#00FF0A"));
//        }else if (x == 'A' || x == 'a'){
//            idTheLoai.setTextColor(Color.parseColor("#FF0000"));
//            nameTheLoai.setTextColor(Color.parseColor("#FF0000"));
//            vitri.setTextColor(Color.parseColor("#FF0000"));
//            mota.setTextColor(Color.parseColor("#FF0000"));
//            Ncc.setTextColor(Color.parseColor("#FF0000"));
//        }else {
//            idTheLoai.setTextColor(Color.parseColor("#FF000000"));
//            nameTheLoai.setTextColor(Color.parseColor("#FF000000"));
//            vitri.setTextColor(Color.parseColor("#FF000000"));
//            mota.setTextColor(Color.parseColor("#FF000000"));
//            Ncc.setTextColor(Color.parseColor("#FF000000"));
//        }
        view.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLTheLoai sqlTheLoai= new SQLTheLoai(viewGroup.getContext());
                String id = theLoaiList.get(i).id;
                boolean ketqua = sqlTheLoai.xoaTheLoai(id);
                if (ketqua){
                    Toast.makeText(viewGroup.getContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                    theLoaiList.remove(i);
                    notifyDataSetChanged();
                }
                else {
                    Toast.makeText(viewGroup.getContext(),"Xóa không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
