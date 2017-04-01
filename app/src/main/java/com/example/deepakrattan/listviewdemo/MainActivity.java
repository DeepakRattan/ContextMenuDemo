package com.example.deepakrattan.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewByID
        lv = (ListView) findViewById(R.id.lv);

        String[] state = getResources().getStringArray(R.array.state);
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, state);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.my_layout, state);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView) view).getText().toString();
                Toast.makeText(MainActivity.this, "Item selected " + item, Toast.LENGTH_LONG).show();
            }
        });

        //Registering ListView for context Menu
        registerForContextMenu(lv);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                Toast.makeText(MainActivity.this, "Edit Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "Delete Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Share:
                Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
