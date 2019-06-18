package rrrl12.spaceMouseManager


import processing.core.*
import org.gamecontrolplus.ControlIO



fun main(args: Array<String>) = PApplet.main("rrrl12.spaceMouseManager.Main")


class Main : PApplet() {

    private var spaceMouseL: SpaceMouse? = null
    private var spaceMouseR: SpaceMouse? = null

    private lateinit var factory: SpaceMouseFactory

    private lateinit var oscManager: OscManager

    override fun settings() {
        size(200, 200)
    }


    override fun setup() {
        factory = SpaceMouseFactory(this)
        spaceMouseL = factory.create("SpaceMouse Wireless")
        spaceMouseR = factory.create("SpaceMouse Wireless")
        println(factory.usedDeviceIdList)

        oscManager = OscManager(this, "127.0.0.1", 12000, 11999)
    }


    override fun draw() {
        val mouseStateL = spaceMouseL?.getState()
        val mouseStateR = spaceMouseR?.getState()

        println(spaceMouseL?.getState())


        oscManager.sendSpaceMouseState("/mouse", mouseStateL!!, mouseStateR!!)

    }
}