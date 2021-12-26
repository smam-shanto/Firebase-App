package com.earnsmart.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class supportActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageView imageView, imageView1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        imageView=findViewById(R.id.whatapp);
        imageView1=findViewById(R.id.mail);
        final String num = "+8801521329977";
        final String text = "Hello, Is Anyone Available?";
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean installed = isAppInstalled("com.whatsapp");

                if (installed)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+num+"&text="+ text));
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(supportActivity.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }

            }

            private boolean isAppInstalled(String s) {
                PackageManager packageManager = getPackageManager();
                boolean is_installed;

                try {
                    packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
                    is_installed = true;
                } catch (PackageManager.NameNotFoundException e) {
                    is_installed = false;
                    e.printStackTrace();
                }
                return is_installed;
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO_EMAILS ={"smartearn101@gmail.com"};
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL,TO_EMAILS);
                intent.putExtra(Intent.EXTRA_SUBJECT,"subject");
                intent.putExtra(Intent.EXTRA_TEXT,"hello smart earn,");
                startActivity(Intent.createChooser(intent,""));
            }
        });
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu5);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        //
        if (id == R.id.item1) {
            Intent intent = new Intent(supportActivity.this, proActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item2) {
            Intent intent = new Intent(supportActivity.this, addviewActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item3) {
            Intent intent = new Intent(supportActivity.this, withdrawActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item4) {
            Intent intent = new Intent(supportActivity.this, teamActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item5) {
            Intent intent = new Intent(supportActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item6) {
            Intent intent = new Intent(supportActivity.this, historyActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item7) {
            Intent intent = new Intent(supportActivity.this, fundActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.item8) {
            Intent intent = new Intent(supportActivity.this, adduserActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }
}
