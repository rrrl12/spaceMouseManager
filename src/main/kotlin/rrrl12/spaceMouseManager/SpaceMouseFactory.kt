package rrrl12.spaceMouseManager

import org.gamecontrolplus.ControlDevice
import org.gamecontrolplus.ControlIO
import processing.core.PApplet


class SpaceMouseFactory(private val app: PApplet) {

    val usedDeviceIdList = ArrayList<Int>()


    fun create(productName: String): SpaceMouse? {
        val control = ControlIO.getInstance(app)

        control.devices.forEachIndexed { id, device ->
            if (id !in usedDeviceIdList && device.name == productName) {
                usedDeviceIdList.add(id)
                return SpaceMouse(control.getDevice(id))
            }
        }
        return null
    }

}