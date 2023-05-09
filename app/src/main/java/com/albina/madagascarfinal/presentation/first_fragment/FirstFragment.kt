package com.example.jetpacknav.presentation.first_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpacknav.data.local.model.Animal
import com.example.jetpacknav.R
import com.example.jetpacknav.presentation.second_fragment.SecondFragment
import com.example.jetpacknav.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), AnimalAdapter.Listener {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var animals = ArrayList<Animal>()
    lateinit var adapter: AnimalAdapter
    lateinit var firstFragmentViewModel: FirstFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = AnimalAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        firstFragmentViewModel = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)
        firstFragmentViewModel.getAnimals()
        firstFragmentViewModel.animals.observe(viewLifecycleOwner){
            adapter.setArrayListOfAnimals(it)
            animals = it
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter
        binding.progressBarIsLoading.visibility = View.INVISIBLE

        binding.button.setOnClickListener{
            firstFragmentViewModel.getFact()
        }

        firstFragmentViewModel.fact.observe(viewLifecycleOwner){
            binding.fact.text = it
        }

        firstFragmentViewModel.isLoading.observe(viewLifecycleOwner){
            if(it == true) {
                binding.fact.visibility = View.INVISIBLE
                binding.progressBarIsLoading.visibility = View.VISIBLE
            }else if(it == false) {
                binding.progressBarIsLoading.visibility = View.INVISIBLE
                binding.fact.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(
            SecondFragment.numberInArray to itemView,
            SecondFragment.name to animals.get(itemView).name,
            SecondFragment.desc to animals.get(itemView).shortDescription,
            SecondFragment.url to animals.get(itemView).urlPhoto,
            SecondFragment.fullDesc to animals.get(itemView).fullDesc)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }


}

