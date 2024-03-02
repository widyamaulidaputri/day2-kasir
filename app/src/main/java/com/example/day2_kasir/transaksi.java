package com.example.day2_kasir;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class transaksi extends AppCompatActivity {
    private TextView tv_TipeMember, tv_NamaPelanggan, tv_JenisKelamin, tv_AlamatPelanggan, tv_NamaBarang, tv_JumlahBarang, tv_Harga, tv_TotalHarga, tv_DiscHarga, tv_DiscMember, tv_JumlahBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_transaksi2);
        tv_NamaPelanggan = (TextView) findViewById(R.id.tv_NamaPelanggan);
        tv_TipeMember = (TextView) findViewById(R.id.tv_TipeMember);
        tv_JenisKelamin = (TextView) findViewById(R.id.tv_JenisKelamin);
        tv_AlamatPelanggan = (TextView) findViewById(R.id.tv_AlamatPelanggan);
        tv_NamaBarang = (TextView) findViewById(R.id.tv_NamaBarang);
        tv_JumlahBarang = (TextView) findViewById(R.id.tv_JumlahBarang);
        tv_Harga = (TextView) findViewById(R.id.tv_Harga);
        tv_TotalHarga = (TextView) findViewById(R.id.tv_TotalHarga);
        tv_DiscHarga = (TextView) findViewById(R.id.tv_DiscHarga);
        tv_DiscMember = (TextView) findViewById(R.id.tv_DiscMember);
        tv_JumlahBayar = (TextView) findViewById(R.id.tv_JumlahBayar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tv_NamaPelanggan.setText("Nama Pelanggan: " + extras.getString("namaPelanggan"));
            tv_TipeMember.setText("Tipe Member: " + extras.getString("tipePelanggan"));
            tv_JenisKelamin.setText("Jenis Kelamin: " + extras.getString("jenisKelamin"));
            tv_AlamatPelanggan.setText("Alamat Pelanggan: " + extras.getString("alamat"));
            tv_NamaBarang.setText("Nama Barang: " + extras.getString("namaBarang"));
            tv_JumlahBarang.setText("Jumlah Barang: " + extras.getInt("jumlahBarang"));
            tv_Harga.setText("Harga Barang: Rp. " + extras.getInt("hargaBarang"));
            tv_TotalHarga.setText("Total Harga: Rp. " + extras.getDouble("totalHarga"));
            tv_DiscMember.setText("Discount Member: RP. " + extras.getDouble("diskonMember"));
            tv_DiscHarga.setText("Discount Harga: Rp. " + extras.getDouble("diskonHarga"));
            tv_JumlahBayar.setText("Jumlah Bayar: Rp.  " + extras.getDouble("jumlahBayar"));

        }

    }
}