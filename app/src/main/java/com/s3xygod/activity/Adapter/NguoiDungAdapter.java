package com.s3xygod.activity.Adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.s3xygod.activity.R;
import com.s3xygod.activity.SQlite.SQLNguoiDung;
import com.s3xygod.activity.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    List<NguoiDung> nguoiDungList;
    int i = 0;
    public NguoiDungAdapter(List<NguoiDung> nguoiDungList){
        this.nguoiDungList = nguoiDungList;
    }
    @Override
    public int getCount() {
        return nguoiDungList.size();
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hienthiuser, viewGroup, false);
        final TextView idUser = view.findViewById(R.id.id);
        TextView nameUser = view.findViewById(R.id.name);
        TextView phoneUser = view.findViewById(R.id.phone);
        TextView gmailUser = view.findViewById(R.id.gmail);
        TextView stkUser = view.findViewById(R.id.viewSTk);
        idUser.setText("Mã số: "+nguoiDungList.get(i).id );
        nameUser.setText("Họ tên: "+nguoiDungList.get(i).ten);
        phoneUser.setText("SDT: "+nguoiDungList.get(i).sdt);
        gmailUser.setText("Email: "+nguoiDungList.get(i).gmail);

        int a = Integer.parseInt(nguoiDungList.get(i).STK);
        if (a % 5 == 0){
            stkUser.setTypeface(stkUser.getTypeface(), Typeface.BOLD);
        }
        stkUser.setText("STK: "+nguoiDungList.get(i).STK);

        view.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLNguoiDung sqlNguoiDung = new SQLNguoiDung(viewGroup.getContext());
                String id = nguoiDungList.get(i).id;
                boolean ketqua = sqlNguoiDung.xoaNguoiDung(id);
                if (ketqua){
                    Toast.makeText(viewGroup.getContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                    nguoiDungList.remove(i);
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
