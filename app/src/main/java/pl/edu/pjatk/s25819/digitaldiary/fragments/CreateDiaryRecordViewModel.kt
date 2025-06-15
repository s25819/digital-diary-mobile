package pl.edu.pjatk.s25819.digitaldiary.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.edu.pjatk.s25819.digitaldiary.http.RetrofitClient
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord

class CreateDiaryRecordViewModel : ViewModel() {
    private val _created = MutableLiveData<Boolean>()
    val created: LiveData<Boolean> = _created

    fun create(title: String, content: String, location: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                RetrofitClient.api.createRecord(
                    DiaryRecord(id = 0, title = title, content = content, location = location)
                )
                _created.postValue(true)
            } catch (e: Exception) {
                _created.postValue(false)
            }
        }
    }
}