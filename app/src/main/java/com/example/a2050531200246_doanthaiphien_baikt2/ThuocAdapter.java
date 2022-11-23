package com.example.a2050531200246_doanthaiphien_baikt2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThuocAdapter extends BaseAdapter {
    Activity activity;
    List<Thuoc> thuocs;

    public ThuocAdapter(Activity activity, List<Thuoc> thuocs) {
        this.activity = activity;
        this.thuocs = thuocs;
    }
    @Override
    public int getCount() {
        return thuocs.size();
    }

    @Override
    public Object getItem(int i) {
        return thuocs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.layoutitem, null);
        TextView tvName = (TextView) view.findViewById(R.id.tencasi);
        TextView tvNgheDanh = (TextView) view.findViewById(R.id.nghedanhcasi);
        TextView tvLuotThich = (TextView) view.findViewById(R.id.soluotthich);
        TextView tvCongDung = (TextView) view.findViewById(R.id.tvCongdung);
        ImageView imageView = (ImageView) view.findViewById(R.id.hinhcasi);
        tvName.setText(thuocs.get(i).getTenKhoaHoc());
        tvNgheDanh.setText(thuocs.get(i).getTenThuongGoi()+" - "+ thuocs.get(i).getDacTinh());
        tvLuotThich.setText(String.valueOf("Công dụng: "+ thuocs.get(i).getCongDung()));
        tvCongDung.setText(String.valueOf("Liều dùng: "+ thuocs.get(i).getLieuDung()));
        imageView.setImageResource(thuocs.get(i).getHinhAnh());
        return view;
    }
}
