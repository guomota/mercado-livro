package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAllCustomers(nome:String?): List<CustomerModel> {
        nome?.let {
            return customers.filter { it.nome.contains(nome, true) }
        }
        return customers
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customers.first { it.id == id }
    }

    fun postCostumer(postCustomerModel: CustomerModel) {

        val id = if(customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }

        postCustomerModel.id = id
        customers.add(CustomerModel(id, postCustomerModel.nome, postCustomerModel.email))
    }

    fun updateCustomer(customerModel: CustomerModel) {
        customers.first { it.id == customerModel.id }.let {
            it.nome = customerModel.nome
            it.email = customerModel.email
        }
    }

    fun deleteCustomer(id: Int) {
        customers.removeIf { it.id == id }
    }
}