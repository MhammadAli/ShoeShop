package com.example.shoeshop.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.shoeshop.view_model.MainActivityViewModel
import com.example.shoeshop.R
import com.example.shoeshop.databinding.FragmentNewShoeDetailBinding


class NewShoeDetailFragment : Fragment() {
    lateinit var binding: FragmentNewShoeDetailBinding
    private val viewModel: MainActivityViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding =
            FragmentNewShoeDetailBinding.inflate(inflater,  container, false)
        binding.cancelButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_newShoeDetailFragment_to_shoeListFragment))

        binding.saveButton.setOnClickListener {
            val name = binding.shoeNameEditText.text.toString()
            val size = binding.shoeSizeEditText.text.toString()
            val company = binding.shoeCompanyEditText.text.toString()
            val description = binding.shoeDescriptionEditText.text.toString()
            viewModel.addShoes(
                name,
                size,
                company,
                description
            )

            Log.i("ShoeDetails", viewModel.shoes.value.toString())
            val action =
                com.example.shoeshop.screens.NewShoeDetailFragmentDirections.actionNewShoeDetailFragmentToShoeListFragment()
            findNavController(this).navigate(action)
        }

        return binding.root
    }


}