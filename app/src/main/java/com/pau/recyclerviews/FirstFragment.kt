package com.pau.recyclerviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager

class FirstFragment : Fragment() {

    private val myAdapter by lazy { MyAdapter(this) }

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding?.inflate(layoutInflater)
        val view: View = mBinding.getRoot()
        setContentView(view)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //inflate the layout for this fragment
       mBinding = FragmentFirstBinding.inflate(inflater, container, false)

        mBinding.recyclerView.LayoutManager = LinearLayoutManager(requireContext())
        mBinding.recyclerView.adapter = myAdapter


        val person1 = Person(id: 1, name: "paula", age: 24)
        val person2 = Person(id: 2, name: "Josue", age: 33)
        val person3 = Person(id: 3, name: "Daniel", age: 25)

        myAdapter.setData(listOf(person1, person2, person3))

        mBinding.addButton.setOnClickListener {
            val person4 = Person(id: 4, name: "Jazmin", age: 26)
            myAdapter.setData(listOf(person1, person2, person3))
        }

        return mBinding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}
