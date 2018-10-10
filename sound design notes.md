# Plucks

The pluck takes a lowpass filter and quickly sweeps its cutoff frequency downward (in insider
jargon, "closing" the filter). this makes the initial transient more interesting to listen to -- the sound is bright on impact but quickly gets muted.

one immediate way to make this more fun is to use a resonant lowpass filter. with moderate resonance, the lumpy frequency response adds timbral complexity. with high resonance, you get a raygun "pew pew pew" effect.

the trajectory of the filter's cutoff can be considered an envelope signal. we've only discussed a decay stage, but adding a very fast attack stage can also make the pluck interesting. opening a lowpass filter on attack approximates the slow brightening effect that can be heard on some brass instruments, and very prominently on a steel pan.


## Pitch Bending
the TR-808 and TR-909 may not have been the first devices to use pitch bending to design transients, but they very much popularized the effect in their bass drum circuits. the bass drum circuit is a sine wave that very rapidly drops in pitch. in the 808, the sine wave is cleverly implemented with a highly resonant bandpass filter with a swept center frequency.

this doesn't just work for percussion, it also works for tonal sounds. it adds a very nice percussive click or twang to any instrument if the bend is fast enough. it works similarly to the pluck, but by bending the actual oscillator rather than a filter frequency.

## Noise Bursts

noise bursts are easy -- it's just a bit of broadband or narrowband noise with a sharp attack and decay. a well-used noise burst blends in well with the other components of your transient and is almost more felt than heard.

narrowband noise is generally easiest to create using white noise through a sharp bandpass. for broadband noise, i find pink noise more acoustically natural -- you're using a wider frequency range and the db-per-octave slope of your noise source starts to matter. even for broadband noise, it's usually wise to keep the frequency range localized with a wide bandpass filter.

in line with the complexity principle, modulating the noise's frequency or bandwidth can help for longer noise bursts.

## Oscillators

Oscillators
-----------

let me get one thing out of the way: i absolutely adore pulse oscillators, and they have rapidly replaced saws in my book. unlike saws and triangles, pulse oscillators allow you to control balance between even and odd harmonics, and the pulse width can be modulated. you're probably thinking "yeah no shit sherlock," but both static and dynamic even/odd harmonic balance control are excellent sources of synthetic complexity.

Gendy1 is also a really cool warbly sound source -- just set the minimum and maximum frequencies to the same value and it'll produce a static rather than wandering tone.

Detuned oscillators
-------------------

when multiple oscillators are played with a small pitch difference between them, the oscillators go in and out of phase, resulting in sizzling artifacts. these artifacts add time variation and complexity, and complexity adds interest and organic qualities.

detuned oscillators are a classic effect in synthesis. used in an obvious manner, they can sound like very typical patches used in dance music, such as the "super saw" found in trance and EDM. more subtly, detuned oscillators are the key to string ensembles and pads. they're also highly responsible for the sound of the piano, but i'm not here to imply that a piano is an easy thing to synthesize.


### Linear vs. exponential detuning

the beating heard between two oscillators is simply the difference between the two frequency values. it's interesting that this beating is on a linear frequency scale, but we perceive pitch on a roughly exponential scale, and these two contrasting scales interact with each other. the impact:

- if beating is given by a constant frequency ratio, beating will be slower for bass pitches and faster for treble pitches. if the ratio is wide enough and the pitch high enough, the two oscillators will separate and may sound dissonant.
- if beating is given by a constant frequency difference, the frequency ratio becomes wider in the bass range and may sound dissonant.

as i write this, i just realized that we could use a compromise curve between linear and exponential frequency so we can map parameters in a perceptually uniform way. the ideal curve might be based on the mel or bark scales, which are based on critical bandwidths in the human hearing system. i haven't played with this yet, but maybe you can.

a good tip to keep in mind: our ears are very sensitive to timbral oscillations in the 4-8 Hz range. down to 1 Hz or below, beating starts sounding less like it's oscillating and more like it's evolving. this is good to know when working with any kind of LFO, honestly.

it's worth noting that detuned oscillators add out-of-tune pitch components. within traditional discipline, sound designers like to minimize tonal clutter in the sub-bass and bass range. so to keep things sounding subjectively "professional," detuning should be kept subtle in the bass range, and probably shouldn't be used at all for a sub. but this advice is specifically for traditional production values, and rules are made to be broken!

### Detuning tips

generally, i've found that somewhere around 7 oscillators is good enough for a very full ensemble sound. you can try more, but watch the CPU usage and weigh the disadvantages for yourself.

detuning can sound dissonant if too out of tune. first, make sure to center all the oscillator pitches around the pitch rather than making them lopsided. to get more subtle control over the effect, you can make the center pitch louder than the others.

the pitches don't need to be static. even gentle modulations of the individual oscillator pitches can greatly increase the complexity of the beating. randomized modulations (or for that matter, randomized pitches) can ensure that no two notes sound the same.

try spreading oscillators across different octaves for a fuller, orchestral sound.

there's no need for all the detuned oscillators to be the same kind of oscillator. one of my favorite pad formulas is to use a bunch of pulse waves with randomly modulated pulse widths and pitches. despite its simplicity, the result is beautiful and teeming with complexity.

### Chorus and flanger

it's worth pointing out that chorus and flanger produce very similar effects to oscillator detuning. they have advantages and disadvantages depending on CPU usage, but the chorus has a feature that oscillators don't have: feedback, which allows infinitely many voices to build up over time. using just a few oscillators and a well-designed chorus effect can get you a huge ensemble sound with very few components!

### Color Reverb

individual styles vary, but a lot of recording engineers will tell you that just having one or two reverbs in a mix can help keep the sense of space coherent. rather than using an individual reverb on each track, each track has a different send amount to the same reverb. admittedly it's probably a bit of a holdover from the era when reverbs were expensive physical objects, but it's still pretty good advice. for example, in very "wet" styles of music music, two reverbs is a wise idea: one reverb for subtle space, one reverb for super long spacy stuff.

in sound synthesis, i suggest bending this rule. the sound sources we work with are very dry, and adding a subtle reverb on each instrument gives individual coloration. coloration means character.

i call this "color reverb" and it turns out you don't even need a good reverb to accomplish it. one of my secret tricks for acoustic instruments is to make an intentionally crappy reverb with a bunch of randomly tuned mildly resonant comb filters in parallel. such a filter has a lumpy frequency response with weird metallic resonances and wolf tones. tuned for subtlety, it really ups the realism of an acoustic instrument. different mixes of comb filters to the left and right channels also give some spatialization, but you might not need that -- you should be sending it to another 'verb anyway.

### Stereo image

there is nothing close to a consensus about how to use stereo image, and the style you use is all part of your artistic practice. that said, many producers would agree that having any kind of stereo image is pretty essential for making electronic music come alive.

a simple and perfectly serviceable method is to make all instruments mono, pan them around, and polish the stereo with tasteful reverb.

some instruments, however, can benefit from having stereo right off the bat. for example, back up in the section on oscillator detuning, you can make pads sound much wider by spreading the detuned oscillators around the stereo field. using multichannel expansion to create a bunch of parallel, slightly different copies of something and then spreading them around with `Splay.ar` is an incredibly fun SC-exclusive trick that i have to watch myself not to overuse. more conventionally, flangers, chorus, and tremolo are all effects that adapt easily for stereo.

my recommendation on working with this in SC is to output stereo audio to a bus, then use `Balance2` as a post-panning stage. i'd also recommend using a super wide stereo image at first and then narrowing it, but admittedly i haven't thought about what a good stereo narrowing formula is yet.

if you're feeling adventurous, i recommend playing around with Haas panning for a cool immersive mix. to Haas pan a mono signal X, play X into the left channel, and play a slightly delayed version of X into the right channel. for more realism, lowpass filter the delayed channel. done right, it can give the impression of sound sources outside the speakers or headphones.

conventionally, the Haas effect is not super common, and when used, found on only some elements of the mix. my guess is that 1. the effect isn't easily accessible in most DAWs, 2. it can create a comb filtering effect when reduced to mono, and 3. the benefits of the effect are not as stunning on speaker systems as they are on headphones. but since you use SuperCollider, you're probably inherently less worried about tradition, so have at it.

# Using Combs

You tune a comb by setting the delay time to be the reciprical of the frequency.

Can get interesting aggressive sounds by pumping noise through it. Pink noise is more musical, white
noise is more aggressive.

```
   snd = CombC.ar(LeakDC.ar({ PinkNoise.ar }.dup(2)), freq.reciprocal, freq.reciprocal, 5);
    snd = LeakDC.ar(snd);
```
Mostly bass lines, but with BPF could definitely make an aggressive lead, or may even an interesting
pad with suitable LPF, maybe with some subtle variation in amount of low passing

# Pads

+ Mixing pulse waves at two different octaves can be effective
  + modulate the pitches by 0.05.midiratio
  + modulate the pulsewidth (maybe 0.3 to 0.7)

+ Spread across the stereo field using Splay (determine where they end up with spread and center)
+ Reduce high frequencies with sharp hi cut
  + ```3.do { snd = LPF.ar(snd, \ffreq.kr(1500)); };```
  + Obviously use big chords. Obviously
+ Playing around with noise (particularly pink noise) through a resonanz filter. Particularly nice
if you mess with bandwidth, detuning etc.
+ Additive synthesis with sinosc, with some detuning

# Bit Crushing
snd = Latch.ar(snd, Impulse.ar(LFNoise0.kr(5).lag(0.1).exprange(1000, 16000)));