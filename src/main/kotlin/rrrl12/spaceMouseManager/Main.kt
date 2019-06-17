package rrrl12.spaceMouseManager


import processing.core.*
import org.gamecontrolplus.ControlDevice
import org.gamecontrolplus.ControlIO
import org.gamecontrolplus.ControlSlider



fun main(args: Array<String>) = PApplet.main("rrrl12.spaceMouseManager.Main")


class Main : PApplet() {

    private var spaceMouseL: SpaceMouse? = null
    private var spaceMouseR: SpaceMouse? = null

    lateinit var factory: SpaceMouseFactory

    var device: ControlDevice? = null
    var slider: ControlSlider? = null
    override fun settings() {
        size(200, 200)
    }


    override fun setup() {
        val control = ControlIO.getInstance(this)
        val deviceList = control.devices.toList()
        println(deviceList)

        factory = SpaceMouseFactory(this)
        spaceMouseL = factory.create("SpaceMouse Wireless")
        spaceMouseR = factory.create("SpaceMouse Wireless")
        println(factory.usedDeviceIdList)

    }


    override fun draw() {
        println(spaceMouseL?.getState())
    }
}