package ars.example.unitconverter

object TypeSetter {

    private val  list = listOf(
        MesurmentTypes(R.drawable.areachart,"Area",false),
        MesurmentTypes(R.drawable.vsdij,"Mass",false),
        MesurmentTypes(R.drawable.measuringtape,"Length",false),
        MesurmentTypes(R.drawable.hot,"Temperature",false),
        MesurmentTypes(R.drawable.beaker,"Volume",false),
        MesurmentTypes(R.drawable.chronometer,"Time",false)
    )

    fun getList():List<MesurmentTypes>{return list}
}