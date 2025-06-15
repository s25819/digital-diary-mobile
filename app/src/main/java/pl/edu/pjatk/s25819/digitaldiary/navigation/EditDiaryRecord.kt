package pl.edu.pjatk.s25819.digitaldiary.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import pl.edu.pjatk.s25819.digitaldiary.R
import pl.edu.pjatk.s25819.digitaldiary.model.DiaryRecord
import pl.edu.pjatk.s25819.digitaldiary.model.FormType

class EditDiaryRecord(private val diaryRecord: DiaryRecord) : Destination() {
    override fun navigate(controller: NavController) {
        controller.navigate(
            R.id.nav_to_create, bundleOf(
                "type" to FormType.Edit(diaryRecord.id)
            )
        )
    }

    override fun toString(): String {
        return "Nawiguj do okna edycji istniejącego wpisu"
    }
}