package cc.captaincode.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import cc.captaincode.recyclerviewdemo.adapter.BuildingAdapter
import cc.captaincode.recyclerviewdemo.data.Building
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewBuildingDialog.NewBuildingHandler {

    private lateinit var buildingAdapter:BuildingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->
            NewBuildingDialog().show(supportFragmentManager,
                "BUILDING_DIALOG")
        }

        buildingAdapter = BuildingAdapter(this)

        buildingRecycler.layoutManager = LinearLayoutManager(this)

        buildingRecycler.adapter = buildingAdapter
    }

    override fun newBuilding(building: Building) {
        buildingAdapter.addBuilding(building)
    }

    override fun removeBuilding(building: Building) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
