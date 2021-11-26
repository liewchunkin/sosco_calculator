package my.edu.tarc.set8liewchunkin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.set8liewchunkin.databinding.ActivityMainBinding
import android.content.Intent
import android.net.Uri
import android.view.View


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            //TODO: Get inputs from user and calculate the monthly contributions
            if (binding.editTextSalary.text.isEmpty()) {
                binding.editTextSalary.error = "Value required" //getString(R.string.error_input)
                return@setOnClickListener
            }

            val salary: Int = Integer.parseInt(binding.editTextSalary.text.toString())


            val age: String = binding.spinnerAge.selectedItem as String

            if (age == "Below 60") {
                val monthlyPayYee: Double = salary * 0.5 / 100
                binding.textViewContriAns.text = String.format("%.2f", monthlyPayYee)
                val monthlyPayYer: Double = salary * 1.75 / 100
                binding.textViewContriAnsyer.text = String.format("%.2f", monthlyPayYer)
            } else {
                val monthlyPayYee1: Double = salary * 0.0
                binding.textViewContriAns.text = String.format("%.2f", monthlyPayYee1)
                val monthlyPayYer1: Double = salary * 1.25 / 100
                binding.textViewContriAnsyer.text = String.format("%.2f", monthlyPayYer1)
            }

            binding.buttonReset.setOnClickListener {
                //TODO: Reset all views and output
                binding.editTextSalary.text.clear()
                binding.spinnerAge.setSelection(0)
                binding.textViewContriAnsyer.text = null
                binding.textViewContriAns.text = null
            }
        }

        binding.button.setOnClickListener() {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.perkeso.gov.my/")))
        }

        binding.buttonCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:0169893528"))
            startActivity(callIntent)
        }


    }
}