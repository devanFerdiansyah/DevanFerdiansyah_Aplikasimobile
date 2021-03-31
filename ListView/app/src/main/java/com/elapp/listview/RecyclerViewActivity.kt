package com.elapp.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.elapp.listview.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var mahasiswaAdapter: MahasiswaAdapter
    private lateinit var mahasiswaArrayList: ArrayList<Mahasiswa>

    private var _recyclerViewActivity: ActivityRecyclerViewBinding? = null
    private val binding get() = _recyclerViewActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _recyclerViewActivity = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)

        addData()

        mahasiswaAdapter = MahasiswaAdapter()
        mahasiswaAdapter.setList(mahasiswaArrayList)

        binding?.rvMahasiswa?.layoutManager = LinearLayoutManager(this)
        binding?.rvMahasiswa?.adapter = mahasiswaAdapter

    }

    fun addData() {
        mahasiswaArrayList = ArrayList<Mahasiswa>()
        mahasiswaArrayList.add(Mahasiswa("Devan", "E41191971", "123456789"))
        mahasiswaArrayList.add(Mahasiswa("Anton", "E41191930", "123456789"))
        mahasiswaArrayList.add(Mahasiswa("Prass", "E41192428", "123456789"))
        mahasiswaArrayList.add(Mahasiswa("Rifky", "E41192307", "123456789"))
        mahasiswaArrayList.add(Mahasiswa("Rajih", "E41192241", "123456789"))
        mahasiswaArrayList.add(Mahasiswa("Dimas", "E41192208", "123456789"))
        mahasiswaArrayList.add(Mahasiswa("Febri", "E41192131", "123456789"))
    }

}