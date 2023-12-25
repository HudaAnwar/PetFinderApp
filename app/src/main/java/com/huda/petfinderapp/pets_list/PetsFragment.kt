package com.huda.petfinderapp.pets_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huda.petfinderapp.databinding.FragmentPetsBinding
import com.huda.petfinderapp.utils.Helper
import com.huda.petfinderapp.utils.OnItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PetsFragment : Fragment() ,OnItemClickListener{
    private var rvListener: RecyclerView.OnScrollListener?=null
    private lateinit var petsAdapter: PetsAdapter
    private lateinit var typesAdapter: TypesAdapter
    private var _binding:FragmentPetsBinding?=null
    private var selectedType:String? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PetsListViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentPetsBinding.inflate(inflater, container, false)
        initViews()
        observeViews()
        return binding.root
    }

    private fun initViews() {
        setPetsAdapter()
        setTypesAdapter()
        binding.loading.visibility = View.VISIBLE
        viewModel.fetchTypes()
        viewModel.getTypes()
        viewModel.fetchPetsByType()
        viewModel.getPetsByType()
    }

    private fun setTypesAdapter() {
        typesAdapter = TypesAdapter(arrayListOf(),this)
        binding.rvTypes.adapter = typesAdapter
    }

    private fun setPetsAdapter() {
        petsAdapter = PetsAdapter(arrayListOf(),this)
        binding.rvPets.adapter = petsAdapter
        rvListener = object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                val totalItemCount = layoutManager.itemCount
                if (lastVisibleItemPosition == totalItemCount - 1) {
                    val hasMorePage =( viewModel.pagination.value?.currentPage?:0) < (viewModel.pagination.value?.totalPages?:0)
                    if (hasMorePage) {
                        binding.pagingLoadingImg.visibility=View.VISIBLE
                        getPetsByType(viewModel.pagination.value?.currentPage!! + 1)
                    }
                }
            }
        }
        rvListener?.let{binding.rvPets.addOnScrollListener(it)}
    }

    override fun onDestroy() {
        super.onDestroy()
        rvListener?.let { binding.rvPets.removeOnScrollListener(it) }
    }

    private fun observeViews() {
        viewModel.errorResponse.observe(viewLifecycleOwner){
            it?.let { it1 -> Helper.showErrorDialog(requireContext(), it1) }
        }
        viewModel.getTypesResponse.observe(viewLifecycleOwner){
            binding.loading.visibility = View.GONE
            it?.let { it1 -> typesAdapter.updateTypes(it1) }
        }
        viewModel.getPetsByTypeResponse.observe(viewLifecycleOwner){
            binding.loading.visibility = View.GONE
            binding.pagingLoadingImg.visibility = View.GONE
            if (!it.isNullOrEmpty()){
                binding.rvPets.visibility = View.VISIBLE
                binding.noData.visibility = View.GONE
                petsAdapter.updatePets(it)
            }else{
                binding.rvPets.visibility = View.GONE
                binding.noData.visibility = View.VISIBLE
            }
        }
    }


    override fun onClick(id: Int) {
        val action = PetsFragmentDirections.viewPetsDetails(id)
        findNavController().navigate(action)
    }

    override fun onClick(name: String) {
        selectedType = if (name=="All")  null else name
        getPetsByType(1)
        viewModel.fetchPetsByType(selectedType)
    }
    private fun getPetsByType(page: Int=1) {
        viewModel.getPetsByType(selectedType, page)
        if (page == 1) {
            binding.rvPets.scrollToPosition(0)
        }
    }

}