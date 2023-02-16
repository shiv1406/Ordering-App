package com.example.orderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.orderingapp.databinding.FragmentStartBinding



class StartFragment : Fragment() {


    private var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this

        binding?.apply {
            orderOneBurger.setOnClickListener { orderBurger(1) }
            orderSixBurger.setOnClickListener { orderBurger(6) }
            orderTwelveBurger.setOnClickListener { orderBurger(12) }
        }
    }
    private val sharedViewModel: OrderViewModel by activityViewModels()
    fun orderBurger(quantity: Int) {
        sharedViewModel.setQuantity(quantity)
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }
        Toast.makeText(activity, "Selected $quantity burger(s)", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

