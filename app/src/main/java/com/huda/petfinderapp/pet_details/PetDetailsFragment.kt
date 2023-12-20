package com.huda.petfinderapp.pet_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.huda.petfinderapp.utils.Helper
import com.huda.petfinderapp.databinding.FragmentPetDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PetDetailsFragment : Fragment() {
    private var _binding:FragmentPetDetailsBinding?=null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PetsDetailsViewModel>()
    private var url:String?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =FragmentPetDetailsBinding.inflate(inflater, container, false)
        initViews()
        observeViews()
        events()
        return binding.root
    }

    private fun events() {
        binding.petWebsiteBtn.setOnClickListener {
            url?.let { it1 ->  val action = PetDetailsFragmentDirections.viewPetsWebsite(it1)
            findNavController().navigate(action) }
        }
    }
    private fun observeViews() {
        viewModel.getPetResponse.observe(viewLifecycleOwner){
            it?.primaryPhotoCropped?.medium?.let { it1 ->
                Helper.loadImage(requireContext(),
                    it1,binding.petImg)
            }
            binding.petName.text = it?.name?:"NA"
            binding.petSize.text = it?.size?:"NA"
            binding.petColor.text = it?.colors?.primary?:"NA"
            "${
                it?.contact?.address?.city
            }, ${
                it?.contact?.address?.state
            }, ${
                it?.contact?.address?.country
            }".also { address ->
                binding.petAddress.text = address
            }
            url = it?.url
        }
    }

    private fun initViews() {
        val bundle = arguments?:return
        val args = PetDetailsFragmentArgs.fromBundle(bundle)
        viewModel.getPet(args.petId)
    }

}