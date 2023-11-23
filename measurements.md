# Mac Pro (3,5 GHz 6-Core Intel Xeon E5, 32 GB 1866 MHz DDR3)

- With data races (10 * 10^7): Has data races, 11.406ms
- No data races? (10 *10^3): No data races? Sometimes!, 0.327ms
- Atomic Integer (10 * 10^7): No data races, 266.254ms
- Synchronized method (10 * 10^7): No data races, 7.791ms