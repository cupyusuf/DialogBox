package com.auto.dialogbox;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button pesanToast;
    Button keluar;
    Button tampilList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesanToast = findViewById(R.id.toastBtn);
        pesanToast.setOnClickListener(this);

        keluar = findViewById(R.id.exitBtn);
        keluar.setOnClickListener(this);

        tampilList = findViewById(R.id.listDialogBtn);
        tampilList.setOnClickListener(this);
    }

    public void onClick(View clicked) {
        switch (clicked.getId()) {
            case R.id.listDialogBtn:
                munculListDialog();
                break;
            case R.id.toastBtn:
                Toast.makeText(this, "Kamu Memilih Toast",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.exitBtn:
                exit();
                break;
        }
    }

    private void munculListDialog() {
        final CharSequence[] items = {"Es Teh", "Es Jeruk", "Lemon Squash", "Soft Drink"};

        AlertDialog.Builder kk = new AlertDialog.Builder(this);
        kk.setTitle("Pilih Minuman");
        kk.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getApplicationContext(), items[item],
                        Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah kamu benar-benar ingin keluar ?")
                .setCancelable(false)
                .setPositiveButton("Ya", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                .setNegativeButton("Tidak", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.cancel();
                            }
                        }).show();
    }
}
