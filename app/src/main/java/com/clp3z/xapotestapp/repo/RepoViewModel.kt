package com.clp3z.xapotestapp.repo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clp3z.xapotestapp.base.database.LocalDatabaseDAO
import com.clp3z.xapotestapp.base.generic.GenericViewModel
import com.clp3z.xapotestapp.repository.database.RepositoryQuery
import kotlinx.coroutines.launch

/**
 * Created by Clelia López on 10/19/20
 */
class RepoViewModel(
    application: Application,
    database: LocalDatabaseDAO,
    id: Int
):
    GenericViewModel<RepoModel>(application, RepoModel(database, id)) {

    /**
     * Retrieves repository from database and updates via LiveData
     */
    private var _repository = MutableLiveData<RepositoryQuery>()
    val repository: LiveData<RepositoryQuery>
        get() = _repository


    override fun fetch() {
        uiScope.launch {
            _repository.value = model.getRepositoryById()
        }
    }

    override fun handleClick(id: Int) {
        // Does nothing
    }
}