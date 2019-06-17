package rrrl12.spaceMouseManager

data class SpaceMouseState(
    val rx: Float,
    val ry: Float,
    val rz: Float,
    val x: Float,
    val y: Float,
    val z: Float,
    val btnL: Boolean,
    val btnR: Boolean
)