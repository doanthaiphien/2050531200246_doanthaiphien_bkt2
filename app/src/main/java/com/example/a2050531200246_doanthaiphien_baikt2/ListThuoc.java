package com.example.a2050531200246_doanthaiphien_baikt2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListThuoc extends AppCompatActivity {

    private ListView listView;
    ArrayList<Thuoc> items = new ArrayList<>();
    ThuocAdapter adapter;
    Boolean kt=false;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_thuoc);
        listView = (ListView) findViewById(R.id.lvThuoc);
        items.add(new Thuoc("acetaminophen", "Paracetamol", "được lấy từ tên của hợp chất hóa học: para-acetylaminophenol và para-acetylaminophenol.","là một loại thuốc có tác dụng hạ sốt và giảm đau,[1] tuy nhiên không như aspirin nó không hoặc ít có tác dụng chống viêm. Khả năng làm giảm sốt cho trẻ em của thuốc này còn đang gây tranh cãi.", R.drawable.paracetamol, "Đối với người lớn, liều Paracetamol tối đa không được phép lớn hơn 4g/ngày. Liều dùng Paracetamol đường uống: 10 - 15 mg/kg, cách 4 - 6 giờ/lần.", "Đọc kỹ hướng dẫn sử dụng trước khi dùng thuốc")) ;

        adapter = new ThuocAdapter(ListThuoc.this,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListThuoc.this, DetailThuoc.class);
                intent.putExtra("Ten",items.get(i).getTenKhoaHoc()+"\n"+items.get(i).getTenThuongGoi());
                intent.putExtra("MoTa",items.get(i).getDacTinh());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(ListThuoc.this);
        alertDiaLog.setTitle("Thông báo");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có muốn xóa");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDiaLog.show();
    }
}