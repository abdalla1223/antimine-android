package dev.lucasnlm.antimine.about.views.translators

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.lucasnlm.antimine.R
import dev.lucasnlm.antimine.about.viewmodel.AboutViewModel
import kotlinx.android.synthetic.main.fragment_translators.*

class TranslatorsFragment : Fragment(R.layout.fragment_translators) {
    private lateinit var aboutViewModel: AboutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            aboutViewModel = it.viewModels<AboutViewModel>().value
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        translators.apply {
            addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(view.context)
            adapter = TranslatorsAdapter(aboutViewModel.getTranslatorsList())
        }
    }
}
