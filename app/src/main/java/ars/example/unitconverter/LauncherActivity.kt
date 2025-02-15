package ars.example.unitconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import ars.example.unitconverter.databinding.ActivityLauncherBinding
import ars.example.unitconverter.databinding.ActivityMainBinding

class LauncherActivity : AppCompatActivity() {
    private var   binding:ActivityLauncherBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler().postDelayed({
            startActivity(Intent(this,CategoryActivity::class.java))
            finish()
        },2000)
    }
}