package com.example.bebettaassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    BottomSheetDialog bottomSheetDialog;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomSheetDialog = new BottomSheetDialog(this);
        createDialog();

        bottomSheetDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    // Show the bottom sheet when the Home item is selected
                    bottomSheetDialog.show();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }



    private void createDialog() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet,null,false);
        bottomSheetDialog.setContentView(view);

    }
}

