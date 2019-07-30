package c346.rp.edu.sg.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner catSpinner, subCatSpinner;
    Button goBtn;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catSpinner = findViewById(R.id.catSpinner);
        subCatSpinner = findViewById(R.id.subCatSpinner);

        goBtn = findViewById(R.id.goBtn);

        final String[][] sites = {

                //First Category RP
                {
                    "https://www.facebook.com/", "https://www.instagram.com"
                },
                //Second Category SOI
                {
                    "https://www.grab.com/sg", "https://github.com/"
                }
        };

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = sites[catSpinner.getSelectedItemPosition()][subCatSpinner.getSelectedItemPosition()];
                Log.i("URL", url);

                startActivity(new Intent(MainActivity.this, WebViewActivity.class).putExtra("URL", url));

            }
        });

        catSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        String[] rp = getResources().getStringArray(R.array.rp_sub_category);
                        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, rp);
                        subCatSpinner.setAdapter(adapter);
                        break;
                    case 1:
                        String[] soi = getResources().getStringArray(R.array.soi_sub_category);
                        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, soi);
                        subCatSpinner.setAdapter(adapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
