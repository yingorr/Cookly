package com.ying.cookly

import androidx.room.Entity
import androidx.room.PrimaryKey

// This table stores the ingredients you need to buy
@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val isChecked: Boolean = false,
    val recipeId: Int? = null // This links the ingredient to a specific recipe!
)