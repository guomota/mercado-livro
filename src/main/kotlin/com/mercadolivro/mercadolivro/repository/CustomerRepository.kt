package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int>{

    fun findByNomeContaining(nome: String): List<CustomerModel>
}