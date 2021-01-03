package com.marries.androidbase;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.marries.androidbase.databinding.ActivityMainBinding;
import com.marries.module_common.TestPlugin;
import com.marries.module_leetcode.LCMainActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  private ActivityMainBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(mBinding.getRoot());
    mBinding.leetCode.setOnClickListener(this);

    TestPlugin.getInstance(this).getButton("1", 0).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case 0:
        Toast.makeText(this, "11111", Toast.LENGTH_SHORT).show();
        break;
      default:
        startActivity(new Intent(MainActivity.this, LCMainActivity.class));
        break;
    }
  }
}