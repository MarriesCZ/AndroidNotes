package com.marries.androidbase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

  private static final String TAG = "AB_MainActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate: ");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TestPlugin.getInstance(this).getButton("1", 0).setOnClickListener(this);
  }

  @Override
  protected void onStart() {
    Log.d(TAG, "onStart: ");
    super.onStart();
  }

  @Override
  protected void onResume() {
    Log.d(TAG, "onResume: ");
    super.onResume();
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case 0:
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        Toast.makeText(this, "11111", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  protected void onPause() {
    Log.d(TAG, "onPause: ");
    super.onPause();
  }

  @Override
  protected void onStop() {
    Log.d(TAG, "onStop: ");
    super.onStop();
  }
}