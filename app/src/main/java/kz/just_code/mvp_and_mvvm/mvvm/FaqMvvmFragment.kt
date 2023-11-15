package kz.just_code.mvp_and_mvvm.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.mvp_and_mvvm.FaqAdapter
import kz.just_code.mvp_and_mvvm.databinding.FaqListFragmentBinding
import kz.just_code.mvp_and_mvvm.mvp.FaqPresenter
import kz.just_code.mvp_and_mvvm.mvp.FaqScreen
import kz.just_code.mvp_and_mvvm.repository.Faq
import kz.just_code.mvp_and_mvvm.repository.FaqRepository
import kz.just_code.mvp_and_mvvm.repository.FaqRepositoryImplementation

class FaqMvvmFragment : Fragment(){
    private lateinit var binding: FaqListFragmentBinding
    private val adapter: FaqAdapter = FaqAdapter()
    private val viewModel: FaqViewModel = FaqViewModel(FaqRepositoryImplementation())
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FaqListFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listView.layoutManager = LinearLayoutManager(requireContext())
        binding.listView.adapter = adapter

        adapter.click = {
//            findNavController().navigate()
        }

        viewModel.faqListLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }

}