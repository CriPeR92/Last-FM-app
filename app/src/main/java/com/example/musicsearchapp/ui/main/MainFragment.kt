package com.example.musicsearchapp.ui.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.musicsearchapp.R
import com.example.musicsearchapp.databinding.FragmentMainBindingImpl
import com.example.musicsearchapp.model.Track


class MainFragment : Fragment() {

    lateinit var adapter: MainAdapter
    lateinit var binding: FragmentMainBindingImpl
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this
        binding.mainViewModel = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        vm.tracksResponse.observe(binding.lifecycleOwner!!, Observer {
            vm.hide.value = 0
            val imm =
                requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0) // hide

//                    SessionData.isLoading = false
//            if (::adapter.isInitialized) {
//                adapter.notifyDataSetChanged()
//            } else {
            adapter = MainAdapter(
                this,
                vm.tracksResponse.value?.results?.trackmatches?.track!!
            )
            binding.adapter = adapter
//            }
        })
//
        vm.uiEventValue.observe(binding.lifecycleOwner!!, Observer {
            when (it) {
//                1 -> {
//                    val bundle = Bundle()
//                    bundle.putString("personage", Gson().toJson(vm.character.value))
//                    val fragment = CharacterFragment()
//                    fragment.arguments = bundle
//                    this.activity?.supportFragmentManager?.beginTransaction()
//                        ?.add(R.id.container, fragment)
//                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        ?.addToBackStack(null)
//                        ?.commit()
//                }

            }
        })
//
        adapter = MainAdapter(this, ArrayList<Track>())
        binding.adapter = adapter

    }
}