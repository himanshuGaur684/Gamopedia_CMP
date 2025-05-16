package gaur.himanshu.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gaur.himanshu.favorite.domain.useCases.DeleteUseCase
import gaur.himanshu.favorite.domain.useCases.GetAllLocalCahcedGamesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getAllLocalCahcedGamesUseCase: GetAllLocalCahcedGamesUseCase,
    private val deleteUseCase: DeleteUseCase
) : ViewModel() {

    val games = getAllLocalCahcedGamesUseCase.invoke().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(),emptyList()
    )

    fun delete(id:Int) = viewModelScope.launch {
        deleteUseCase.invoke(id)
    }


}