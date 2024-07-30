package ars.example.unitconverter

object timeMapping {
    private val TimeUnitList = arrayListOf("Hour","Minute","Day","Second","Year","Month","Week","Century","Millisecond")



    private  fun convertToMinute(type :String):Double{

        if( type =="Hour"){return 60.0}
        if(type  =="Minute"){return 1.0}
        if(type =="Day"){return 1440.0 }
        if(type=="Second"){return 0.0166667}
        if( type =="Year"){return 525600.0}
        if( type== "Month"){return 43800.0}
        if(type =="Week"){return 10080.0 }
        if(type=="Century"){ return 52560000.0}
        if(type=="Millisecond"){return 0.000016667}


        return 0.0
    }
    fun convert( from :String ,to :String ,value :Double ):Double {
        val from_To_Metre = convertToMinute(from)
        val to_To_Metre = convertToMinute(to)

        return (from_To_Metre * value )/to_To_Metre
    }

    fun getList():ArrayList<String>{
        return TimeUnitList
    }
}