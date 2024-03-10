package com.example.dimit.tria;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinanceActivity extends AppCompatActivity {


    ContactDbHelper mydb2;
    EditText Selling_sheep_milk, Goatmilk, Selling_meat, Subsidies, Female, Manure, Black, Other_income;
    EditText Concentrated_fodder, Trefoil, Hay, Electricity, Replacement_animals, Petroleum, Petrol,
            Medicines, Sponges, Repair, Equipment, Wages_fields, Wages_staff, Expenses_pastures, Other_expenses;

    TextView text1, text2, text3;
    Button bn, bnannual;
    String id, concentrated_fodder,total_expenses,total_revenue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);


        mydb2 = new ContactDbHelper(this);

        text1 = (TextView) findViewById(R.id.financial);
        text2 = (TextView) findViewById(R.id.revenue);
        text3 = (TextView) findViewById(R.id.txt_cost);

        Selling_sheep_milk = (EditText) findViewById(R.id.txt_selling_sheep_milk);
        Goatmilk = (EditText) findViewById(R.id.txt_selling_goat_milk);
        Selling_meat = (EditText) findViewById(R.id.txt_selling_meat);
        Subsidies = (EditText) findViewById(R.id.txt_subsidies);
        Female = (EditText) findViewById(R.id.txt_female);
        Manure = (EditText) findViewById(R.id.txt_manure);
        Black = (EditText) findViewById(R.id.txt_black);
        Other_income = (EditText) findViewById(R.id.txt_other_income);


        Concentrated_fodder = (EditText) findViewById(R.id.txt_concentrated_fodder);
        Trefoil = (EditText) findViewById(R.id.txt_trefoil);
        Hay = (EditText) findViewById(R.id.txt_hay);
        Electricity = (EditText) findViewById(R.id.txt_electricity);
        Replacement_animals = (EditText) findViewById(R.id.txt_replacement_animals);
        Petroleum = (EditText) findViewById(R.id.txt_petroleum);
        Petrol = (EditText) findViewById(R.id.txt_petrol);
        Medicines = (EditText) findViewById(R.id.txt_medicines);
        Sponges = (EditText) findViewById(R.id.txt_sponges);
        Repair = (EditText) findViewById(R.id.txt_repair);
        Equipment = (EditText) findViewById(R.id.txt_equipment);
        Wages_fields = (EditText) findViewById(R.id.txt_wages_fields);
        Wages_staff = (EditText) findViewById(R.id.txt_wages_staff);
        Expenses_pastures = (EditText) findViewById(R.id.txt_expenses_pastures);
        Other_expenses = (EditText) findViewById(R.id.txt_other_expenses);


        bn = (Button) findViewById(R.id.bn_save2);
        bnannual = (Button) findViewById(R.id.save_annual);

        idContacts();
    }


    private void idContacts() {
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.idContacts(database);


        while (cursor.moveToNext())


        {
            id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContact.ContactEntry.ID)));
            concentrated_fodder = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContact.ContactEntry.CONCENTRATED_FODDER)));
            total_expenses = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_EXPENSES)));
            total_revenue = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_REVENUE)));

        }

        int flag=0;

        if (concentrated_fodder.isEmpty()) {
            flag = 1;
        }else {
            flag=2;
        }

        if(flag==2){
            Concentrated_fodder.setText(concentrated_fodder);
        }



        if(total_expenses.isEmpty()) {
            total_expenses = "0";
        }

        if(total_revenue.isEmpty()) {
            total_revenue = "0";
        }

        contactDbHelper.close();
        finance();


    }


    public void finance() {

        bnannual.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sell_sheep_milk = Selling_sheep_milk.getText().toString();
                        String sell_goat_milk = Goatmilk.getText().toString();
                        String sell_meat = Selling_meat.getText().toString();
                        String subsidies = Subsidies.getText().toString();
                        String female = Female.getText().toString();
                        String manure = Manure.getText().toString();
                        String black = Black.getText().toString();
                        String income = Other_income.getText().toString();


                        if (Selling_meat.getText().toString().isEmpty() || Selling_sheep_milk.getText().toString().isEmpty() ||
                                Goatmilk.getText().toString().isEmpty() || Subsidies.getText().toString().isEmpty() ||
                                Female.getText().toString().isEmpty() || Manure.getText().toString().isEmpty() ||
                                Black.getText().toString().isEmpty() || Other_income.getText().toString().isEmpty()) {
                            Toast.makeText(getApplication(), "please add the revenue values...", Toast.LENGTH_SHORT).show();

                        } else {
                            mydb2.add_financial1(Integer.parseInt(sell_sheep_milk), Integer.parseInt(sell_goat_milk), Integer.parseInt(sell_meat),
                                    Integer.parseInt(subsidies), Integer.parseInt(female), Integer.parseInt(manure), Integer.parseInt(black),
                                    Integer.parseInt(income),Integer.parseInt(total_expenses), id);


                            idContacts();

                            Toast.makeText(getApplication(),"Save...",Toast.LENGTH_SHORT).show();

                        }

                    }
                }

        );






        bn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String concentrated_fodder = Concentrated_fodder.getText().toString();
                        String trefoil = Trefoil.getText().toString();
                        String hay = Hay.getText().toString();
                        String electricity = Electricity.getText().toString();
                        String replacement_animals = Replacement_animals.getText().toString();
                        String petroleum = Petroleum.getText().toString();
                        String petrol = Petrol.getText().toString();
                        String medicines = Medicines.getText().toString();
                        String sponges = Sponges.getText().toString();
                        String repair = Repair.getText().toString();
                        String equipment = Equipment.getText().toString();
                        String wages_fields = Wages_fields.getText().toString();
                        String wages_staff = Wages_staff.getText().toString();
                        String expenses_pastures = Expenses_pastures.getText().toString();
                        String other_expenses = Other_expenses.getText().toString();


                        if (Concentrated_fodder.getText().toString().isEmpty() || Trefoil.getText().toString().isEmpty() ||
                                Hay.getText().toString().isEmpty() || Electricity.getText().toString().isEmpty() ||
                                Replacement_animals.getText().toString().isEmpty() || Petroleum.getText().toString().isEmpty() ||
                                Petrol.getText().toString().isEmpty() || Medicines.getText().toString().isEmpty() ||
                                Sponges.getText().toString().isEmpty() || Repair.getText().toString().isEmpty() ||
                                Equipment.getText().toString().isEmpty() || Wages_fields.getText().toString().isEmpty() ||
                                Wages_staff.getText().toString().isEmpty() || Expenses_pastures.getText().toString().isEmpty() ||
                                Other_expenses.getText().toString().isEmpty()) {
                            Toast.makeText(getApplication(), "please add the cost values...", Toast.LENGTH_SHORT).show();

                        } else {

                            mydb2.add_financial2(Integer.parseInt(concentrated_fodder), Integer.parseInt(trefoil), Integer.parseInt(hay),
                                    Integer.parseInt(electricity), Integer.parseInt(replacement_animals), Integer.parseInt(petroleum), Integer.parseInt(petrol),
                                    Integer.parseInt(medicines),
                                    Integer.parseInt(sponges), Integer.parseInt(repair), Integer.parseInt(equipment),
                                    Integer.parseInt(wages_fields), Integer.parseInt(wages_staff), Integer.parseInt(expenses_pastures), Integer.parseInt(other_expenses),Integer.parseInt(total_revenue), id);


                            idContacts();
                            Toast.makeText(getApplication(),"Save...",Toast.LENGTH_SHORT).show();

                        }


                    }
                }

        );


    }




}

