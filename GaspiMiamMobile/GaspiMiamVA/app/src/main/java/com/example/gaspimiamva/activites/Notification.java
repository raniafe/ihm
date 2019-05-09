
/*
package com.example.gaspimiamva.activites;


import android.support.v7.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gaspimiamva.R;

public class Notification extends AppCompatActivity {

    // notification attribuée à un canal
    // possible de mofier le canal pour définir le comportement visuel et auditif de toutes les notifications sur ce canal

    public static final String CHANNEL_ID = "channel";
    public static final int NOTIFICATION_ID = 888888;

/*
    IAgenda iAgenda;

    String res = iAgenda.getContent();
*/
    // Activity start : création du chanel pour la notification
/*

    @Override
    protected void onStart() {
        super.onStart();

        // creation du chanel de notification
        // pb de version : >26

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel notification";
            String description = "Channel destiné à notifier les évenements du telephonné";
            // modifier le niveau d'importance : si niveau élevé, la notification apparaitra avant les autres
            int degre_importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, degre_importance);
            channel.setDescription(description);
            // Manager : celui qu'on appellera pour faire la notification
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    public void showNotification(String title, String content) {

        // construction de la notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.alerte)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        // appel du manager pour créer la notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_moncompte);

        // button
        Button buttonNotification = findViewById(R.id.notification);

        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification("alerte", "Courgettes en danger, pensez à les consommer");
            }
        });
    }

}




*/