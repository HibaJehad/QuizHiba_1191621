package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private  EditText salary;
    private Button addButt;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editTextName);
        salary = findViewById(R.id.editTextSalary);
        addButt = findViewById(R.id.ButtAdd);
        sp = findViewById(R.id.spinner);


    }

    public void clickAdd(View view) {

        Employee[] employees = new Employee[5];
        String Name1 = Name.getText().toString();
        int Salary1 = Integer.parseInt(salary.getText().toString());

        employees[0] = new Employee("Name1",Salary1);
        employees[1] = new Employee("Name1",Salary1);
        employees[2] = new Employee("Name1",Salary1);
        employees[3] = new Employee("Name1",Salary1);
        employees[4] = new Employee("Name1",Salary1);

        String spinner = sp.getSelectedItem().toString();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String booksString = gson.toJson(employees);
        editor.putString("hiba",booksString);
        editor.commit();

        Toast.makeText(this,"save Data /n" +booksString,Toast.LENGTH_LONG).show();

    }

    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<Employee> Items=new ArrayList<Employee>();
        MyCustomAdapter(ArrayList<Employee> Items ) {
            this.Items=Items;

        }


        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public String getItem(int position) {
            return Items.get(position).getNameEmplyee();

        }

        @Override
        public long getItemId(int position) {
            return  position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater =getLayoutInflater();
            View view1=linflater.inflate(R.layout.activity_main, null);

            return view1;

        }



    }
}