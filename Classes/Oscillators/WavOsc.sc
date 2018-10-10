/* Note, these oscillators currently assume that you only have one server up and running.
At some point I will fix so that this works appropriately.
*/

WavHarmOsc{
	classvar buf;
	*bufAlloc{ |server, spectrumFunc, baseFreq=40|
		// C0 is 32
		var numbufs = (server.sampleRate.log2 - baseFreq.log2).asInteger;
		var numFrames = 2048;
		// default is sawtooth
		server = server ? Server.default;

		"numbuffers: ".postln; numbufs.postln;
		^Buffer.allocConsecutive(numbufs, server, numFrames, 1, { |buf, i|
			var	numharm = (server.sampleRate * 0.5 / baseFreq).asInteger;
			"numharm: ".post; numharm.postln;
			"base: ".post;
			baseFreq.postln;
			baseFreq = baseFreq * 2;
			buf.sine1Msg(spectrumFunc.(numharm));
		});
	}
	*ar{|freq = 440, phase = 0, mul = 1, add = 0|
		var baseFreq, numBufs, freqMap;
		this.initBuffer();
		baseFreq = 40;	// base frequency of first buffer
		numBufs = 8;
			// note that subtraction of logs corresponds to division of original values
		freqMap = (freq/baseFreq).log2.clip(0, numBufs-1);

		^VOsc.ar(buf.first.bufnum + freqMap, freq, phase, mul, add);
	}
}

WavSaw : WavHarmOsc{

	*initBuffer{|server|
		var basefreq = 40;
		if(buf == nil){
			server = server ? Server.default;
			buf = WavHarmOsc.bufAlloc(server, { |numharm| (1..numharm).reciprocal }, 40);
		}
	}


}

WavTri : WavHarmOsc{

	*initBuffer{|server|
		var basefreq = 40;
		if(buf == nil){
			server = server ? Server.default;
			buf = WavHarmOsc.bufAlloc(server, { |topPartial = 20| [(1, 3 .. topPartial).reciprocal.squared * #[1, -1], 0].lace(topPartial) } , 40);
		}
	}

}