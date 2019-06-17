package rrrl12.spaceMouseManager

import org.gamecontrolplus.*

class SpaceMouse(val device: ControlDevice) {

    val productName = device.name

    fun getX() = device.getSlider(5).value

    fun getState(): SpaceMouseState = device.run {
        SpaceMouseState(
            rx = getSlider(1).value,
            ry = getSlider(2).value,
            rz = getSlider(0).value,
            x = getSlider(5).value,
            y = getSlider(4).value,
            z = getSlider(3).value,
            btnL = getButton(0).value > 7,
            btnR = getButton(1).value > 7
        )
    }
}