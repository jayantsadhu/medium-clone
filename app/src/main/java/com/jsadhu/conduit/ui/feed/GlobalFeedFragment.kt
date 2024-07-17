package com.jsadhu.conduit.ui.feed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.jsadhu.conduit.databinding.FragmentGlobalFeedBinding

class GlobalFeedFragment : Fragment(){

    private var _binding : FragmentGlobalFeedBinding? = null
    private val binding get() = _binding!!

    private val model: GlobalFeedViewModel by viewModels()
    private lateinit var rvAdapter : FeedRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGlobalFeedBinding.inflate(inflater, container, false)
//          Toast.makeText(requireContext(), it.articlesCount, Toast.LENGTH_SHORT).show()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeModelView()

        model.fetchArticleResponse()
    }

    private fun observeModelView() {
        model.articlesResponse.observe(viewLifecycleOwner){
            rvAdapter.submitList(it.articles)
            Log.d("TAG", it.articles.size.toString())
        }
        model.isLoading.observe(viewLifecycleOwner) {isLoading ->
            binding.progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
        }
    }

    private fun setUpRecyclerView() {
        rvAdapter = FeedRVAdapter()
        binding.rvGlobalFeed.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvGlobalFeed.adapter = rvAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}