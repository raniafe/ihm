package com.example.gaspimiamva.activites;

import android.app.FragmentManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import com.example.gaspimiamva.activites.Notification;

import com.example.gaspimiamva.R;
import com.example.gaspimiamva.fragments.AccueilFragment;
import com.example.gaspimiamva.fragments.BoutiqueFragment;
import com.example.gaspimiamva.fragments.MapFragment;
import com.example.gaspimiamva.fragments.MesVentesFragment;
import com.example.gaspimiamva.fragments.MonCompteFragment;
import com.example.gaspimiamva.fragments.StockFragment;
import com.example.gaspimiamva.models.ModelListOfProduit;
import com.example.gaspimiamva.models.UsersListModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static com.example.gaspimiamva.R.id.toolbar;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static ModelListOfProduit modelListOfProduit;
    public static UsersListModel userModel ;
    public static final String CHANNEL_ID = "channel";
    public static final int NOTIFICATION_ID = 888888;
    public Bundle bundle;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public MainActivity() {
        try {
            modelListOfProduit = new ModelListOfProduit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userModel = new UsersListModel() ;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame
                        , AccueilFragment.newInstance(modelListOfProduit))
                .commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.notification) {

            //Notification notif = new Notification();
            //notif.onCreate(bundle);
            showNotification("alerte", "Courgettes en danger, pensez à les consommer");

            /*
            Intent intent = new Intent (getApplicationContext(), Notification.class);
            startActivity(intent);
            */
        }
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_accueil) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , AccueilFragment.newInstance(this.modelListOfProduit))
                    .commit();
            System.out.print(modelListOfProduit);
        } else if (id == R.id.nav_boutique) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , BoutiqueFragment.newInstance(this.modelListOfProduit))
                    .commit();

        }  else if (id == R.id.nav_mesventes) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , MesVentesFragment.newInstance(this.modelListOfProduit))
                    .commit();


        }else if (id == R.id.nav_stock) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            ,  StockFragment.newInstance(this.modelListOfProduit))
                    .commit();


        } else if (id == R.id.nav_moncompte) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , MonCompteFragment.newInstance(userModel.getListOfProfiles().get(0)))
                    .commit();


        } else if (id == R.id.nav_map) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new MapFragment())
                    .commit();


        } else if (id == R.id.nav_deconnexion) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openActivity()
    {
        Intent intent = new Intent(this, MainActivity.class) ;
        startActivity(intent) ;
    }

    public void addEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void showNotification(String title, String content) {
        System.out.println("ici notif");
        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.alerte)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, notifBuilder.build());
    }

    @Override
    protected void onStart(){
        super.onStart();

        // creation du chanel de notification
        // pb de version : >26

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Channel notification";
            String description = "Channel destiné à notifier les évenements du telephonne";
            // modifier le niveau d'importance : si niveau élevé, la notification apparaitra avant les autres
            int degre_importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, degre_importance);
            channel.setDescription(description);
            // Manager : celui qu'on appellera pour faire la notification
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}


