package com.jsadhu.conduit.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsadhu.api.ConduitClient
import com.jsadhu.api.models.responses.ArticlesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GlobalFeedViewModel : ViewModel() {

    private var _articlesResponse =  MutableLiveData<ArticlesResponse>()
    val articlesResponse : LiveData<ArticlesResponse> get() = _articlesResponse
    private var _isLoading  = MutableLiveData<Boolean>(false)
    val isLoading : LiveData<Boolean> get() = _isLoading

    fun fetchArticleResponse(){
        _isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val conduitClient = ConduitClient()
                val response = conduitClient.api.getArticles()
                _articlesResponse.postValue(response.body())
            }
            catch (e : Exception){
                Log.d("TAG", e.message.toString())
            }
            finally {
                _isLoading.postValue(false)
            }
        }

    }
}