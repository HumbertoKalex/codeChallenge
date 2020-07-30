package br.com.codechallenge.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.codechallenge.data.local.database.entity.ProductEntity
import br.com.codechallenge.data.local.database.entity.SavedProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM savedProduct")
    fun getAllSaved(): List<SavedProductEntity>

    @Query("SELECT * FROM product")
    fun getAllProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSavedProduct(product: SavedProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMock(product: List<ProductEntity>)

    @Query("DELETE FROM product WHERE id = :id")
    fun removeProduct(id: String)

    @Query("DELETE FROM savedProduct WHERE id = :id")
    fun removeSavedProduct(id: String)

}