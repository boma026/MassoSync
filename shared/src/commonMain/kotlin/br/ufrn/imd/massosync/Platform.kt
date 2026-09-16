package br.ufrn.imd.massosync

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
