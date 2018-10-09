WavOsc{
  *ar{|bufpos, freq, phase, reset|
    var phs = phase / 2pi;
    BufRd.ar(1, bufpos, phs + Phasor.ar(reset, BufRateScale.kr(b)*freq, 0, BufFrames.kr(b)));
  }
}
