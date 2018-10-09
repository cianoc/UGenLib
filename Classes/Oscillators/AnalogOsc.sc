AnalogSynth{
	*freqJitter{|freq|
		LFNoise1.kr(1).range(freq.cents(-3), freq.cents(3));
	}

	*phase{|phase|
		phase + Rand(0, 2 * pi);
	}
}

AnalogSin{
	*ar{|freq, phase=0, mul=1, add=0|
		SinOsc.ar(AnalogSynth.freqJitter(freq), phase , mul, add);
	}
	*kr{|freq, phase=0, mul=1, add=0|
		SinOsc.kr(AnalogSynth.freqJitter(freq), phase , mul, add);
	}
}

FreeAnalogSin{
	*ar{|freq, phase=0, mul=1, add=0|
		Sin.ar(AnalogSynth.freqJitter(freq), AnalogSynth.phase(phase), mul, add);
	}
	*kr{|freq, phase=0, mul=1, add=0|
		Sin.kr(AnalogSynth.freqJitter(freq), AnalogSynth.phase(phase), mul, add);
	}
}

AnalogTri{
	*ar{|freq, phase=0, mul=1, add=0|
		WavTri.ar(AnalogSynth.freqJitter(freq), phase , mul, add);
	}
	*kr{|freq, phase=0, mul=1, add=0|
		WavTri.kr(AnalogSynth.freqJitter(freq), phase , mul, add);
	}
}

FreeAnalogTri{
	*ar{|freq, phase=0, mul=1, add=0|
		WavTri.ar(AnalogSynth.freqJitter(freq), AnalogSynth.phase(phase), mul, add);
	}
	*kr{|freq, phase=0, mul=1, add=0|
		WavTri.kr(AnalogSynth.freqJitter(freq), AnalogSynth.phase(phase), mul, add);
	}
}

AnalogSaw{
	*ar{|freq, phase=0, mul=1, add=0|
		WavSaw.ar(AnalogSynth.freqJitter(freq), phase , mul, add);
	}
	*kr{|freq, phase=0, mul=1, add=0|
		WavSaw.kr(AnalogSynth.freqJitter(freq), phase , mul, add);
	}
}

FreeAnalogSaw{
	*ar{|freq, phase=0, mul=1, add=0|
		WavSaw.ar(AnalogSynth.freqJitter(freq), AnalogSynth.phase(phase), mul, add);
	}
	*kr{|freq, phase=0, mul=1, add=0|
		WavSaw.kr(AnalogSynth.freqJitter(freq), AnalogSynth.phase(phase), mul, add);
	}
}