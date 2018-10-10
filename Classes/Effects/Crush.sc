// Basic bitcrusher, but effective.
Crush
{
  *ar{|in|
    Latch.ar(in, Impulse.ar(LFNoise0.kr(5).lag(0.1).exprange(1000, 16000)));
  }
}