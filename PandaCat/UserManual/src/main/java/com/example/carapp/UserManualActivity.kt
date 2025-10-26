package com.example.carapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.carapp.databinding.UserManualLayoutBinding
import com.example.carapp.viewmodel.NetworkViewModel
import com.google.auto.service.AutoService
import com.marries.commonlib.base.BaseActivity
import com.marries.commonlib.mode.autoregister.IAutoRegisterInApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
@AutoService(IAutoRegisterInApp::class)
class UserManualActivity : BaseActivity() {

    override fun getName(): String = "UserManual"

    private lateinit var mBinding: UserManualLayoutBinding

    val networkViewModel: NetworkViewModel by lazy {
        ViewModelProvider(this)[NetworkViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        mBinding = UserManualLayoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(mBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            networkViewModel.jsonReleaseNotes.collect {
                mBinding.content.text = it
            }
        }
    }
}