package com.test.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public PackageManager getPackageManager() {
        //由于调用的是this.getPackageManager()，所以只要重写getPackageManager，返回一个伪造的实例，就可以实现欺骗
        PackageManager pm = new HookPackageManager(super.getPackageManager());
        return pm;
    }

}