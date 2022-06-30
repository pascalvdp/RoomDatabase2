package com.example.roomdatabase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button but, butDeleteAll;
    EditText editT1, editT2;
    //Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "databaseName").allowMainThreadQueries().build();
                                        //C:/databaseName  nog uittesten
        /* AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "databaseName")
                .addMigrations(new Migration(1,2) {  //EXISTING_VERSION, EXISTING_VERSION + 1
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {

                    }
                }).build(); */

        System.out.println("start app");
        UserDao userDao = db.userDao();

        but=findViewById(R.id.button);
        butDeleteAll = findViewById(R.id.button2);
        editT1 = findViewById(R.id.editTextTextPersonName);
        editT2 = findViewById(R.id.editTextTextPersonName2);

        but.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       System.out.println("BUTTON AANGEKLIKT");
                                       if(!editT1.getText().toString().equals("") && !editT2.getText().toString().equals("")){
                                           User user = new User();
                                           //user.uid=53;
                                           user.firstName=editT1.getText().toString();
                                           user.lastName=editT2.getText().toString();
                                           List<User> users = userDao.getAll();
                                           user.testNummer=users.size() + 1;
                                           userDao.insertAll(user);
                                           UserTest usTest = new UserTest();
                                           usTest.testNummer = user.testNummer;
                                           userDao.insertAllUsersTest(usTest);
                                           System.out.println(user.firstName + " toegevoegd");
                                           System.out.println(user.lastName + " toegevoegd");
                                           //System.out.println("testNummer toegevoegd == "+user.testNummer);
                                           editT1.setText("");
                                           editT2.setText("");
                                           Toast.makeText(MainActivity.this, "Naam is opgeslagen", Toast.LENGTH_SHORT).show();
                                       }
                                       else{
                                           Toast.makeText(MainActivity.this, "Naam is niet ingevuld!!!", Toast.LENGTH_SHORT).show();
                                           System.out.println("niets toegevoegd, naam niet ingegeven");
                                       }

                                       //int in=3;
                                       //userDao.loadAllByIds(in);
                                       User user2=userDao.findByName("pascal2","test2");
                                       /*
                                       if(user2 != null) {
                                           userDao.delete(user2);
                                           System.out.println("user deleted");
                                       }*/
                                       User user3 = userDao.searchToLastName("%est%");
                                       if(user3 != null) {
                                           System.out.println("user found!!!!!!");
                                       }
                                       List<User> users = userDao.getAll();
                                       System.out.println("aantal ids=" + users.size());
                                       if(users.size()==0){ //users.isEmpty()
                                           System.out.println("database is leeg");
                                       }
                                       else {
                                           System.out.println("aantal ids=" + users.size());
                                       }
                                       //uid van 1 tot...  enkel get start van 0
                                       //context.deleteDatabase("databaseTest");
                                       //userDao.insertAll(users.toArray(new User[0]));
                                       users = userDao.getAll();
                                       System.out.println("aantal ids=" + users.size());
                                   }
                               });

        butDeleteAll.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                //userDao.delete(userDao.searchToFirstName("dd"));
                getApplicationContext().deleteDatabase("databaseName");

                //db.clearAllTables();
                //List<User> users = userDao.getAll();
                //User us1 = users.get(0);
                //User us2 = users.get(1);
                //userDao.deleteAll(users.get(0)); //dit werkt
                //userDao.deleteAllTest(us1,us2);//dit wel
                //User[] us = users.toArray(new User[0]);//ok
                //System.out.println("lengte us = " + us.length);
                //userDao.deleteAllTest(us);//dit wel
                //userDao.insertAllUsers(users);//dit niet
                //userDao.deleteAllUsers(users);//dit wel
                //userDao.insertAllUsers(users);

                //for(int i=0;i<users.size();i++){
                    //userDao.deleteAll(users.get(i));//dit werkt ook

                //}

                //userDao.deleteAll(users.get(0));
                //System.out.println("All users deleted");
            }
        });
    }
}