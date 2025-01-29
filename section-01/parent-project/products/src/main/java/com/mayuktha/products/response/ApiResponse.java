package com.mayuktha.products.response;


public record ApiResponse<T>(int statusCode,String status,String message,T data) {}
