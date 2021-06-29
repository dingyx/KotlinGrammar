package com.sycamore.study.extension

/**
 * @author dingyx
 * @description:  扩展文件
 * @date: 2021/6/29
 */
fun <T> Iterable<T>.randomTake(): T = this.shuffled().first()