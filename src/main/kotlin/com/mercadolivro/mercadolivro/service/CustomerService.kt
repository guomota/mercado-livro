package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.model.CustomerModel
import com.mercadolivro.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val customerRepository: CustomerRepository
    ) {

    fun getAllCustomers(nome:String?): List<CustomerModel> {
        nome?.let {
            return customerRepository.findByNomeContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun postCostumer(postCustomerModel: CustomerModel) {
        customerRepository.save(postCustomerModel)
    }

    fun updateCustomer(customerModel: CustomerModel) {

        if(!customerRepository.existsById(customerModel.id!!)) {
            throw Exception()
        }
        customerRepository.save(customerModel)
    }

    fun deleteCustomer(id: Int) {
        if(!customerRepository.existsById(id)) {
            throw Exception()
        }
        customerRepository.deleteById(id)
    }
}