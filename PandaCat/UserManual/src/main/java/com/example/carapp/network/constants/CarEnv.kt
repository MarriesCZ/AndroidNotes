package com.example.carapp.network.constants

/**
 * 当前车机所有环境
 */
enum class CarEnvironment {
    /** 开发环境*/
    DEVELOPMENT,
    /** 预发布环境 */
    TEST,
    /** 预发布环境 */
    STAGING,
    /** 生产环境 */
    PRODUCTION
}

/**
 * 当前车机环境
 * 在需要切换车机环境时修改该值即可
 */
var carEnvironment = CarEnvironment.STAGING

val BASE_URL: String
    get() = when (carEnvironment) {
        CarEnvironment.DEVELOPMENT,
        CarEnvironment.TEST,
        CarEnvironment.STAGING -> "https://reqres.in/api/"
        CarEnvironment.PRODUCTION ->  "https://httpbin.org/"
    }