
Satan{
  *ar{|in, env, knee|
    env = env * 1e-3;
    DelayC.ar(in, 0.01, env * 0.5) * EnvFollow.ar(in, 1 - (env * SampleRate.ir).reciprocal).max(knee).reciprocal;
  }
}