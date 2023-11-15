package kz.just_code.mvp_and_mvvm.mvp

import kz.just_code.mvp_and_mvvm.repository.Faq
import kz.just_code.mvp_and_mvvm.repository.FaqRepository
import kz.just_code.mvp_and_mvvm.repository.FaqRepositoryImplementation

class FaqPresenter(
    private val view: FaqScreen.View
) : FaqScreen.Presenter {
    private val repository: FaqRepository = FaqRepositoryImplementation()

    init {
        getData()
    }

    override fun getData() {
        val data = repository.getFaqLIst()
        view.showData(data)
    }

    override fun openDetails(faq: Faq) {
view.showMessage(faq.description.toString())
    }

}