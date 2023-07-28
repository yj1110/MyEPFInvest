package my.edu.tarc.myepfinvest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import my.edu.tarc.myepfinvest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.calculateButton.setOnClickListener {
            val age = binding.spinner.selectedItemPosition
            val saving = binding.basicSavingInput.text.toString().toFloat()
            val investmentAmount = when(age){
                0 -> (saving - 5000) * 0.3
                1 -> (saving - 14000) * 0.3
                2 -> (saving - 29000) * 0.3
                3 -> (saving - 50000) * 0.3
                4 -> (saving - 78000) * 0.3
                5 -> (saving - 116000) * 0.3
                6 -> (saving - 165000) * 0.3
                7 -> (saving - 228000) * 0.3
                else -> 0
            }

            val investment = Investment(investmentAmount.toString())
            binding.myInvestment = investment
        }

        binding.resetButton.setOnClickListener {
            val investment = Investment("")
            binding.myInvestment = investment
        }


    }


}