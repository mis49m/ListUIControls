package tr.com.mis49m.listuicontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String[] cities = {"istanbul","izmir","Ankara"};

    Spinner spinner;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-- Read references
        spinner = (Spinner) findViewById(R.id.spinner);
        listView = (ListView) findViewById(R.id.listview);

        //-- Create adapter for spinner
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, cities);
        //-- Set adapter to spinner
        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = cities[position];
                Toast.makeText(MainActivity.this, "Spinner:" + selectedCity, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //-- Create adapter for listview
        ArrayAdapter<String> adapterList = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, cities);
        //-- Set adapter to listview
        listView.setAdapter(adapterList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = cities[position];
                Toast.makeText(MainActivity.this, "ListView:" + selectedCity, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
