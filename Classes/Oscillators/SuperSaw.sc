// see: https://www.nada.kth.se/utbildning/grukth/exjobb/rapportlistor/2010/rapporter10/szabo_adam_10131.pdf

SuperSaw{
	*ar{|freq=440, detune=0, amp=1|
		var sig, env, sig1, hpf, samp, detune_f;
		samp = -0.73764 * amp.pow(2) + 1.2841 * amp + 0.044372;
		detune_f = {|detune|
			detune=detune;
			(10028.7312891634 * detune.pow(11)) -
			(50818.8652045924 * detune.pow(10)) +
			(111363.4808729368 * detune.pow(9)) -
			(138150.6761080548 * detune.pow(8)) +
			(106649.6679158292 * detune.pow(7)) -
			(53046.9642751875 * detune.pow(6)) +
			(17019.9518580080 * detune.pow(5)) -
			(3425.0836591318 * detune.pow(4)) +
			(404.2703938388 * detune.pow(3)) -
			(24.1878824391 * detune.pow(2)) +
			(0.6717417634 * detune) +
			0.0030115596; };
		detune = detune_f.(detune);
		//detune.poll;
		sig = Mix.new([
			Saw.ar(freq, 0, -0.55366 * amp + 0.99785),  // center
			Saw.ar(detune * -0.11002313 * freq + freq, Rand(0, 0.2) , samp), // osc 1
			Saw.ar(detune * -0.06288439 * freq + freq, Rand(0, 0.2) , samp), // osc 2
			Saw.ar(detune * -0.01952356 * freq + freq, Rand(0, 0.2), samp), // osc 3
			Saw.ar(detune * 0.01991221 * freq + freq, Rand(0, 0.2), samp), // osc 5
			Saw.ar(detune * 0.06216538 * freq + freq, Rand(0, 0.2), samp), // osc 6
			Saw.ar(detune * 0.10745242 * freq + freq, Rand(0, 0.2), samp) // osc 7
		]);
		^HPF.ar(sig,freq -1);
	}
}