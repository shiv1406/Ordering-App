package com.example.orderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.orderingapp.databinding.FragmentPickupBinding

class PickupFragment : Fragment() {


    private var binding: FragmentPickupBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPickupBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }
    private val sharedViewModel : OrderViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
          pickupFragment = this@PickupFragment
            nextButton.setOnClickListener { goToNextScreen() }
        }
    }

    fun goToNextScreen() {
      findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}