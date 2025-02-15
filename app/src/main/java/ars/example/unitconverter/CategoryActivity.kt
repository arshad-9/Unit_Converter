package ars.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ars.example.unitconverter.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private var binding: ActivityCategoryBinding? = null
    private var functionRecycler  : ((Int) -> Unit)?=null
    private var operation :Int?= null
    private var UnitList  :ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbar)

        // Enable Back Arrow
        supportActionBar?.title = "Home"



        functionRecycler ={
                param:Int->
            operation = param
            when(param){
                0->{ UnitList  = AreaMapping.getList()
                    StartActivity()
                }
                1->{ UnitList  = WeightMApping.getList()
                    StartActivity()
                }
                2->{ UnitList  = LengthMapping.getList()
                    StartActivity()
                }
                3->{ UnitList  = TemperatureMpping.getList()
                    StartActivity()
                }
                4->{ UnitList  = volumeMapping.getList()
                    StartActivity()
                }
                5->{ UnitList  = timeMapping.getList()
                    StartActivity()
                }
                else->{UnitList = UnitList}

            }
        }

        binding?.recycler?.adapter = recyclerAdaptor(TypeSetter.getList(),functionRecycler)
        binding?.recycler?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }


    private fun StartActivity(){
        val intent = android.content.Intent(this,MainActivity::class.java)
        if(UnitList!=null){
            intent.putStringArrayListExtra("UnitList",UnitList)
            intent.putExtra("operation",operation)
        }
        startActivity(intent)

    }
}