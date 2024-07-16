package com.jsadhu.conduit.ui.feed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsadhu.conduit.databinding.FragmentGlobalFeedBinding

class GlobalFeedFragment : Fragment(){

    private var _binding : FragmentGlobalFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGlobalFeedBinding.inflate(inflater, container, false)
        val model = ViewModelProvider(this).get(GlobalFeedViewModel::class.java)
        var rvAdapter : FeedRVAdapter

        model.fetchArticleResponse()
        model.articlesResponse.observe(viewLifecycleOwner){
//            Toast.makeText(requireContext(), it.articlesCount, Toast.LENGTH_SHORT).show()
            rvAdapter = FeedRVAdapter(requireContext(), it.articles.subList(0, Math.min(20, it.articles.size)))
            binding.rvGlobalFeed.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.rvGlobalFeed.adapter = rvAdapter
            Log.d("TAG", it.articles.size.toString())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}