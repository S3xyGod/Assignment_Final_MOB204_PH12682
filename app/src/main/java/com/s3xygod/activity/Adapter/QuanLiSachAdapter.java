package com.s3xygod.activity.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.activity.R;
import com.s3xygod.activity.SQlite.SQLSach;
import com.s3xygod.activity.model.Sach;

import java.util.List;

public class QuanLiSachAdapter extends BaseAdapter {
    List<Sach> sachList;
    public QuanLiSachAdapter(List<Sach> sachList){
        this.sachList = sachList;
    }
    @Override
    public int getCount() {
        return sachList.size();
    }
    @Override
    public Object getItem(int i) {
        return sachList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.onebook, viewGroup, false);
        final TextView idSach = view.findViewById(R.id.txtidsach);
        TextView tlBook = view.findViewById(R.id.txttheloai);
        final TextView nameSach = view.findViewById(R.id.txttensach);
        TextView tg = view.findViewById(R.id.txttacgia);
        TextView nxb = view.findViewById(R.id.txtnhaxuatban);
        TextView dong = view.findViewById(R.id.txtdongia);
        TextView sl = view.findViewById(R.id.txtsoluong);
        TextView km = view.findViewById(R.id.txtkhuyenMai);
        idSach.setText("ID: "+sachList.get(i).idsach );
        tlBook.setText("Thể loại: "+sachList.get(i).tlsach);
        nameSach.setText("Tên sách: "+sachList.get(i).tensach);
        tg.setText("Tác giả: "+sachList.get(i).tacgia);
        nxb.setText("NXB: "+sachList.get(i).nhaxuatban);
        dong.setText("Giá: "+sachList.get(i).dongia);
        sl.setText("Số lượng: "+sachList.get(i).soluong);
        km.setText("Khuyến mãi: "+sachList.get(i).khuyenmai);
        view.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SQLSach sqlSach = new SQLSach(viewGroup.getContext());
                String id = sachList.get(i).idsach;
                boolean ketqua = sqlSach.xoaSach(id);
                if (ketqua){
                    Toast.makeText(viewGroup.getContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                    sachList.remove(i);
                    notifyDataSetChanged();
                }
                else {
                    Toast.makeText(viewGroup.getContext(),"Xóa không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder b = new AlertDialog.Builder(viewGroup.getContext());
                b.setTitle("Thông tin sách");
                b.setMessage("\nID: "+sachList.get(i).idsach+"\nTên sách: "+sachList.get(i).tensach+"\nTác giả: "+sachList.get(i).tacgia
                +"\nNXB: "+sachList.get(i).nhaxuatban);
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = b.create();
                alertDialog.show();
            }
        });


        return view;
    }

}
