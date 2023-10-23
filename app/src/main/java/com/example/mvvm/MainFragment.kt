package com.example.mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.databinding.LayoutMainFragmentBinding
import com.example.mvvm.room.Note
import com.example.mvvm.viewModel.NoteViewModel

class MainFragment : Fragment(){
    private lateinit var binding : LayoutMainFragmentBinding
    private lateinit var noteViewModel : NoteViewModel
    private lateinit var adapter: Adapter
    private var listNote : ArrayList<Note>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutMainFragmentBinding.inflate(inflater, container, false)
        binding.add.setOnClickListener {
            onChangeToAdd()
        }
        listNote = ArrayList()
        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        setUpRecyclerView()
        getData()
        return binding.root
    }

    private fun onChangeToAdd() {
        val detailFragment = DetailFragment()
        val fragmentTrans = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.mainActivity, detailFragment)
        fragmentTrans.addToBackStack(detailFragment.tag)
        fragmentTrans.commit()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getData(){
        noteViewModel.getLiveDataNote(requireContext()).observe(viewLifecycleOwner){
            if(listNote!!.isNotEmpty()){
                listNote!!.clear()
                for(note in it){
                    listNote!!.add(note)
                }
                adapter.notifyDataSetChanged()
            }
            else{
                for(note in it){
                    listNote!!.add(note)
                }
                adapter.notifyDataSetChanged()
            }
        }
    }


    private fun setUpRecyclerView(){
        val layoutManager = LinearLayoutManager(requireContext())
        adapter = Adapter(listNote!!)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        Log.d("Pause", "True")
    }
}
