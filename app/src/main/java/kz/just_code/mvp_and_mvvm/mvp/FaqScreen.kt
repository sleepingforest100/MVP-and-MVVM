package kz.just_code.mvp_and_mvvm.mvp

import kz.just_code.mvp_and_mvvm.repository.Faq

sealed interface FaqScreen {
    interface View {
        fun showMessage(message: String)
        fun showData(list: List<Faq>)
    }

    interface Presenter {
        fun getData()
        fun openDetails(faq: Faq)

    }

}