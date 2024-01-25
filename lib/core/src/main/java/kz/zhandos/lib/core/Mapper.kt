package kz.zhandos.lib.core

interface Mapper<T, B> {

    fun map(from: T): B
}