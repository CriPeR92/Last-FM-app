package com.example.musicsearchapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.musicsearchapp.R
import com.example.musicsearchapp.databinding.FragmentTracksBindingImpl
import com.example.musicsearchapp.viewModel.TracksViewModel

class TracksFragment : Fragment() {

//    lateinit var adapter: GridCharactersAdapter
    lateinit var binding: FragmentTracksBindingImpl
    private lateinit var vm: TracksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this).get(TracksViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tracks, container, false)
        binding.lifecycleOwner = this
        binding.tracksViewModel = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        vm.characterResponse.observe(binding.lifecycleOwner!!, Observer {
//            vm.uiEventValue.value = 3
//        })
//
//        vm.uiEventValue.observe(binding.lifecycleOwner!!, Observer {
//            when (it) {
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
//                3 -> {
//                    vm.hide.value = 0
//                    SessionData.isLoading = false
//                    if (::adapter.isInitialized) {
//                        adapter.notifyDataSetChanged()
//                    } else {
//                        adapter = GridCharactersAdapter(this, vm.characterResponse.value?.results!!)
//                        binding.adapter = adapter
//                    }
//                }
//            }
//        })
//
//        adapter = GridCharactersAdapter(this, ArrayList<Personage>())
//        binding.adapter = adapter

    }
}