package com.ying.cookly

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CooklyDao {

    // 1. Save a new recipe
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: Recipe)

    // 2. Get all recipes to show on the screen
    @Query("SELECT * FROM recipes_table")
    fun getAllRecipes(): Flow<List<Recipe>>

    // 3. Save an ingredient to the shopping list
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(item: ShoppingItem)

    // 4. Get the shopping list (Flow keeps it updated automatically)
    @Query("SELECT * FROM shopping_table")
    fun getShoppingList(): Flow<List<ShoppingItem>>

    // 5. Update an item (like checking a box)
    @Update
    suspend fun updateShoppingItem(item: ShoppingItem)
}