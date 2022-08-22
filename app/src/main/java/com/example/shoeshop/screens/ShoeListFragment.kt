package com.example.shoeshop.screens

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoeshop.view_model.MainActivityViewModel
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentShoeListBinding
import com.example.shoeshop.databinding.ShoeItemBinding
import com.example.shoeshop.models.Shoe


class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding

    lateinit var viewModel: MainActivityViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]
        binding.shoe = viewModel
        binding.lifecycleOwner = this
        binding.addButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_newShoeDetailFragment))
        setHasOptionsMenu(true)
        viewModel.shoes.observe(viewLifecycleOwner, Observer { newShoe ->

            addItems(newShoe)

            Log.i("Shoe List size", viewModel.shoes.value?.size.toString())


        })

        Log.i("Shoe List", viewModel.shoes.value.toString())
        return binding.root
    }

    private fun addItems(newShoe: MutableList<Shoe>?) {
        newShoe?.forEach {
            val binView = ShoeItemBinding.inflate(
                LayoutInflater.from(requireContext()),
                binding.linearLayout,
                false
            )
            with(binView)
            {
                nameText.text = it.name
                sizeText.text = it.size
                companyText.text = it.company
                descriptionText.text = it.description
            }
            binding.linearLayout.addView(binView.root)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)

        return super.onOptionsItemSelected(item)
    }


}