package kz.just_code.mvp_and_mvvm.repository

import kz.just_code.mvp_and_mvvm.FaqAdapter
import kz.just_code.mvp_and_mvvm.R
import kz.just_code.mvp_and_mvvm.mvp.FaqPresenter

class FaqRepositoryImplementation : FaqRepository {
    private var faqList: List<Faq> = listOf()
    override fun getFaqLIst(): List<Faq> {
        return if (faqList.isEmpty()) getRemoteFaq()
        else faqList
    }

    private fun getRemoteFaq(): List<Faq> {
        val list: MutableList<Faq> = mutableListOf(
            Faq(0, R.string.title_1, R.string.description),
            Faq(1, R.string.title_2, R.string.description),
            Faq(2, R.string.title_3, R.string.description),
            Faq(3, R.string.title_4, R.string.description),
            Faq(4, R.string.title_5, R.string.description),
            Faq(5, R.string.title_6, R.string.description),
            Faq(6, R.string.title_7, R.string.description),
        )
        faqList = list
        return list
    }
}