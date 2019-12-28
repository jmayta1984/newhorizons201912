package pe.edu.newhorizons.menus

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_notification.*
import java.util.*

class NotificationActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        btNotification.setOnClickListener {

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Creación y configuración del canal de notificación
            val id = "myChannel"

            val name = getString(R.string.app_name)

            val description = "Canal de notificaciones"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(id,name,importance)

            channel.description = description
            channel.enableLights(true)
            channel.lightColor = Color.GREEN
            channel.enableVibration(true)

            notificationManager.createNotificationChannel(channel)


            // Creación y configuración de la notificación

            val notification = NotificationCompat.Builder(this,id)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notificación")
                .setContentText("Revisa tu material de clases")


            // Activity a donde debe dirigir la notificación
            val intent = Intent(this, MainActivity::class.java)

            val stack = TaskStackBuilder.create(this)

            stack.addNextIntent(intent)

            var resultPendingIntent = stack.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)

            notification.setContentIntent(resultPendingIntent)



            notificationManager.notify(Random().nextInt(100) ,notification.build())
        }
    }
}
