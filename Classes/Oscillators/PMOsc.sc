PMPulse{
	*ar{|freq = 440, width = 0.5, phase = 0, mul = 1, add = 0|
		var delay;
		phase = phase.mod(2pi);
		delay = freq * (phase / (2pi));
		^DelayL.ar(Pulse.ar(freq, width, mul,add),1/(freq-10),delay)
	}
}

PMSaw{
	*ar{|freq = 440, width = 0.5, phase = 0, mul = 1, add = 0|
		^Pulse.ar(freq * 2, width) * WavSaw.ar(freq, phase, mul, add);
	}
}