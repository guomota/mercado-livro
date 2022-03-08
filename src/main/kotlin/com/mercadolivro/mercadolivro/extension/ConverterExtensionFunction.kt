package com.mercadolivro.mercadolivro.extension

import com.mercadolivro.mercadolivro.model.CustomerModel
import com.mercadolivro.mercadolivro.request.PostCustomerRequest
import com.mercadolivro.mercadolivro.request.PutCustomerRequest

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(nome = this.nome, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, nome = this.nome, email = this.email)
}

