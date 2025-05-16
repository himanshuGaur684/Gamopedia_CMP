package gaur.himanshu.gamopedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform