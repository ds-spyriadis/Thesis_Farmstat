package com.example.dimit.tria;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 9;

    public static final String CREATE_TABLE = "CREATE TABLE " + ContactContact.ContactEntry.TABLE_NAME +
            " (" + ContactContact.ContactEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            ContactContact.ContactEntry.TEL + " TEXT," +
            ContactContact.ContactEntry.YEAR + " NUMBER," +
            ContactContact.ContactEntry.NAME + " TEXT," +
            ContactContact.ContactEntry.REGION + " TEXT," +
            ContactContact.ContactEntry.AGE + " NUMBER," +
            ContactContact.ContactEntry.TOTAL_ANIMALS + " NUMBER," +
            ContactContact.ContactEntry.SHEEP + " NUMBER," +
            ContactContact.ContactEntry.GOAT + " NUMBER," +
            ContactContact.ContactEntry.MILKING +" TEXT," +
            ContactContact.ContactEntry.LICENSING + " TEXT," +
            ContactContact.ContactEntry.ELECTRIFICATION + " TEXT," +
            ContactContact.ContactEntry.TRACTOR + " TEXT," +
            ContactContact.ContactEntry.SHEEP_MILK + " NUMBER," +
            ContactContact.ContactEntry.GOAT_MILK + " NUMBER," +
            ContactContact.ContactEntry.MILK_PER_SHEEP + " NUMBER," +
            ContactContact.ContactEntry.PREVISION +" NUMBER," +
            ContactContact.ContactEntry.COMMENTS +" TEXT," +
            ContactContact.ContactEntry.SELLING_SHEEP_MILK +" NUMBER," +
            ContactContact.ContactEntry.SELLING_GOAT_MILK +" NUMBER," +
            ContactContact.ContactEntry.SELLING_MEAT +" NUMBER," +
            ContactContact.ContactEntry.SUBSIDIES +" NUMBER," +
            ContactContact.ContactEntry.FEMALE +" NUMBER," +
            ContactContact.ContactEntry.MANURE +" NUMBER," +
            ContactContact.ContactEntry.BLACK +" NUMBER," +
            ContactContact.ContactEntry.OTHER_INCOME +" NUMBER," +
            ContactContact.ContactEntry.CONCENTRATED_FODDER +" NUMBER," +
            ContactContact.ContactEntry.TREFOIL +" NUMBER," +
            ContactContact.ContactEntry.HAY +" NUMBER," +
            ContactContact.ContactEntry.CURRENT +" NUMBER," +
            ContactContact.ContactEntry.REPLACEMENT_ANIMALS +" NUMBER," +
            ContactContact.ContactEntry.PETROLEUM +" NUMBER," +
            ContactContact.ContactEntry.PETROL +" NUMBER," +
            ContactContact.ContactEntry.MEDICINES +" NUMBER," +
            ContactContact.ContactEntry.SPONGES +" NUMBER," +
            ContactContact.ContactEntry.REPAIR +" NUMBER," +
            ContactContact.ContactEntry.EQUIPMENT +" NUMBER," +
            ContactContact.ContactEntry.WAGES_FIELDS +" NUMBER," +
            ContactContact.ContactEntry.WAGES_STAFF +" NUMBER," +
            ContactContact.ContactEntry.EXPENSES_PASTURES +" NUMBER," +
            ContactContact.ContactEntry.UNFORESEEN +" NUMBER," +
            ContactContact.ContactEntry.TOTAL_REVENUE +" NUMBER," +
            ContactContact.ContactEntry.TOTAL_EXPENSES +" NUMBER," +
            ContactContact.ContactEntry.MIXED_REVENUE + " NUMBER)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + ContactContact.ContactEntry.TABLE_NAME;


    public ContactDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("Database Operations", "Database created...");
    }






    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table created...");

    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }




    public void addContact( String tel, int etos, String name, String region ) {

        SQLiteDatabase data = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContact.ContactEntry.TEL, tel);
        contentValues.put(ContactContact.ContactEntry.YEAR, etos);
        contentValues.put(ContactContact.ContactEntry.NAME, name);
        contentValues.put(ContactContact.ContactEntry.REGION, region);

        data.insert(ContactContact.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations", "One Raw inserted...");
        data.close();

        return;

    }







    public void addbasic(int age, int animal, int sheep, int goat, String milking, String licensing, String electrification,
                         String tractor, int sheepmilk, int goatmilk, String comments, String id) {
        SQLiteDatabase data = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();



        int milk_per_sheep = sheepmilk/sheep;

        contentValues.put(ContactContact.ContactEntry.AGE, age);
        contentValues.put(ContactContact.ContactEntry.TOTAL_ANIMALS, animal);
        contentValues.put(ContactContact.ContactEntry.SHEEP, sheep);
        contentValues.put(ContactContact.ContactEntry.GOAT, goat);
        contentValues.put(ContactContact.ContactEntry.MILKING, milking);
        contentValues.put(ContactContact.ContactEntry.LICENSING, licensing);
        contentValues.put(ContactContact.ContactEntry.ELECTRIFICATION, electrification);
        contentValues.put(ContactContact.ContactEntry.TRACTOR, tractor);
        contentValues.put(ContactContact.ContactEntry.SHEEP_MILK, sheepmilk);
        contentValues.put(ContactContact.ContactEntry.GOAT_MILK, goatmilk);
        contentValues.put(ContactContact.ContactEntry.MILK_PER_SHEEP, milk_per_sheep);
        contentValues.put(ContactContact.ContactEntry.COMMENTS, comments);


             String row = String.valueOf(ContactContact.ContactEntry.ID);

             String selection = row + " LIKE ?";
             String [] selectionArgs = { id };


        data.update(ContactContact.ContactEntry.TABLE_NAME,contentValues,selection, selectionArgs);
        data.close();

        return;
    }







    public void add_financial1(int sell_sheep_milk, int sell_goat_milk, int sell_meat, int subsidies,
                              int female, int manure, int black, int other_income, int total_expenses, String id)

    {
        SQLiteDatabase data1 = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        int total_revenue=0;

        total_revenue = sell_sheep_milk + sell_goat_milk + sell_meat + subsidies + female + manure + black + other_income;


        int mixed_revenue;

        if (total_revenue>total_expenses) {

            mixed_revenue = total_revenue - total_expenses;
        }
        else {

            mixed_revenue = total_expenses - total_revenue;
        }






        int concentrated_fodder = (int) (sell_sheep_milk * 0.77);

        contentValues.put(ContactContact.ContactEntry.SELLING_SHEEP_MILK, sell_sheep_milk);
        contentValues.put(ContactContact.ContactEntry.SELLING_GOAT_MILK, sell_goat_milk);
        contentValues.put(ContactContact.ContactEntry.SELLING_MEAT, sell_meat);
        contentValues.put(ContactContact.ContactEntry.SUBSIDIES, subsidies);
        contentValues.put(ContactContact.ContactEntry.FEMALE, female);
        contentValues.put(ContactContact.ContactEntry.MANURE, manure);
        contentValues.put(ContactContact.ContactEntry.BLACK, black);
        contentValues.put(ContactContact.ContactEntry.OTHER_INCOME, other_income);

        contentValues.put(ContactContact.ContactEntry.CONCENTRATED_FODDER, concentrated_fodder);
        contentValues.put(ContactContact.ContactEntry.TOTAL_REVENUE, total_revenue);
        contentValues.put(ContactContact.ContactEntry.MIXED_REVENUE, mixed_revenue);



        String row = String.valueOf(ContactContact.ContactEntry.ID);

        String selection = row + " LIKE ?";
        String [] selectionArgs = { id };


        data1.update(ContactContact.ContactEntry.TABLE_NAME,contentValues,selection, selectionArgs);
        data1.close();

        return;
    }






    public void add_financial2(int  concentrated_fodder, int  trefoil, int  hay, int  electricity,
                              int  replacement_animals,int  petroleum, int  petrol,
                              int  medicines, int  sponges, int  repair, int  equipment, int  wages_fields,
                              int  wages_staff, int  expenses_pastures ,int  other_expenses, int total_revenue, String id)

    {
        SQLiteDatabase data1 = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        int total_expenses = concentrated_fodder + trefoil + hay + electricity + replacement_animals + petroleum + petrol +
              medicines + sponges + repair + equipment + wages_fields +wages_staff + expenses_pastures + other_expenses;

        int mixed_revenue;

        if (total_revenue>total_expenses) {

            mixed_revenue = total_revenue - total_expenses;
        }
        else {

            mixed_revenue = total_expenses - total_revenue;
        }


        contentValues.put(ContactContact.ContactEntry.CONCENTRATED_FODDER, concentrated_fodder);
        contentValues.put(ContactContact.ContactEntry.TREFOIL, trefoil);
        contentValues.put(ContactContact.ContactEntry.HAY, hay);
        contentValues.put(ContactContact.ContactEntry.CURRENT, electricity);
        contentValues.put(ContactContact.ContactEntry.REPLACEMENT_ANIMALS, replacement_animals);
        contentValues.put(ContactContact.ContactEntry.PETROLEUM, petroleum);
        contentValues.put(ContactContact.ContactEntry.PETROL, petrol);
        contentValues.put(ContactContact.ContactEntry.MEDICINES, medicines);
        contentValues.put(ContactContact.ContactEntry.SPONGES, sponges);
        contentValues.put(ContactContact.ContactEntry.REPAIR, repair);
        contentValues.put(ContactContact.ContactEntry.EQUIPMENT, equipment);
        contentValues.put(ContactContact.ContactEntry.WAGES_FIELDS, wages_fields);
        contentValues.put(ContactContact.ContactEntry.WAGES_STAFF, wages_staff);
        contentValues.put(ContactContact.ContactEntry.EXPENSES_PASTURES, expenses_pastures);
        contentValues.put(ContactContact.ContactEntry.UNFORESEEN, other_expenses);
        contentValues.put(ContactContact.ContactEntry.TOTAL_EXPENSES, total_expenses);
        contentValues.put(ContactContact.ContactEntry.MIXED_REVENUE, mixed_revenue);






        String row = String.valueOf(ContactContact.ContactEntry.ID);

        String selection = row + " LIKE ?";
        String [] selectionArgs = { id };


        data1.update(ContactContact.ContactEntry.TABLE_NAME,contentValues,selection, selectionArgs);
        data1.close();

        return;
    }






    public Cursor readContacts(SQLiteDatabase database)
    {
        String[] projection = {ContactContact.ContactEntry.ID,ContactContact.ContactEntry.TEL,ContactContact.ContactEntry.YEAR,
                ContactContact.ContactEntry.NAME,ContactContact.ContactEntry.REGION,
                ContactContact.ContactEntry.AGE,ContactContact.ContactEntry.TOTAL_ANIMALS,
                ContactContact.ContactEntry.SHEEP, ContactContact.ContactEntry.GOAT,
                ContactContact.ContactEntry.MILKING, ContactContact.ContactEntry.LICENSING,
                ContactContact.ContactEntry.ELECTRIFICATION,ContactContact.ContactEntry.TRACTOR,
                ContactContact.ContactEntry.SHEEP_MILK, ContactContact.ContactEntry.GOAT_MILK,
                ContactContact.ContactEntry.MILK_PER_SHEEP, ContactContact.ContactEntry.PREVISION,
                ContactContact.ContactEntry.COMMENTS,ContactContact.ContactEntry.SELLING_SHEEP_MILK,
                ContactContact.ContactEntry.SELLING_GOAT_MILK,ContactContact.ContactEntry.SELLING_MEAT,
                ContactContact.ContactEntry.SUBSIDIES,ContactContact.ContactEntry.FEMALE,
                ContactContact.ContactEntry.MANURE,ContactContact.ContactEntry.BLACK,
                ContactContact.ContactEntry.OTHER_INCOME,ContactContact.ContactEntry.CONCENTRATED_FODDER,
                ContactContact.ContactEntry.TREFOIL,ContactContact.ContactEntry.HAY,
                ContactContact.ContactEntry.CURRENT,ContactContact.ContactEntry.REPLACEMENT_ANIMALS,
                ContactContact.ContactEntry.PETROLEUM,ContactContact.ContactEntry.PETROL,
                ContactContact.ContactEntry.MEDICINES,ContactContact.ContactEntry.SPONGES,
                ContactContact.ContactEntry.REPAIR,ContactContact.ContactEntry.EQUIPMENT,
                ContactContact.ContactEntry.WAGES_FIELDS,ContactContact.ContactEntry.WAGES_STAFF,
                ContactContact.ContactEntry.EXPENSES_PASTURES,ContactContact.ContactEntry.UNFORESEEN,
                ContactContact.ContactEntry.TOTAL_REVENUE,ContactContact.ContactEntry.TOTAL_EXPENSES,
                ContactContact.ContactEntry.MIXED_REVENUE,ContactContact.ContactEntry.MIXED_REVENUE


        };

        Cursor cursor = database.query(ContactContact.ContactEntry.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;

    }







    public Cursor readContacts1(SQLiteDatabase database)
    {
        String[] projection = {ContactContact.ContactEntry.TEL,ContactContact.ContactEntry.NAME

        };

        Cursor cursor = database.query(ContactContact.ContactEntry.TABLE_NAME,projection,null,null,null,null,ContactContact.ContactEntry.NAME + " COLLATE NOCASE");
        return cursor;

    }






    public Cursor readtel(SQLiteDatabase database, String tel)
    {
        String[] projection = {ContactContact.ContactEntry.TEL,ContactContact.ContactEntry.YEAR,ContactContact.ContactEntry.TOTAL_REVENUE,
                ContactContact.ContactEntry.TOTAL_EXPENSES,ContactContact.ContactEntry.MIXED_REVENUE

        };




        String row = String.valueOf(ContactContact.ContactEntry.TEL);

        String selection = row + " LIKE ?";
        String [] selectionArgs = { tel };



        Cursor cursor = database.query(ContactContact.ContactEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,ContactContact.ContactEntry.YEAR + " ASC");
        return cursor;

    }















    public Cursor idContacts(SQLiteDatabase database)
    {
        String[] projection = {ContactContact.ContactEntry.ID,ContactContact.ContactEntry.CONCENTRATED_FODDER,
                ContactContact.ContactEntry.TEL,ContactContact.ContactEntry.YEAR,
                ContactContact.ContactEntry.TOTAL_EXPENSES,ContactContact.ContactEntry.TOTAL_REVENUE,};
        Cursor cursor = database.query(ContactContact.ContactEntry.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;

    }








    public void   edit1(String name, String tel, String region, int etos, String id)
    {
        SQLiteDatabase data1 = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put(ContactContact.ContactEntry.NAME,name);
        contentValues.put(ContactContact.ContactEntry.TEL, tel);
        contentValues.put(ContactContact.ContactEntry.REGION, region);
        contentValues.put(ContactContact.ContactEntry.YEAR, etos);


        String row = String.valueOf(ContactContact.ContactEntry.ID);

        String selection = row + " LIKE ?";
        String [] selectionArgs = { id };


        data1.update(ContactContact.ContactEntry.TABLE_NAME,contentValues,selection, selectionArgs);
        data1.close();

        return;
    }




        public void   edit2(int age, int animal, int sheep, int goat, String milking,String licensing,
                            String electrification,String tractor,int sheepmilk, int goatmilk , String comment,String id)
    {
            SQLiteDatabase data1 = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();


            contentValues.put(ContactContact.ContactEntry.AGE, age);
            contentValues.put(ContactContact.ContactEntry.TOTAL_ANIMALS, animal );
            contentValues.put(ContactContact.ContactEntry.SHEEP,sheep);
            contentValues.put(ContactContact.ContactEntry.GOAT,goat );
            contentValues.put(ContactContact.ContactEntry.MILKING, milking);
            contentValues.put(ContactContact.ContactEntry.LICENSING,licensing );
            contentValues.put(ContactContact.ContactEntry.ELECTRIFICATION,electrification );
            contentValues.put(ContactContact.ContactEntry.TRACTOR,tractor );
            contentValues.put(ContactContact.ContactEntry.SHEEP_MILK,sheepmilk );
            contentValues.put(ContactContact.ContactEntry.GOAT_MILK,goatmilk );
            contentValues.put(ContactContact.ContactEntry.COMMENTS,comment );

            int milk_per_sheep = sheepmilk/goatmilk;


            contentValues.put(ContactContact.ContactEntry.MILK_PER_SHEEP,milk_per_sheep );


            String row = String.valueOf(ContactContact.ContactEntry.ID);

            String selection = row + " LIKE ?";
            String [] selectionArgs = { id };


            data1.update(ContactContact.ContactEntry.TABLE_NAME,contentValues,selection, selectionArgs);
            data1.close();

            return;
        }













public void   edit(int sell_sheep_milk, int sell_goat_milk, int sell_meat, int subsidies,
                      int female,int manure,int black,int other_income,
                      int  concentrated_fodder, int  trefoil, int  hay, int  electricity,
                      int  replacement_animals,int  petroleum, int  petrol,
                      int  medicines, int  sponges, int  repair, int  equipment, int  wages_fields,
                      int  wages_staff, int  expenses_pastures ,int  other_expenses, String id)

    {
        SQLiteDatabase data1 = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        int total_revenue = sell_sheep_milk + sell_goat_milk + sell_meat + subsidies + female + manure + black + other_income ;
        int total_expenses = concentrated_fodder + trefoil + hay + electricity + replacement_animals + petroleum + petrol +
                medicines + sponges + repair + equipment + wages_fields +wages_staff + expenses_pastures + other_expenses;
        int mixed_revenue = total_revenue - total_expenses;

        concentrated_fodder = (int) (sell_sheep_milk * 0.77);

        contentValues.put(ContactContact.ContactEntry.SELLING_SHEEP_MILK,sell_sheep_milk);
        contentValues.put(ContactContact.ContactEntry.SELLING_GOAT_MILK, sell_goat_milk);
        contentValues.put(ContactContact.ContactEntry.SELLING_MEAT, sell_meat);
        contentValues.put(ContactContact.ContactEntry.SUBSIDIES, subsidies);
        contentValues.put(ContactContact.ContactEntry.FEMALE, female);
        contentValues.put(ContactContact.ContactEntry.MANURE, manure);
        contentValues.put(ContactContact.ContactEntry.BLACK, black);
        contentValues.put(ContactContact.ContactEntry.OTHER_INCOME, other_income);




        contentValues.put(ContactContact.ContactEntry.CONCENTRATED_FODDER, concentrated_fodder);
        contentValues.put(ContactContact.ContactEntry.TREFOIL, trefoil);
        contentValues.put(ContactContact.ContactEntry.HAY, hay);
        contentValues.put(ContactContact.ContactEntry.CURRENT, electricity);
        contentValues.put(ContactContact.ContactEntry.REPLACEMENT_ANIMALS, replacement_animals);
        contentValues.put(ContactContact.ContactEntry.PETROLEUM, petroleum);
        contentValues.put(ContactContact.ContactEntry.PETROL, petrol);
        contentValues.put(ContactContact.ContactEntry.MEDICINES, medicines);
        contentValues.put(ContactContact.ContactEntry.SPONGES, sponges);
        contentValues.put(ContactContact.ContactEntry.REPAIR, repair);
        contentValues.put(ContactContact.ContactEntry.EQUIPMENT, equipment);
        contentValues.put(ContactContact.ContactEntry.WAGES_FIELDS, wages_fields);
        contentValues.put(ContactContact.ContactEntry.WAGES_STAFF, wages_staff);
        contentValues.put(ContactContact.ContactEntry.EXPENSES_PASTURES, expenses_pastures);
        contentValues.put(ContactContact.ContactEntry.UNFORESEEN, other_expenses);

        contentValues.put(ContactContact.ContactEntry.TOTAL_REVENUE, total_revenue);
        contentValues.put(ContactContact.ContactEntry.TOTAL_EXPENSES, total_expenses);
        contentValues.put(ContactContact.ContactEntry.MIXED_REVENUE, mixed_revenue);






        String row = String.valueOf(ContactContact.ContactEntry.ID);

        String selection = row + " LIKE ?";
        String [] selectionArgs = { id };


        data1.update(ContactContact.ContactEntry.TABLE_NAME,contentValues,selection, selectionArgs);
        data1.close();

        return;
    }




    public void   delete(String id)

    {

        SQLiteDatabase data1 = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        String row = String.valueOf(ContactContact.ContactEntry.ID);

        String selection = row + " LIKE ?";
        String [] selectionArgs = { id };


        data1.delete(ContactContact.ContactEntry.TABLE_NAME,selection, selectionArgs);
        data1.close();

        return;
    }






}






