package ars.example.unitconverter

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ars.example.unitconverter.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding?= null
    private var fromUnit:String?=null
    private var toUnit:String?=null
    private var operation :Int?= null

    private var UnitList  :ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        getIntentData()

        setSupportActionBar(binding?.toolbar)
        supportActionBar?.title = "Conversion"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Handle Back Arrow Click
        binding?.toolbar?.setNavigationOnClickListener {
            Toast.makeText(this, "Back clicked", Toast.LENGTH_SHORT).show()
            finish()  // Closes the current activity
        }


        binding?.fromNumber?.setOnClickListener {
            resetResult()
        }



        binding?.fromUnit?.onItemSelectedListener =object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                fromUnit = UnitList[position]
                if(binding?.fromNumber?.text?.toString()?.isNotEmpty()!!)
                {
                    conversion()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Eat % Star .....
            }
        }


        binding?.toUnit?.onItemSelectedListener =object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                toUnit = UnitList[position]
                if(binding?.fromNumber?.text?.toString()?.isNotEmpty()!!)
                {
                    conversion()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Eat % Star .....
            }
        }



        binding?.pressBtn?.setOnClickListener {
            if(binding?.fromNumber?.text?.toString()?.isNotEmpty()!! ){
                binding?.pressBtn?.visibility = View.GONE
                conversion()
            }
            else{
                Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show()
            }

        }

        binding?.fromNumber?.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                 val input= binding?.fromNumber?.text.toString()

                if (input.isNotEmpty()) {
                   conversion() // Call your conversion function

                } else {
                    Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show()
                }

                // **Hide Keyboard**
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding?.fromNumber?.windowToken, 0)

                true  // Return true to indicate the event is handled
            } else {
                false  // Return false to let other events proceed
            }
        }


    }



    private fun getIntentData()
    {
        if(intent.hasExtra("UnitList")){
            UnitList = intent.getStringArrayListExtra("UnitList")!!
            setUnits()
        }
        if(intent.hasExtra("operation")){
            operation = intent.getIntExtra("operation",0)
        }
    }


    private fun conversion(){
        val fUnit = fromUnit
        val tUnit = toUnit
        val value = binding?.fromNumber?.text.toString()

        Log.d("TAG",fUnit.toString())
        Log.d("TAG",tUnit.toString())
        Log.d("TAG",value.toString())

        if( fUnit.isNullOrEmpty() || tUnit.isNullOrEmpty() || value.isNullOrEmpty())
        {
            Toast.makeText(this,"You missed an Entry",Toast.LENGTH_SHORT).show()
        }else{
            var result = 0.0
            when(operation){
                0->{ result =  AreaMapping.convert(fUnit,tUnit,value.toDouble()) }
                1->{ result =  WeightMApping.convert(fUnit,tUnit,value.toDouble()) }
                2->{ result =  LengthMapping.convert(fUnit,tUnit,value.toDouble()) }
                3->{ result =  TemperatureMpping.convert(fUnit,tUnit,value.toDouble())}
                4->{ result =  volumeMapping.convert(fUnit,tUnit,value.toDouble())}
                5->{ result =  timeMapping.convert(fUnit,tUnit,value.toDouble())}
                else ->{result = result}
            }

            binding?.toNumder?.setText( result.toString())


        }

    }
    private fun setUnits(){

        val adaptor = ArrayAdapter(this,R.layout.spinner_layout_from,UnitList)
        adaptor.setDropDownViewResource(R.layout.custom_spinner_dropdown_item)
        val adaptor2 = ArrayAdapter(this,R.layout.spinner_layout_to,UnitList)
        adaptor2.setDropDownViewResource(R.layout.custom_spinner_dropdown_item)
        binding?.fromUnit?.adapter =adaptor
        binding?.toUnit?.adapter=adaptor2

           }

    private fun resetResult(){
        if(UnitList.isEmpty())
        {Toast.makeText(this,"Select a criterion (Area ,Length etc.)",Toast.LENGTH_SHORT).show()}
        binding?.fromNumber?.text?.clear()
        binding?.pressBtn?.visibility = View.VISIBLE


    }

}