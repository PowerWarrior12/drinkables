package com.example.drinkables.domain.interactors

import com.example.drinkables.data.repositories.FavouriteDrinksRepository
import com.example.drinkables.domain.entities.Drink
import kotlinx.coroutines.async
import javax.inject.Inject

class UpdateDrinksFavouritesInteractor @Inject constructor(
    private val favouriteDrinksRepository: FavouriteDrinksRepository
) {
    suspend fun run(drinks: MutableList<Drink>): MutableList<Drink> {
        val favourites = favouriteDrinksRepository.getFavouritesDrinkids()
        drinks.forEach { drink ->
            drinks[drinks.indexOf(drink)] = drink.copy(favourites = favourites.contains(drink.id))
        }
        return drinks
    }
}