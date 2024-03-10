package com.example.dimit.tria;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {


    ContactDbHelper mydb;
    EditText Tel_Number, Year, Id;
    TextView Button1, Button2, Clear;
    TextView viewgraph;


    TextView Name, Tel, Region, Etos,AllYear,
            Age, Animal, Sheep, Goat, Milking, Licensing, Electrification, Tractor, Sheepmilk, Goatmilk,Milkpersheep, Prevision, Comment,
            Selling_sheep_milk, Selling_Goatmilk, Selling_meat, Subsidies, Female, Manure, Black, Other_income,
            Concentrated_fodder, Trefoil, Hay, Electricity, Replacement_animals, Petroleum, Petrol,
            Medicines, Sponges, Repair, Equipment, Wages_fields, Wages_staff, Expenses_pastures, Other_expenses,
            Total_Revenue, Total_Expenses, Mixed_Revenue;


    String data_tel,data_year,name,region,
           age,total_animals,sheep,goat,milking,licensing,electrification,tractor,sheep_milk,goat_milk,milk_per_sheep,comment,
           selling_sheep_milk,selling_goatmilk,selling_meat,subsidies,female,manure,black,other_income,
           concentrated_fodder,trefoil,hay,electricity,replacement_animals,petroleum,petrol,medicines,
           sponges,repair,equipment,wages_fields,wages_staff,expenses_pastures,other_expenses,
           total_revenue,total_expenses,mixed_revenue,
           green_revenue,red_expenses,green_mixed,yellow_revenue,red_mixed;

    String tel1,year1,allyear,text;

    int revenue,expenses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        Tel_Number = (EditText) findViewById(R.id.editText1);
        Year = (EditText) findViewById(R.id.editext2);
        AllYear= (TextView)findViewById(R.id.text_year);
        viewgraph = (TextView)findViewById(R.id.diagrambutton);
















        Name = (TextView) findViewById(R.id.read_name);
        Tel = (TextView) findViewById(R.id.read_number);
        Region = (TextView) findViewById(R.id.read_region);
        Etos = (TextView) findViewById(R.id.read_current_year);

        Age = (TextView) findViewById(R.id.read_age);
        Animal = (TextView) findViewById(R.id.read_animal_number);
        Sheep = (TextView) findViewById(R.id.read_sheep);
        Goat = (TextView) findViewById(R.id.read_goats);
        Milking = (TextView) findViewById(R.id.read_milking);
        Licensing = (TextView) findViewById(R.id.read_licensing);
        Electrification = (TextView) findViewById(R.id.read_electrification);
        Tractor = (TextView) findViewById(R.id.read_tractor);
        Sheepmilk = (TextView) findViewById(R.id.read_sheepmilk);
        Goatmilk = (TextView) findViewById(R.id.read_goatmilk);
        Milkpersheep = (TextView) findViewById(R.id.read_milk_per_sheep);

   //      Prevision = (TextView) findViewById(R.id.read_prevision);
        Comment = (TextView) findViewById(R.id.txt_comment);

        Selling_sheep_milk = (TextView) findViewById(R.id.read_selling_sheep_milk);
        Selling_Goatmilk = (TextView) findViewById(R.id.read_selling_goat_milk);
        Selling_meat= (TextView) findViewById(R.id.read_selling_meat);
        Subsidies = (TextView) findViewById(R.id.read_subsidies);
        Female = (TextView) findViewById(R.id.read_female);
        Manure = (TextView) findViewById(R.id.read_manure);
        Black = (TextView) findViewById(R.id.read_black);
        Other_income = (TextView) findViewById(R.id.read_other_income);


        Concentrated_fodder = (TextView) findViewById(R.id.read_concentrated_fodder);
        Trefoil = (TextView) findViewById(R.id.read_trefoil);
        Hay = (TextView) findViewById(R.id.read_hay);
        Electricity = (TextView) findViewById(R.id.read_electricity);
        Replacement_animals = (TextView) findViewById(R.id.read_replacement_animals);
        Petroleum = (TextView) findViewById(R.id.read_petroleum);
        Petrol = (TextView) findViewById(R.id.read_petrol);
        Medicines = (TextView) findViewById(R.id.read_medicines);
        Sponges = (TextView) findViewById(R.id.read_sponges);
        Repair = (TextView) findViewById(R.id.read_repair);
        Equipment = (TextView) findViewById(R.id.read_equipment);
        Wages_fields = (TextView) findViewById(R.id.read_WAGES_FIELDS);
        Wages_staff = (TextView) findViewById(R.id.read_WAGES_STAFF);
        Expenses_pastures = (TextView) findViewById(R.id.read_EXPENSES_PASTURES);
        Other_expenses = (TextView) findViewById(R.id.read_other_expenses);


        Total_Revenue = (TextView) findViewById(R.id.read_total_revenue);
        Total_Expenses = (TextView) findViewById(R.id.read_total_expenses);
        Mixed_Revenue = (TextView) findViewById(R.id.read_mixed_revenue);





        Button1 = (TextView) findViewById(R.id.button1);
        Button2 = (TextView) findViewById(R.id.button2);
        viewgraph = (TextView) findViewById(R.id.diagrambutton);




        id();
        year();












       /* if(savedInstanceState != null) {
            green_revenue = savedInstanceState.getString("SaveGRevenue");

            Total_Revenue.setText(green_revenue);

        }

        */



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


        text="select year: ";
        while (cursor.moveToNext()) {
            String tel = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TEL));

            if (tel.equals(tel1)) {


                allyear = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));

                text = text + " " + allyear;
                AllYear.setText(text);

                flag = 1; }

            contactDbHelper.close(); }

        if (flag == 0) {
            Toast.makeText(getApplication(), "please add correct number...", Toast.LENGTH_SHORT).show();
        } else {

            year();

        }
    }


    private void year() {
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 year1 = Year.getText().toString();


                 if (Tel_Number.getText().toString().isEmpty()) {
                    Toast.makeText(getApplication(), "please add telephone number...", Toast.LENGTH_SHORT).show();

                }
                else {

                     if (Year.getText().toString().isEmpty()) {
                         Toast.makeText(getApplication(), "please add the number...", Toast.LENGTH_SHORT).show();

                     } else {

                         searchyear();


                     }
                 }
            }
        });

    }


    private void searchyear() {
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();
        Cursor cursor = contactDbHelper.readContacts(database);

        int flag=0;
        while (cursor.moveToNext()) {
            String year = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));
            String tel = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TEL));

            if (year1.equals(year) && tel.equals(tel1) ) {
                flag = 1; }

            contactDbHelper.close(); }

        if (flag == 0) {
            Toast.makeText(getApplication(), "please add correct number...", Toast.LENGTH_SHORT).show();
        } else {

            viewContacts();



        }
    }








    private void viewContacts() {
        ContactDbHelper contactDbHelper = new ContactDbHelper(this);
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();

        Cursor cursor = contactDbHelper.readContacts(database);


        while (cursor.moveToNext())



        {
            data_tel = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.TEL));
            data_year = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.YEAR));
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

           //  String prevision = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.PREVISION));
            comment = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.COMMENTS));



            selling_sheep_milk = cursor.getString(cursor.getColumnIndex(ContactContact.ContactEntry.SELLING_SHEEP_MILK)) +"€";
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























            if (tel1.equals(data_tel)&& year1.equals(data_year))
        {
            Name.setText(name);
            Tel.setText(data_tel);
            Etos.setText(data_year);
            Region.setText(region);



            if (trefoil == null && selling_meat == null) {
                mixed_revenue = "0";

            }

           if(age == null){
               age = " ";
               total_animals = "0";
               sheep = "0";
               goat =  "0";
               milking = " ";
               licensing = " ";
               electrification = " ";
               tractor = " ";
               sheep_milk = "0";
               goat_milk= "0";
               milk_per_sheep = "0";
               comment = " ";


           }
           if(selling_goatmilk == null) {

               selling_sheep_milk = "0";
               selling_goatmilk = "0";
               subsidies = "0";
               selling_meat = "0";
               female = "0";
               manure = "0";
               black = "0";
               other_income = "0";
               sheep_milk = "0";
               goat_milk = "0";
               milk_per_sheep = "0";
               total_revenue = "0";
           }

            if(trefoil == null) {


                concentrated_fodder = "0";
                trefoil = "0";
                hay = "0";
                electricity = "0";
                replacement_animals = "0";
                petroleum = "0";
                petrol = "0";
                medicines = "0";
                sponges = "0";
                repair = "0";
                equipment = "0";
                wages_fields = "0";
                wages_staff = "0";
                expenses_pastures = "0";
                other_expenses = "0";
                total_expenses = "0";
            }









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
            Comment.setText(comment);



            Selling_sheep_milk.setText(selling_sheep_milk);
            Selling_Goatmilk.setText(selling_goatmilk);
            Selling_meat.setText(selling_meat);
            Subsidies.setText(subsidies);
            Female.setText(female);
            Manure.setText(manure);
            Black.setText(black);
            Other_income.setText(other_income);


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


            revenue = Integer.parseInt(total_revenue);
            expenses = Integer.parseInt(total_expenses);

            if(revenue>=expenses) {

                green_revenue = "<font color=#008000>" + total_revenue + "</font>" + "€";
                red_expenses = "<font color=#FF0000>" + total_expenses + "</font>" + "€";
                green_mixed = "<font color=#008000>" + mixed_revenue + "</font>" + "€";

                Total_Revenue.setText(Html.fromHtml(green_revenue) );
                Total_Expenses.setText(Html.fromHtml(red_expenses));
                Mixed_Revenue.setText(Html.fromHtml(green_mixed));

            }
            else{

                yellow_revenue = "<font color=#FFFF00>" + total_revenue + "</font>" + "€";
                red_expenses = "<font color=#FF0000>" + total_expenses + "</font>" + "€";
                red_mixed = "<font color=#FF0000>" + mixed_revenue + "</font>" + "€";

                Total_Revenue.setText(Html.fromHtml(yellow_revenue));
                Total_Expenses.setText(Html.fromHtml(red_expenses));
                Mixed_Revenue.setText(Html.fromHtml(red_mixed));


            }
        }
        }





        viewgraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent diagram = new Intent(ViewActivity.this, DiagramActivity.class);
                diagram.putExtra("TEL",data_tel);
                startActivity(diagram);




            }
        });






        contactDbHelper.close();




    }































    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("TEL1",tel1);
        outState.putString("YEAR1",year1);
        outState.putString("ALLYEAR",allyear);
        outState.putString("TEXT",text);

        outState.putString("NAME",name);
        outState.putString("DATATEL",data_tel);
        outState.putString("DATAYEAR",data_year);
        outState.putString("REGION",region);

        outState.putString("AGE",age);
        outState.putString("TOTAL_ANIMALS",total_animals);
        outState.putString("SHEEP",sheep);
        outState.putString("GOAT",goat);
        outState.putString("MILKING",milking);
        outState.putString("LICENSING",licensing);
        outState.putString("ELECTRIFICATION",electrification);
        outState.putString("TRACTOR",tractor);
        outState.putString("SHEEP_MILK",sheep_milk);
        outState.putString("GOAT_MILK",goat_milk);
        outState.putString("MILK_PER_SHEEP",milk_per_sheep);
        outState.putString("COMMENT",comment);

        outState.putString("SELLING_SHEEP_MILK",selling_sheep_milk);
        outState.putString("SELLING_GOAT_MILK",selling_goatmilk);
        outState.putString("SELLING_MEAT",selling_meat);
        outState.putString("SUBSIDIES",subsidies);
        outState.putString("FEMALE",female);
        outState.putString("MANURE",manure);
        outState.putString("BLACK",black);
        outState.putString("OTHER_INCOME",other_income);

        outState.putString("CONCENTRATED_FODDER",concentrated_fodder);
        outState.putString("TREFOIL",trefoil);
        outState.putString("HAY",hay);
        outState.putString("ELECTRICITY",electricity);
        outState.putString("REPLACEMENT_ANIMALS",replacement_animals);
        outState.putString("PETROLEUM",petroleum);
        outState.putString("PETROL",petrol);
        outState.putString("MEDICINES",medicines);

        outState.putString("SPONGES",sponges);
        outState.putString("REPAIR",repair);
        outState.putString("EQUIPMENT",equipment);
        outState.putString("WAGES_FIELDS",wages_fields);
        outState.putString("WAGES_STAFF",wages_staff);
        outState.putString("EXPENSES_PASTURES",expenses_pastures);
        outState.putString("OTHER_EXPENSES",other_expenses);




        outState.putString("TOTAL_REVENUE",total_revenue);
        outState.putString("TOTAL_EXPENSES",total_expenses);
        outState.putString("MIXED_REVENUE",mixed_revenue);


        outState.putString("GREEN_REVENUE",green_revenue);
        outState.putString("RED_EXPENSES",red_expenses);
        outState.putString("GREEN_MIXED",green_mixed);
        outState.putString("YELLOW_REVENUE",yellow_revenue);
        outState.putString("RED_MIXED",red_mixed);
        outState.putInt("REVENUE",revenue);
        outState.putInt("EXPENSES",expenses);


    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        tel1 = savedInstanceState.getString("TEL1");
        year1 = savedInstanceState.getString("YEAR1");
        allyear = savedInstanceState.getString("ALLYEAR");
        text = savedInstanceState.getString("TEXT");

        name = savedInstanceState.getString("NAME");
        data_tel = savedInstanceState.getString("DATATEL");
        data_year = savedInstanceState.getString("DATAYEAR");
        region = savedInstanceState.getString("REGION");

        age = savedInstanceState.getString("AGE");
        total_animals = savedInstanceState.getString("TOTAL_ANIMALS");
        sheep = savedInstanceState.getString("SHEEP");
        goat = savedInstanceState.getString("GOAT");
        milking = savedInstanceState.getString("MILKING");
        licensing = savedInstanceState.getString("LICENSING");
        electrification = savedInstanceState.getString("ELECTRIFICATION");
        tractor = savedInstanceState.getString("TRACTOR");
        sheep_milk = savedInstanceState.getString("SHEEP_MILK");
        goat_milk = savedInstanceState.getString("GOAT_MILK");
        milk_per_sheep = savedInstanceState.getString("MILK_PER_SHEEP");
        comment = savedInstanceState.getString("COMMENT");


        selling_sheep_milk = savedInstanceState.getString("SELLING_SHEEP_MILK");
        selling_goatmilk = savedInstanceState.getString("SELLING_GOAT_MILK");
        selling_meat = savedInstanceState.getString("SELLING_MEAT");
        subsidies = savedInstanceState.getString("SUBSIDIES");
        female = savedInstanceState.getString("FEMALE");
        manure = savedInstanceState.getString("MANURE");
        black = savedInstanceState.getString("BLACK");
        other_income = savedInstanceState.getString("OTHER_INCOME");

        concentrated_fodder = savedInstanceState.getString("CONCENTRATED_FODDER");
        trefoil = savedInstanceState.getString("TREFOIL");
        hay = savedInstanceState.getString("HAY");
        electricity = savedInstanceState.getString("ELECTRICITY");
        replacement_animals = savedInstanceState.getString("REPLACEMENT_ANIMALS");
        petroleum = savedInstanceState.getString("PETROLEUM");
        petrol = savedInstanceState.getString("PETROL");
        medicines = savedInstanceState.getString("MEDICINES");

        sponges = savedInstanceState.getString("SPONGES");
        repair = savedInstanceState.getString("REPAIR");
        equipment = savedInstanceState.getString("EQUIPMENT");
        wages_fields = savedInstanceState.getString("WAGES_FIELDS");
        wages_staff = savedInstanceState.getString("WAGES_STAFF");
        expenses_pastures = savedInstanceState.getString("EXPENSES_PASTURES");
        other_expenses = savedInstanceState.getString("OTHER_EXPENSES");

        total_revenue = savedInstanceState.getString("TOTAL_REVENUE");
        total_expenses = savedInstanceState.getString("TOTAL_EXPENSES");
        mixed_revenue = savedInstanceState.getString("MIXED_REVENUE");

        green_revenue = savedInstanceState.getString("GREEN_REVENUE");
        red_expenses = savedInstanceState.getString("RED_EXPENSES");
        green_mixed = savedInstanceState.getString("GREEN_MIXED");
        yellow_revenue = savedInstanceState.getString("YELLOW_REVENUE");
        red_mixed = savedInstanceState.getString("RED_MIXED");

        revenue = savedInstanceState.getInt("REVENUE");
        expenses = savedInstanceState.getInt("EXPENSES");




        //////////ELENXOS////////


        if (name == null) {
            name = " ";
            data_tel = " ";
            data_year = " ";
            region = " ";
        }

            if (trefoil == null && selling_meat == null) {
                mixed_revenue = "0";

            }

            if(age == null){
                age = " ";
                total_animals = "0";
                sheep = "0";
                goat =  "0";
                milking = " ";
                licensing = " ";
                electrification = " ";
                tractor = " ";
                sheep_milk = "0";
                goat_milk= "0";
                milk_per_sheep = "0";
                comment = " ";


            }
            if(selling_goatmilk == null) {

                selling_sheep_milk = "0";
                selling_goatmilk = "0";
                subsidies = "0";
                selling_meat = "0";
                female = "0";
                manure = "0";
                black = "0";
                other_income = "0";
                sheep_milk = "0";
                goat_milk = "0";
                milk_per_sheep = "0";
                total_revenue = "0";
            }

            if(trefoil == null) {


                concentrated_fodder = "0";
                trefoil = "0";
                hay = "0";
                electricity = "0";
                replacement_animals = "0";
                petroleum = "0";
                petrol = "0";
                medicines = "0";
                sponges = "0";
                repair = "0";
                equipment = "0";
                wages_fields = "0";
                wages_staff = "0";
                expenses_pastures = "0";
                other_expenses = "0";
                total_expenses = "0";
            }








        AllYear.setText(text);




        Name.setText(name);
        Tel.setText(data_tel);
        Etos.setText(data_year);
        Region.setText(region);

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
        Comment.setText(comment);



        Selling_sheep_milk.setText(selling_sheep_milk);
        Selling_Goatmilk.setText(selling_goatmilk);
        Selling_meat.setText(selling_meat);
        Subsidies.setText(subsidies);
        Female.setText(female);
        Manure.setText(manure);
        Black.setText(black);
        Other_income.setText(other_income);


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


        revenue = Integer.parseInt(total_revenue);
        expenses = Integer.parseInt(total_expenses);

        if(revenue>=expenses) {

            green_revenue = "<font color=#008000>" + total_revenue + "</font>" + "€";
            red_expenses = "<font color=#FF0000>" + total_expenses + "</font>" + "€";
            green_mixed = "<font color=#008000>" + mixed_revenue + "</font>" + "€";

            Total_Revenue.setText(Html.fromHtml(green_revenue) );
            Total_Expenses.setText(Html.fromHtml(red_expenses));
            Mixed_Revenue.setText(Html.fromHtml(green_mixed));

        }
        else{

            yellow_revenue = "<font color=#FFFF00>" + total_revenue + "</font>"+ "€";
            red_expenses = "<font color=#FF0000>" + total_expenses + "</font>"+ "€";
            red_mixed = "<font color=#FF0000>" + mixed_revenue + "</font>"+ "€";

            Total_Revenue.setText(Html.fromHtml(yellow_revenue));
            Total_Expenses.setText(Html.fromHtml(red_expenses));
            Mixed_Revenue.setText(Html.fromHtml(red_mixed));


        }
    }





}