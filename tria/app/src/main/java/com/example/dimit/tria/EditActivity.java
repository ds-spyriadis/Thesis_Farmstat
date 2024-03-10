package com.example.dimit.tria;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.Map;

import static java.sql.Types.INTEGER;

public class EditActivity extends AppCompatActivity {



    ContactDbHelper mydb3;
    EditText Tel_Number, Year, Id;
    EditText Name, Tel, Region, Etos,
            Age, Animal, Sheep, Goat, Milking, Licensing, Electrification, Tractor, Sheepmilk, Goatmilk, Milkpersheep, Prevision, Comment,
            Selling_sheep_milk, Selling_Goatmilk, Selling_meat, Subsidies, Female, Manure, Black, Other_income,
            Concentrated_fodder, Trefoil, Hay, Electricity, Replacement_animals, Petroleum, Petrol,
            Medicines, Sponges, Repair, Equipment, Wages_fields, Wages_staff, Expenses_pastures, Other_expenses;
    TextView Total_Revenue, Total_Expenses, Mixed_Revenue, AllYear;
    TextView Button1, Button2, bn,delete;


    String tel_number, current_year, name, region,
            age, total_animals, sheep, goat, milking, licensing, electrification, tractor, sheep_milk, goat_milk, milk_per_sheep, comments,
            selling_sheep_milk, selling_goatmilk, selling_meat, subsidies, female, manure, black, other_income,
            concentrated_fodder, trefoil, hay, electricity, replacement_animals, petroleum, petrol, medicines,
            sponges, repair, equipment, wages_fields, wages_staff, expenses_pastures, other_expenses,
            total_revenue, total_expenses, mixed_revenue,
            green_revenue, red_expenses, green_mixed, yellow_revenue, red_mixed;


    String tel1,year1,text,allyear,id;
    int flagtel=0,flagyear=0;
    int revenue, expenses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);






        mydb3 = new ContactDbHelper(this);


        Tel_Number = (EditText) findViewById(R.id.editText1);
        Year = (EditText) findViewById(R.id.editext2);
        AllYear = (TextView) findViewById(R.id.text_year);


        Name = (EditText) findViewById(R.id.read_name);
        Tel = (EditText) findViewById(R.id.read_number);
        Region = (EditText) findViewById(R.id.read_region);
        Etos = (EditText) findViewById(R.id.read_current_year);

        Age = (EditText) findViewById(R.id.read_age);
        Animal = (EditText) findViewById(R.id.read_animal_number);
        Sheep = (EditText) findViewById(R.id.read_sheep);
        Goat = (EditText) findViewById(R.id.read_goats);
        Milking = (EditText) findViewById(R.id.read_milking);
        Licensing = (EditText) findViewById(R.id.read_licensing);
        Electrification = (EditText) findViewById(R.id.read_electrification);
        Tractor = (EditText) findViewById(R.id.read_tractor);
        Sheepmilk = (EditText) findViewById(R.id.read_sheepmilk);
        Goatmilk = (EditText) findViewById(R.id.read_goatmilk);
        Milkpersheep = (EditText) findViewById(R.id.read_milk_per_sheep);
        //  Prevision = (EditText) findViewById(R.id.read_prevision);

        Comment = (EditText) findViewById(R.id.txt_comment);

        Selling_sheep_milk = (EditText) findViewById(R.id.read_selling_sheep_milk);
        Selling_Goatmilk = (EditText) findViewById(R.id.read_selling_goat_milk);
        Selling_meat = (EditText) findViewById(R.id.read_selling_meat);
        Subsidies = (EditText) findViewById(R.id.read_subsidies);
        Female = (EditText) findViewById(R.id.read_female);
        Manure = (EditText) findViewById(R.id.read_manure);
        Black = (EditText) findViewById(R.id.read_black);
        Other_income = (EditText) findViewById(R.id.read_other_income);

        Concentrated_fodder = (EditText) findViewById(R.id.read_concentrated_fodder);
        Trefoil = (EditText) findViewById(R.id.read_trefoil);
        Hay = (EditText) findViewById(R.id.read_hay);
        Electricity = (EditText) findViewById(R.id.read_electricity);
        Replacement_animals = (EditText) findViewById(R.id.read_replacement_animals);
        Petroleum = (EditText) findViewById(R.id.read_petroleum);
        Petrol = (EditText) findViewById(R.id.read_petrol);
        Medicines = (EditText) findViewById(R.id.read_medicines);
        Sponges = (EditText) findViewById(R.id.read_sponges);

        Repair = (EditText) findViewById(R.id.read_repair);
        Equipment = (EditText) findViewById(R.id.read_equipment);
        Wages_fields = (EditText) findViewById(R.id.read_WAGES_FIELDS);
        Wages_staff = (EditText) findViewById(R.id.read_WAGES_STAFF);
        Expenses_pastures = (EditText) findViewById(R.id.read_EXPENSES_PASTURES);
        Other_expenses = (EditText) findViewById(R.id.read_other_expenses);

        Total_Revenue = (TextView) findViewById(R.id.read_total_revenue);
        Total_Expenses = (TextView) findViewById(R.id.read_total_expenses);
        Mixed_Revenue = (TextView) findViewById(R.id.read_mixed_revenue);

        Button1 = (TextView) findViewById(R.id.button1);
        Button2 = (TextView) findViewById(R.id.button2);
        bn = (TextView) findViewById(R.id.button);
        delete = (TextView) findViewById(R.id.delete);


        id();
        year();
        deleteData();
        finance();


    }


    private void id() {
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 tel1 = Tel_Number.getText().toString();
                int flag = 0;

                if (Tel_Number.getText().toString().isEmpty()) {
                    Toast.makeText(getApplication(), "please add the number...", Toast.LENGTH_SHORT).show();

                } else {

                    searchid(flag);

                }
            }
        });

    }


    private void searchid(int flag) {
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();
        Cursor cursor = contactDbHelper.readContacts(database);


        text = "select year: ";

        while (cursor.moveToNext()) {
            String tel = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TEL));

            if (tel.equals(tel1)) {


                allyear = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));

                text = text + " " + allyear;
                AllYear.setText(text);


                flag = 1;
            }

            contactDbHelper.close();
        }

        if (flag == 0) {
            Toast.makeText(getApplication(), "please add correct number...", Toast.LENGTH_SHORT).show();
        } else {

            flagtel=1;
            year();

        }
    }


    private void year() {
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                year1 = Year.getText().toString();
                int flag = 0;

                if (Tel_Number.getText().toString().isEmpty()) {
                    Toast.makeText(getApplication(), "please add telephone number...", Toast.LENGTH_SHORT).show();

                } else {
                    if (Year.getText().toString().isEmpty()) {
                        Toast.makeText(getApplication(), "please add the number...", Toast.LENGTH_SHORT).show();


                    } else {


                        searchyear(flag);

                    }
                }

            }
        });

    }


    private void searchyear(int flag) {
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();
        Cursor cursor = contactDbHelper.readContacts(database);

        while (cursor.moveToNext()) {
            String year = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));

            if (year1.equals(year)) {
                flag = 1;
            }

            contactDbHelper.close();
        }

        if (flag == 0) {
            Toast.makeText(getApplication(), "please add correct number...", Toast.LENGTH_SHORT).show();
        } else {

            flagyear=1;
            viewContacts();
        }
    }


    private void viewContacts() {
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.readContacts(database);


        while (cursor.moveToNext())


        {


            id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContact.ContactEntry.ID)));

            tel_number = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TEL));
            current_year = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));
            name = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.NAME));
            region = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.REGION));
            age = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.AGE));
            total_animals = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_ANIMALS));
            sheep = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SHEEP));
            goat = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.GOAT));
            milking = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.MILKING));
            licensing = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.LICENSING));
            electrification = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.ELECTRIFICATION));
            tractor = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TRACTOR));
            sheep_milk = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SHEEP_MILK));
            goat_milk = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.GOAT_MILK));
            milk_per_sheep = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.MILK_PER_SHEEP));
            // String prevision = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.PREVISION));
            comments = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.COMMENTS));


            selling_sheep_milk = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SELLING_SHEEP_MILK));
            selling_goatmilk = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SELLING_GOAT_MILK));
            selling_meat = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SELLING_MEAT));
            subsidies = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SUBSIDIES));
            female = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.FEMALE));
            manure = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.MANURE));
            black = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.BLACK));
            other_income = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.OTHER_INCOME));


            concentrated_fodder = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.CONCENTRATED_FODDER));
            trefoil = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TREFOIL));
            hay = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.HAY));
            electricity = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.CURRENT));
            replacement_animals = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.REPLACEMENT_ANIMALS));
            petroleum = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.PETROLEUM));
            petrol = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.PETROL));
            medicines = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.MEDICINES));
            sponges = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SPONGES));
            repair = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.REPAIR));
            equipment = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.EQUIPMENT));
            wages_fields = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.WAGES_FIELDS));
            wages_staff = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.WAGES_STAFF));
            expenses_pastures = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.EXPENSES_PASTURES));
            other_expenses = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.UNFORESEEN));

            total_revenue = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_REVENUE));
            total_expenses = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TOTAL_EXPENSES));
            mixed_revenue = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.MIXED_REVENUE));


            if (tel1.equals(tel_number) && year1.equals(current_year)) {
                Name.setText(name);
                Tel.setText(tel_number);
                Etos.setText(current_year);
                Region.setText(region);


                if (!(age == null)) {

                    Age.setText(age);
                    Animal.setText(total_animals);
                    Sheep.setText(sheep);
                    Goat.setText(goat);
                    Milking.setText(milking);
                    Licensing.setText(licensing);
                    Electrification.setText(electrification);
                    Tractor.setText(tractor);
                    Sheepmilk.setText(sheep_milk);
                    Goatmilk.setText(goat_milk);
                    Milkpersheep.setText(milk_per_sheep);

                    // Prevision.setText(prevision);
                    Comment.setText(comments);
                }

                if (!(selling_goatmilk == null)) {

                    Selling_sheep_milk.setText(selling_sheep_milk);
                    Selling_Goatmilk.setText(selling_goatmilk);
                    Selling_meat.setText(selling_meat);
                    Subsidies.setText(subsidies);
                    Female.setText(female);
                    Manure.setText(manure);
                    Black.setText(black);
                    Other_income.setText(other_income);
                }

                if (!(trefoil == null)) {


                    Concentrated_fodder.setText(concentrated_fodder);
                    Trefoil.setText(trefoil);
                    Hay.setText(hay);
                    Electricity.setText(electricity);
                    Replacement_animals.setText(replacement_animals);
                    Petroleum.setText(petroleum);
                    Petrol.setText(petrol);
                    Medicines.setText(medicines);
                    Sponges.setText(sponges);
                    Repair.setText(repair);
                    Equipment.setText(equipment);
                    Wages_fields.setText(wages_fields);
                    Wages_staff.setText(wages_staff);
                    Expenses_pastures.setText(expenses_pastures);
                    Other_expenses.setText(other_expenses);
                }


                if (!(trefoil == null) || (!(selling_meat == null))) {

                    revenue = Integer.parseInt(total_revenue);
                    expenses = Integer.parseInt(total_expenses);

                    if (revenue >= expenses) {

                        green_revenue = "<font color=#008000>" + total_revenue + "</font>" + "€";
                        red_expenses = "<font color=#FF0000>" + total_expenses + "</font>" + "€";
                        green_mixed = "<font color=#008000>" + mixed_revenue + "</font>" + "€";

                        Total_Revenue.setText(Html.fromHtml(green_revenue));
                        Total_Expenses.setText(Html.fromHtml(red_expenses));
                        Mixed_Revenue.setText(Html.fromHtml(green_mixed));

                    } else {

                        yellow_revenue = "<font color=#FFFF00>" + total_revenue + "</font>" + "€";
                        red_expenses = "<font color=#FF0000>" + total_expenses + "</font>" + "€";
                        red_mixed = "<font color=#FF0000>" + mixed_revenue + "</font>" + "€";

                        Total_Revenue.setText(Html.fromHtml(yellow_revenue));
                        Total_Expenses.setText(Html.fromHtml(red_expenses));
                        Mixed_Revenue.setText(Html.fromHtml(red_mixed));


                    }


                }


                finance();
                deleteData();


            }
        }


        contactDbHelper.close();
    }


    private void deleteData(){



        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                if (flagtel == 1 && flagyear == 1)

                {
                    int flag1 = 0;


                    final Dialog dialog = new Dialog(EditActivity.this);
                    dialog.setContentView(R.layout.activity_popup);
                    dialog.setTitle("");

                    //Her add your textView and ImageView if you want

                    ImageButton dialogButton1 = (ImageButton) dialog.findViewById(R.id.imageButton);
                    ImageButton dialogButton2 = (ImageButton) dialog.findViewById(R.id.imageButton2);

                    // if button is clicked, close the custom dialog
                    dialogButton1.setOnClickListener(new View.OnClickListener() {
                                                         @Override
                                                         public void onClick(View v) {
                                                             dialog.dismiss();
                                                         }
                                                     }


                    );


                    /////////////////////////////////////////////////


                    dialogButton2.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {


                                    mydb3.delete(id);
                                    Toast.makeText(getApplication(), "The entry was deleted...", Toast.LENGTH_SHORT).show();


                                    Name.setText(" ");
                                    Tel.setText(" ");
                                    Etos.setText(" ");
                                    Region.setText(" ");

                                    Age.setText(" ");
                                    Animal.setText(" ");
                                    Sheep.setText(" ");
                                    Goat.setText(" ");
                                    Milking.setText(" ");
                                    Licensing.setText(" ");
                                    Electrification.setText(" ");
                                    Tractor.setText(" ");
                                    Sheepmilk.setText(" ");
                                    Goatmilk.setText(" ");
                                    Milkpersheep.setText(" ");

                                    // Prevision.setText(prevision);
                                    Comment.setText(" ");


                                    Selling_sheep_milk.setText(" ");
                                    Selling_Goatmilk.setText(" ");
                                    Selling_meat.setText(" ");
                                    Subsidies.setText(" ");
                                    Female.setText(" ");
                                    Manure.setText(" ");
                                    Black.setText(" ");
                                    Other_income.setText(" ");


                                    Concentrated_fodder.setText(" ");
                                    Trefoil.setText(" ");
                                    Hay.setText(" ");
                                    Electricity.setText(" ");
                                    Replacement_animals.setText(" ");
                                    Petroleum.setText(" ");
                                    Petrol.setText(" ");
                                    Medicines.setText(" ");
                                    Sponges.setText(" ");
                                    Repair.setText(" ");
                                    Equipment.setText(" ");
                                    Wages_fields.setText(" ");
                                    Wages_staff.setText(" ");
                                    Expenses_pastures.setText(" ");
                                    Other_expenses.setText(" ");

                                    Total_Revenue.setText(" ");
                                    Total_Expenses.setText(" ");
                                    Mixed_Revenue.setText(" ");


                                    dialog.dismiss();

                                }


                            }


                    );

                    dialog.show();


                } else {
                    Toast.makeText(getApplication(), "please add year and telephone number...", Toast.LENGTH_SHORT).show();


                }
            }



        });




    }









    public void finance() {


        bn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (flagtel == 1 && flagyear == 1) {
                            int flag1 = 0;


                            name = Name.getText().toString();
                            tel_number = Tel.getText().toString();
                            region = Region.getText().toString();
                            current_year = Etos.getText().toString();

                            age = Age.getText().toString();
                            total_animals = Animal.getText().toString();
                            sheep = Sheep.getText().toString();
                            goat = Goat.getText().toString();
                            milking = Milking.getText().toString();

                            licensing = Licensing.getText().toString();
                            electrification = Electrification.getText().toString();
                            tractor = Tractor.getText().toString();
                            sheep_milk = Sheepmilk.getText().toString();
                            goat_milk = Goatmilk.getText().toString();
                            comments = Comment.getText().toString();


                            String sell_sheep_milk = Selling_sheep_milk.getText().toString();
                            String sell_goat_milk = Selling_Goatmilk.getText().toString();
                            String sell_meat = Selling_meat.getText().toString();
                            String subsidies = Subsidies.getText().toString();
                            String female = Female.getText().toString();
                            String manure = Manure.getText().toString();
                            String black = Black.getText().toString();
                            String income = Other_income.getText().toString();


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


                            if (total_expenses == null) {
                                total_expenses = "0";
                            }

                            if (total_revenue == null) {
                                total_revenue = "0";
                            }


                            if (Name.getText().toString().isEmpty() || Tel.getText().toString().isEmpty() ||
                                    Region.getText().toString().isEmpty() || Etos.getText().toString().isEmpty()) {
                                Toast.makeText(getApplication(), "please add the first elements...", Toast.LENGTH_SHORT).show();

                            } else {

                                mydb3.edit1(name, tel_number, region, Integer.parseInt(current_year), id);

                                flag1 = 1;

                            }


                            int flag2 = 0;
                            if (Age.getText().toString().isEmpty() && Animal.getText().toString().isEmpty() &&
                                    Sheep.getText().toString().isEmpty() && Goat.getText().toString().isEmpty() &&
                                    Milking.getText().toString().isEmpty() && Licensing.getText().toString().isEmpty() &&
                                    Electrification.getText().toString().isEmpty() && Tractor.getText().toString().isEmpty() &&
                                    Sheepmilk.getText().toString().isEmpty() && Goatmilk.getText().toString().isEmpty() &&
                                    Comment.getText().toString().isEmpty()) {
                                flag2 = 1;
                            } else if (Age.getText().toString().isEmpty() || Animal.getText().toString().isEmpty() ||
                                    Sheep.getText().toString().isEmpty() || Goat.getText().toString().isEmpty() ||
                                    Milking.getText().toString().isEmpty() || Licensing.getText().toString().isEmpty() ||
                                    Electrification.getText().toString().isEmpty() || Tractor.getText().toString().isEmpty() ||
                                    Sheepmilk.getText().toString().isEmpty() || Goatmilk.getText().toString().isEmpty() ||
                                    Comment.getText().toString().isEmpty()) {

                                if (flag2 == 0) {
                                    Toast.makeText(getApplication(), "please add basic unit data...", Toast.LENGTH_SHORT).show();

                                }

                            } else {

                                mydb3.edit2(Integer.parseInt(age), Integer.parseInt(total_animals), Integer.parseInt(sheep),
                                        Integer.parseInt(goat), milking, licensing, electrification, tractor,
                                        Integer.parseInt(sheep_milk), Integer.parseInt(goat_milk), comments, id);


                                flag1 = 1;
                            }


                            int flag3 = 0;
                            if (Selling_meat.getText().toString().isEmpty() && Selling_sheep_milk.getText().toString().isEmpty() &&
                                    Selling_Goatmilk.getText().toString().isEmpty() && Subsidies.getText().toString().isEmpty() &&
                                    Female.getText().toString().isEmpty() && Manure.getText().toString().isEmpty() &&
                                    Black.getText().toString().isEmpty() && Other_income.getText().toString().isEmpty()) {

                                flag3 = 1;
                            } else if (Selling_meat.getText().toString().isEmpty() || Selling_sheep_milk.getText().toString().isEmpty() ||
                                    Selling_Goatmilk.getText().toString().isEmpty() || Subsidies.getText().toString().isEmpty() ||
                                    Female.getText().toString().isEmpty() || Manure.getText().toString().isEmpty() ||
                                    Black.getText().toString().isEmpty() || Other_income.getText().toString().isEmpty()) {
                                if (flag3 == 0) {
                                    Toast.makeText(getApplication(), "please add the revenue values...", Toast.LENGTH_SHORT).show();

                                }

                            } else {
                                mydb3.add_financial1(Integer.parseInt(sell_sheep_milk), Integer.parseInt(sell_goat_milk), Integer.parseInt(sell_meat),
                                        Integer.parseInt(subsidies), Integer.parseInt(female), Integer.parseInt(manure), Integer.parseInt(black),
                                        Integer.parseInt(income), Integer.parseInt(total_expenses), id);

                                flag1 = 1;
                            }


                            int flag4 = 0;

                            if (Concentrated_fodder.getText().toString().isEmpty() && Trefoil.getText().toString().isEmpty() &&
                                    Hay.getText().toString().isEmpty() && Electricity.getText().toString().isEmpty() &&
                                    Replacement_animals.getText().toString().isEmpty() && Petroleum.getText().toString().isEmpty() &&
                                    Petrol.getText().toString().isEmpty() && Medicines.getText().toString().isEmpty() &&
                                    Sponges.getText().toString().isEmpty() && Repair.getText().toString().isEmpty() &&
                                    Equipment.getText().toString().isEmpty() && Wages_fields.getText().toString().isEmpty() &&
                                    Wages_staff.getText().toString().isEmpty() && Expenses_pastures.getText().toString().isEmpty() &&
                                    Other_expenses.getText().toString().isEmpty()) {
                                flag4 = 1;

                            } else if (Concentrated_fodder.getText().toString().isEmpty() || Trefoil.getText().toString().isEmpty() ||
                                    Hay.getText().toString().isEmpty() || Electricity.getText().toString().isEmpty() ||
                                    Replacement_animals.getText().toString().isEmpty() || Petroleum.getText().toString().isEmpty() ||
                                    Petrol.getText().toString().isEmpty() || Medicines.getText().toString().isEmpty() ||
                                    Sponges.getText().toString().isEmpty() || Repair.getText().toString().isEmpty() ||
                                    Equipment.getText().toString().isEmpty() || Wages_fields.getText().toString().isEmpty() ||
                                    Wages_staff.getText().toString().isEmpty() || Expenses_pastures.getText().toString().isEmpty() ||
                                    Other_expenses.getText().toString().isEmpty()) {
                                if (flag4 == 0) {
                                    Toast.makeText(getApplication(), "please add the cost values...", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                mydb3.add_financial2(Integer.parseInt(concentrated_fodder), Integer.parseInt(trefoil), Integer.parseInt(hay),
                                        Integer.parseInt(electricity), Integer.parseInt(replacement_animals), Integer.parseInt(petroleum), Integer.parseInt(petrol),
                                        Integer.parseInt(medicines),
                                        Integer.parseInt(sponges), Integer.parseInt(repair), Integer.parseInt(equipment),
                                        Integer.parseInt(wages_fields), Integer.parseInt(wages_staff), Integer.parseInt(expenses_pastures), Integer.parseInt(other_expenses), Integer.parseInt(total_revenue), id);


                                flag1 = 1;
                            }

                            if (flag1 == 1) {

                                year1 = current_year;
                                tel1 = tel_number;
                                viewContacts();
                            }

                            Toast.makeText(getApplication(),"Edit...",Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(getApplication(), "please add year and telephone number...", Toast.LENGTH_SHORT).show();

                        }
                    }




                    }

        );


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("FLAGTEL",flagtel);
        outState.putInt("FLAGYEAR",flagyear);

        outState.putString("TEL1",tel1);
        outState.putString("YEAR1",year1);
        outState.putString("ALLYEAR",allyear);
        outState.putString("TEXT",text);
        outState.putString("ID",id);



        outState.putString("TOTAL_REVENUE", total_revenue);
        outState.putString("TOTAL_EXPENSES", total_expenses);
        outState.putString("MIXED_REVENUE", mixed_revenue);
        outState.putString("GREEN_REVENUE", green_revenue);
        outState.putString("RED_EXPENSES", red_expenses);
        outState.putString("GREEN_MIXED", green_mixed);
        outState.putString("YELLOW_REVENUE", yellow_revenue);
        outState.putString("RED_MIXED", red_mixed);
        outState.putInt("REVENUE", revenue);
        outState.putInt("EXPENSES", expenses);


        outState.putString("SELLING_MEAT", selling_meat);
        outState.putString("TREFOIL", trefoil);

        outState.putString("CURRENT_YEAR",current_year);
        outState.putString("TEL_NUMBER",tel_number);





    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        flagtel = savedInstanceState.getInt("FLAGTEL");
        flagyear = savedInstanceState.getInt("FLAGYEAR");


        tel1 = savedInstanceState.getString("TEL1");
        year1 = savedInstanceState.getString("YEAR1");
        allyear = savedInstanceState.getString("ALLYEAR");
        text = savedInstanceState.getString("TEXT");
        id = savedInstanceState.getString("ID");




        total_revenue = savedInstanceState.getString("TOTAL_REVENUE");
        total_expenses = savedInstanceState.getString("TOTAL_EXPENSES");
        mixed_revenue = savedInstanceState.getString("MIXED_REVENUE");

        green_revenue = savedInstanceState.getString("GREEN_REVENUE");
        red_expenses = savedInstanceState.getString("RED_EXPENSES");
        green_mixed = savedInstanceState.getString("GREEN_MIXED");
        yellow_revenue = savedInstanceState.getString("YELLOW_REVENUE");
        red_mixed = savedInstanceState.getString("RED_MIXED");

        current_year = savedInstanceState.getString("CURRENT_YEAR");
        tel_number = savedInstanceState.getString("TEL_NUMBER");


        selling_meat = savedInstanceState.getString("SELLING_MEAT");
        trefoil = savedInstanceState.getString("TREFOIL");


        revenue = savedInstanceState.getInt("REVENUE");
        expenses = savedInstanceState.getInt("EXPENSES");


        AllYear.setText(text);


        if (total_revenue == null && total_expenses == null) {
            mixed_revenue = "0";

        }

        if (total_revenue == null) {

            total_revenue = "0";
        }

        if (total_expenses == null) {

            total_expenses = "0";

        }


        if ((total_expenses == null) && (total_revenue == null)) {

            Total_Revenue.setText(" ");
            Total_Expenses.setText(" ");
            Mixed_Revenue.setText(" ");
            }


        if (!(trefoil == null) || (!(selling_meat == null))) {


            revenue = Integer.parseInt(total_revenue);
            expenses = Integer.parseInt(total_expenses);

            if (revenue >= expenses) {

                green_revenue = "<font color=#008000>" + total_revenue + "</font>" + "€";
                red_expenses = "<font color=#FF0000>" + total_expenses + "</font>" + "€";
                green_mixed = "<font color=#008000>" + mixed_revenue + "</font>" + "€";

                Total_Revenue.setText(Html.fromHtml(green_revenue));
                Total_Expenses.setText(Html.fromHtml(red_expenses));
                Mixed_Revenue.setText(Html.fromHtml(green_mixed));

            } else {

                yellow_revenue = "<font color=#FFFF00>" + total_revenue + "</font>" + "€";
                red_expenses = "<font color=#FF0000>" + total_expenses + "</font>" + "€";
                red_mixed = "<font color=#FF0000>" + mixed_revenue + "</font>" + "€";

                Total_Revenue.setText(Html.fromHtml(yellow_revenue));
                Total_Expenses.setText(Html.fromHtml(red_expenses));
                Mixed_Revenue.setText(Html.fromHtml(red_mixed));


            }


        }

    }

}