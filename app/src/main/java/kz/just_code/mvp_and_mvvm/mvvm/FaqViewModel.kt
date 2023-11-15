package kz.just_code.mvp_and_mvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.just_code.mvp_and_mvvm.repository.Faq
import kz.just_code.mvp_and_mvvm.repository.FaqRepository

class FaqViewModel(
    private var repository: FaqRepository
) : ViewModel() {
    private var _faqListLiveData = MutableLiveData<List<Faq>>()
    var faqListLiveData: LiveData<List<Faq>> = _faqListLiveData

    init {
        getData()
    }

    private fun getData() {
        val data = repository.getFaqLIst()
        _faqListLiveData.postValue(data)
    }
}