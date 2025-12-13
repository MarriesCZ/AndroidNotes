package com.marries.pandacat

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.marries.commonlib.TestPlugin
import com.marries.commonlib.mode.autoregister.getModuleList
import com.marries.pandacat.databinding.ActivityMainBinding
import com.marries.pandacat.databinding.MoudleItemBinding


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(mBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initModuleList()

        TestPlugin(this).addButton("1") {
            Toast.makeText(this, "11111", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initModuleList() {
        mBinding.moduleList.apply {
            setAdapter(object : Adapter<ViewHolder>() {
                val moduleList by lazy { getModuleList() }

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                    val moduleItem = MoudleItemBinding.inflate(layoutInflater)
                    return object : ViewHolder(moduleItem.root) {}
                }

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                    holder.itemView.apply {
                        this.findViewById<TextView>(R.id.moduleText).text = moduleList[position].getName()
                        setOnClickListener {
                            startActivity(Intent(this@MainActivity, moduleList[position].getJavaClass()))
                        }
                    }
                }

                override fun getItemCount(): Int = moduleList.size
            })
            setLayoutManager(GridLayoutManager(this@MainActivity, 2))
        }
    }
}