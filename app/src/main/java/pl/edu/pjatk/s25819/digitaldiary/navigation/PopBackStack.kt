package pl.edu.pjatk.s25819.digitaldiary.navigation

import androidx.navigation.NavController

class PopBackStack : Destination() {
    override fun navigate(controller: NavController) {
        controller.popBackStack()
    }

    override fun toString(): String {
        return "Nawiguj do poprzedniego ekranu"
    }
}