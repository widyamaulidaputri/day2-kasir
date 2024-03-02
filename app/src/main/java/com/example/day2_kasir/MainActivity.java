package com.example.day2_kasir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_transaksi1);
    }

    public void clickproses(View view){
        EditText namapelanggan, alamatpelanggan, jumlahbarang;
        RadioGroup rgJenisKelamin, rgTipePelanggan, rgNamaBarang;
        RadioButton pilihjeniskelamis, pilihtipepelanggan, pilihnamabarang;

        namapelanggan = (EditText) findViewById(R.id.etNama);
        alamatpelanggan = (EditText) findViewById(R.id.etAlamat);
        jumlahbarang = (EditText) findViewById(R.id.etJumlahBarang);

        String nama = namapelanggan.getText().toString().trim();
        String alamat = alamatpelanggan.getText().toString().trim();
        Integer jumlahBarang = Integer.parseInt(jumlahbarang.getText().toString().trim());

        rgJenisKelamin = (RadioGroup) findViewById(R.id.rgJenisKelamin);
        int idJenisKelamin = rgJenisKelamin.getCheckedRadioButtonId();
        pilihjeniskelamis = (RadioButton) findViewById(idJenisKelamin);
        String kelamin = pilihjeniskelamis.getText().toString().trim();

        rgTipePelanggan = (RadioGroup) findViewById(R.id.rgTipePelanggan);
        int idTipePelanggan = rgTipePelanggan.getCheckedRadioButtonId();
        pilihtipepelanggan = (RadioButton) findViewById(idTipePelanggan);
        String tipePelanggan = pilihtipepelanggan.getText().toString().trim();

        rgNamaBarang = (RadioGroup) findViewById(R.id.rgNamaBarang);
        int idNamaBarang = rgNamaBarang.getCheckedRadioButtonId();
        pilihnamabarang = (RadioButton) findViewById(idNamaBarang);
        String namaBarang = pilihnamabarang.getText().toString().trim();

        double discHarga, discMember, hargaTotal ,jumlahBayar, totalDiscMember, totalDiscHarga;
        int hargaBarang;


        // Diskon
        switch (tipePelanggan){
            case "Platinum":
                discMember = 0.2;
                break;
            case "Gold":
                discMember = 0.1;
                break;
            case "Silver":
                discMember = 0.05;
                break;
            default:
                discMember = 0;
        }

        switch (namaBarang){
            case "Kipas Angin":
                hargaBarang = 2000000;
                discHarga = 0.10;
                break;
            case "Rice Cooker":
                hargaBarang = 3000000;
                discHarga = 0.20;
                break;
            case "Kompor":
                hargaBarang = 1000000;
                discHarga = 0.30;
                break;
            default:
                hargaBarang = 0;
                discHarga = 0;
        }
        hargaTotal = hargaBarang * jumlahBarang;
        totalDiscMember = hargaTotal * discMember;
        totalDiscHarga = hargaTotal * discHarga;
        jumlahBayar = hargaTotal - totalDiscMember - totalDiscHarga;


        Intent intent = new Intent(this, transaksi.class);
        intent.putExtra("tipePelanggan", tipePelanggan );
        intent.putExtra("namaPelanggan", nama);
        intent.putExtra("jenisKelamin", kelamin);
        intent.putExtra("alamat", alamat);
        intent.putExtra("namaBarang", namaBarang);
        intent.putExtra("jumlahBarang", jumlahBarang);
        intent.putExtra("hargaBarang", hargaBarang);
        intent.putExtra("totalHarga", hargaTotal);
        intent.putExtra("diskonMember", totalDiscMember);
        intent.putExtra("diskonHarga", totalDiscHarga);
        intent.putExtra("jumlahBayar", jumlahBayar);
        try {
            startActivity(intent);

        }catch (Exception e){

        }

    }
}