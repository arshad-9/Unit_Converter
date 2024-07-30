package ars.example.unitconverter

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ars.example.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding?= null
    private var operation :Int?= null
    private var functionRecycler  : ((Int) -> Unit)?=null
    private var UnitList  :ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        functionRecycler ={
            param:Int->
            operation = param
            when(param){
                0->{ UnitList  = AreaMapping.getList()
                 setUnits()
                }
                1->{ UnitList  = WeightMApping.getList()
                setUnits()
                }
                2->{ UnitList  = LengthMapping.getList()
                setUnits()
                  }
                3->{ UnitList  = TemperatureMpping.getList()
                    setUnits()
                }
                4->{ UnitList  = volumeMapping.getList()
                setUnits()
            }
                5->{ UnitList  = timeMapping.getList()
                    setUnits()
                }
                else->{UnitList = UnitList}

            }
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

       binding?.recycler?.adapter = recyclerAdaptor(TypeSetter.getList(),functionRecycler)
       binding?.recycler?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        binding?.toUnit?.setOnClickListener {
           resetResult()
        }
        binding?.fromUnit?.setOnClickListener {
           resetResult()
        }
        binding?.cal?.setOnClickListener {
            if(UnitList.isEmpty())
            { Toast.makeText(this,"Select a criterion (Area ,Length etc.)",Toast.LENGTH_SHORT).show() }
            else{conversion()
                 binding?.toNumder?.setBackgroundResource(R.drawable.borders)}
        }
    }

    private fun conversion(){
        val fUnit = binding?.fromUnit?.text.toString()
        val tUnit = binding?.toUnit?.text.toString()
        val value = binding?.fromNumber?.text.toString()

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

        binding?.fromUnit?.text =null
        binding?.toUnit?.text=null
        binding?.toNumder?.text = null
        val adaptor = ArrayAdapter<String>(this,R.layout.drop_down_layout,UnitList)
        binding?.fromUnit?.setAdapter(adaptor)
        val adaptor2 = ArrayAdapter<String>(this,R.layout.drop_down_layout,UnitList)
        binding?.toUnit?.setAdapter(adaptor2)
    }

    private fun resetResult(){
        if(UnitList.isEmpty())
        {Toast.makeText(this,"Select a criterion (Area ,Length etc.)",Toast.LENGTH_SHORT).show()}
        binding?.toNumder?.text=null
        binding?.toNumder?.setBackgroundResource(R.drawable.border_no_result)

    }

}