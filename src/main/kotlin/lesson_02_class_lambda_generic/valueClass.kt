package lesson_02_class_lambda_generic

// обертка над примитивным типом
@JvmInline
value class Id(val id: Int) {

    init {
        require(id > 0) {}
    }
}