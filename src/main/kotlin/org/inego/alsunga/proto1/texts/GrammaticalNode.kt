package org.inego.alsunga.proto1.texts

interface GrammaticalNode {
    val toText: List<Token>

    fun <T> provide(feature: GrammaticalFeature<T>): T?
    fun <T> accept(feature: GrammaticalFeature<T>, value: T)
}


abstract class AbstractGrammaticalNode : GrammaticalNode {
    protected val internalChildren = mutableListOf<GrammaticalNode>()
    private val dynamicFeatureValues = mutableMapOf<GrammaticalFeature<*>, Any>()

    open fun <T> getIntrinsic(feature: GrammaticalFeature<T>): T? = null;

    override fun <T> provide(feature: GrammaticalFeature<T>): T {
        val intrinsic = getIntrinsic(feature)
        return intrinsic ?: getDynamic(feature)
    }

    override fun <T> accept(feature: GrammaticalFeature<T>, value: T) = setDynamic(feature, value)

    @Suppress("UNCHECKED_CAST")
    protected fun <T> getDynamic(feature: GrammaticalFeature<T>): T = dynamicFeatureValues[feature] as T

    protected fun <T> setDynamic(feature: GrammaticalFeature<T>, value: T) {
        dynamicFeatureValues[feature] = value as Any
    }

    protected fun setDynamic(vararg featureValues: EnumFeatureValue) {
        featureValues.associateByTo(dynamicFeatureValues) { it.feature }
    }
}