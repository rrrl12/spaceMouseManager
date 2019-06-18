package rrrl12.spaceMouseManager

import netP5.NetAddress
import oscP5.OscMessage
import oscP5.OscP5
import processing.core.PApplet

class OscManager(app: PApplet, outAddress: String, outPort: Int, inPort: Int) {

    private val osc = OscP5(app, inPort)
    private val remoteRocation = NetAddress(outAddress, outPort)


    fun sendFloatList(patterns: String, args: List<Float>) {
        val message = OscMessage(patterns)
        args.forEach { arg -> message.add(arg) }
        osc.send(message, remoteRocation)
    }


    fun sendSpaceMouseState(patterns: String, stateL: SpaceMouseState, stateR: SpaceMouseState) {
        val message = OscMessage(patterns).apply {
            stateL.let {
                add(it.rx)
                add(it.ry)
                add(it.rz)
                add(it.x)
                add(it.y)
                add(it.z)
            }
            stateR.let {
                add(it.rx)
                add(it.ry)
                add(it.rz)
                add(it.x)
                add(it.y)
                add(it.z)
            }
        }

        osc.send(message, remoteRocation)
    }

}