package com.example.demolistviewcoban;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arr;
    ArrayAdapter adapter;
    Button addButton, updateButton;
    EditText editText;
    ListView listView;

    int pos=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.btnAdd);
        updateButton = findViewById(R.id.btnUpdate);
        editText = findViewById(R.id.editTextText);
        listView = findViewById(R.id.listView);

        arr = new ArrayList<>();
        arr.add("Java");
        arr.add("Mobile Apps");

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(adapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_items = editText.getText().toString();
                if (arr.contains(new_items))
                    return;

                arr.add(new_items);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos == -1)
                    return;

                arr.set(pos, editText.getText().toString());
                adapter.notifyDataSetChanged();
                pos = -1;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                editText.setText(arr.get(pos));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arr.get(position) + " removed", Toast.LENGTH_SHORT).show();
                arr.remove(position);
                adapter.notifyDataSetChanged();

                if (pos == position)
                    pos = -1;
                return false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}