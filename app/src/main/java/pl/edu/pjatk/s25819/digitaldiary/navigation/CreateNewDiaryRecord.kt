package pl.edu.pjatk.s25819.przeterminarz.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import pl.edu.pjatk.s25819.digitaldiary.R
import pl.edu.pjatk.s25819.digitaldiary.model.FormType
import pl.edu.pjatk.s25819.digitaldiary.navigation.Destination


class CreateNewDiaryRecord : Destination() {
    override fun navigate(controller: NavController) {
        controller.navigate(
            R.id.nav_to_create, bundleOf(
                "type" to FormType.New
            )
        )
    }

    override fun toString(): String {
        return "Nawigacja do dodania nowego goods"
    }
}